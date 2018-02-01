class vertice:

    def __init__(self, value):
        self.value = value
        self.visited = False
        self.dependence = 0

    def __str__(self):
        return 'Vertice: {}'.format(self.value)

    def __repr__(self):
        return 'Vertice()'


class edge:

    def __init__(self, a, b, weight=0):
        self.a = a
        self.b = b
        self.weight = weight

    def __str__(self):
        return 'Vertice {} and Vertice {}'.format(self.a, self.b)

    def __repr__(self):
        return 'Edge()'

    def revert_edge(self):
        self.a, self.b = self.b, self.a


class graph:

    def __init__(self, vertices=set(), edges=set(), gtype='graph'):
        self.vertices = vertices
        self.edges = edges
        self.visiteds = []
        self.explored = []
        self.type = gtype

    def __str__(self):
        string = ''
        for i in self.vertices:
            string += str(i) + ' ['
            string += ', '.join([str(v) +
                                 '(*)' if v.visited else str(v) + '()' for v in self.get_adjacents(i)])
            string += ']\n'
        return string

    def get_adjacents(self, v):
        adj = []
        if self.type == 'graph':
            for edge in self.edges:
                if edge.a == v:
                    adj.append(edge.b)
                elif edge.b == v:
                    adj.append(edge.a)
        else:
            for edge in self.edges:
                if edge.a == v:
                    adj.append(edge.b)

        return adj

    def is_complete(self):
        for v in self.vertices:
            if len(self.get_adjacents(v)) != len(self.vertices) - 1:
                return False
        return True

    def is_regular(self):
        base = len(self.get_adjacents(next(iter(self.vertices))))
        for v in self.vertices:
            if base != len(self.get_adjacents(v)):
                return False
        return True

    def get_next(self, array):
        for v in array:
            if not v.visited:
                return v

    def get_not_visited(self):
        for v in self.vertices:
            if not v.visited:
                return v

    def dfs_search(self, v=None):
        if not v:
            v = next(iter(self.vertices))
        self.visiteds.clear()
        self.explored.clear()
        for i in self.vertices:
            i.visited = False
        while v:
            self.__dfs_search_vertice(v)
            v = self.get_not_visited()

    def __dfs_search_vertice(self, v):
        v.visited = True
        self.visiteds.append(v)
        stack = []
        stack.append(v)
        while stack:
            adj = self.get_adjacents(stack[- 1])
            w = self.get_next(adj)
            if w:
                w.visited = True
                self.visiteds.append(w)
                stack.append(w)
            else:
                self.explored.append(stack.pop())

    def is_connected(self):
        for v in self.vertices:
            v.visited = False
        conected = 0
        while v:
            self.__dfs_search_vertice(v)
            v = self.get_not_visited()
            conected += 1
        if conected == 1:
            return True
        return False

    def bfs_search(self, v=None):
        if not v:
            v = next(iter(self.vertices))
        self.visiteds.clear()
        self.explored.clear()
        for i in self.vertices:
            i.visited = False
        while v:
            self.__bfs_search_vertice(v)
            v = self.get_not_visited()

    def __bfs_search_vertice(self, v):
        queue = []
        v.visited = True
        self.visiteds.append(v)
        queue.append(v)
        while queue:
            adj = self.get_adjacents(queue[0])
            for w in adj:
                if not w.visited:
                    w.visited = True
                    self.visiteds.append(w)
                    queue.append(w)
            self.explored.append(queue.pop(0))

    def __minor_edge(self, s):
        minor = 9999999
        minor_edge = None
        for v in s:
            for w in self.get_adjacents(v):
                if w not in s:
                    edgevw = self.__get_edge(v, w)
                    if edgevw.weight < minor:
                        minor = edgevw.weight
                        minor_edge = edgevw
        return minor_edge

    def __get_edge(self, v, w):
        for edge in self.edges:
            if (edge.a == v and edge.b == w) or (edge.a == w and edge.b == v):
                return edge

    def __touching_edge(self, s, edge):
        if edge.a in s:
            return edge.b
        elif edge.b in s:
            return edge.a

    def prim(self):
        s = {next(iter(self.vertices))}
        tree = set()
        while s != self.vertices:
            edge = self.__minor_edge(s)
            s.add(self.__touching_edge(s, edge))
            tree.add(edge)

        return sum([x.weight for x in tree])

    def __closer(self, s):
        minor = 999999
        aux = None
        for v in self.vertices:
            if v not in s:
                if minor >= v.distance:
                    aux = v
                    minor = v.distance
        return aux

    def dijkstra(self, v):

        if not v:
            v = next(iter(self.vertices))
        for i in self.vertices:
            i.visited = False
        self.visiteds.clear()
        self.explored.clear()
        s = {v}
        for i in self.vertices:
            if i == v:
                i.distance = 0
            else:
                i.distance = 9999999
            i.path = None

        while s != self.vertices:
            v = self.get_next(s)
            v.visited = True
            self.visiteds.append(v)
            adj = self.get_adjacents(v)

            for w in adj:
                if w.distance > v.distance + self.__get_edge(v, w).weight:
                    w.distance = v.distance + self.__get_edge(v, w).weight
                    w.path = v

            aux = self.__closer(s)
            s.add(aux)
            self.explored.append(aux)

        string = 'Vertice:\tS:\tdist:\tpath:\n'
        for v in self.vertices:
            string += '{}\tYes\t{}\t{path}\n'.format(
                v, v.distance, path=v.path if v.path else '-')
        return string

    def __invert_edges(self):
        for edge in self.edges:
            edge.revert_edge()

    def components_strongly_connected(self):
        '''
        Return components strongly connectex of graph
        '''
        pass

    def is_strongly_connected(self):
        self.dfs_search()
        last = self.explored[-1]
        for v in self.vertices:
            v.visited = False
        self.explored.clear()
        self.visiteds.clear()
        self.__invert_edges()
        self.__dfs_search_vertice(last)
        self.__invert_edges()
        conected = True
        if len(self.explored) == len(self.vertices):
            return True
        return False

    def __generate_denpendence(self):
        for v in self.vertices:
            adj = self.get_adjacents(v)
            for w in adj:
                w.dependence += 1

    def topological_sorting(self):
        order = ''
        self.__generate_denpendence()
        independents = []
        for v in self.vertices:
            if v.dependence == 0:
                independents.append(v)
        while independents:
            n = independents.pop(0)
            order += n.value + ' '
            for v in self.get_adjacents(n):
                v.dependence -= 1
                if v.dependence == 0:
                    independents.append(v)

        test = order.split()
        if len(test) != len(self.vertices):
            return 'Sorting is impossible'
        return order

    def group_topological_sorting(self, size):
        # TODO FIX BUG
        groups = []
        order = ''
        self.__generate_denpendence()
        independents = []
        for v in self.vertices:
            if v.dependence == 0:
                independents.append(v)
        while independents:
            aux = independents[:]
            for v in aux:
                adj = self.get_adjacents(v)
                for w in adj:
                    w.dependence -= 1
                    if w.dependence == 0:
                        independents.append(w)
            for i in range(len(aux)):
                order += str(aux[i].value) + ' '
                if len(order.strip().split(' ')) == size:
                    groups.append(order)
                    order = ''
            groups.append(order)
            order = ''
            for x in aux:
                independents.remove(x)
        string = ''
        for i in range(len(groups)):
            if groups[i]:
                string += 'Group {}: {}\n'.format(i, groups[i])
        return string

'''
   --------v3
  /       /
v1 --- v2 --- v4

v5 --- v6  


'''
# v1, v2, v3 = vertice(1), vertice(2), vertice(3)
# v4, v5, v6 = vertice(4), vertice(5), vertice(6)

# e1, e2, e3 = edge(v1, v2), edge(v2, v3), edge(v1, v3)
# e4, e5, e6 = edge(v3, v4), edge(v5, v6), edge(v2, v3)
# edges = {e1, e2, e3, e4, e5, e6}
# vertices = {v1, v2, v3, v4, v5, v6}

# g = graph(vertices, edges, 'digraph')
# print(g)
# print(g.group_topological_sorting(2))
