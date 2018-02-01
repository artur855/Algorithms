class node:

    def __init__(self, value, next_node=None):
        self.value = value
        self.next = next_node

    def __str__(self):
        return 'Value: {}'.format(self.value.__str__())

    def __repr__(self):
        return 'Node()'


class queue:

    def __init__(self, start=None):
        self.start = start
        self.size = 0
        self.end = None

    def __str__(self):
        return ' -> '.join([str(x) for x in self])

    def __repr__(self):
        return 'Queue()'

    def __iter__(self):
        return Iterator(self)

    def first(self):
        return self.start.value

    def add(self, value):
        newNode = node(value)
        if self.size == 0:
            self.start = self.end = newNode
        else:
            self.end.next = newNode
            self.end = newNode
        self.size += 1

    def pop(self):
        if self.size == 0:
            return None
        else:
            aux = self.start.value
            self.start = self.start.next
            self.size -= 1
            return aux

    def toArray(self):
        aux = self.start
        array = []
        while aux != None:
            array.append(aux)
            aux = aux.next
        return array

    def is_empty(self):
        return self.size == 0


class Iterator:

    def __init__(self, queue):
        self.aux = queue.start

    def __iter__(self):
        return self

    def __next__(self):
        if self.aux:
            aux = self.aux
            self.aux = self.aux.next
            return aux
        else:
            raise StopIteration
