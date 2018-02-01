class node:

    def __init__(self, value, next_node=None, prev_node=None):
        self.value = value
        self.next = next_node
        self.prev = prev_node

    def __str__(self):
        return 'Value: {}'.format(self.value.__str__())

    def __repr__(self):
        return 'Node()'


class linked_list:

    def __init__(self):
        self.start = None
        self.end = None
        self.size = 0

    def __str__(self):
        return ' <-> '.join([str(x) for x in self.toArray()])

    def __repr__(self):
        return 'LinkedList()'

    def __iter__(self):
        return Iterator(self)

    def __findNodeIndex(self, index):
        if index > self.size / 2:
            aux = self.end
            for i in range(self.size - 1, index, -1):
                aux = aux.prev
        else:
            aux = self.start
            for i in range(index):
                aux = aux.next
        return aux

    def __findNodeValue(self, value):
        aux = self.start
        for i in range(self.size):
            if aux.value == value:
                return aux
            aux = aux.next
        return None

    def insert_start(self, value):
        newNode = node(value)
        if self.size == 0:
            self.start = self.end = newNode
        else:
            self.start.prev = newNode
            newNode.next = self.start
            self.start = newNode
        self.size += 1

    def insert_end(self, value):
        newNode = node(value)
        if self.size == 0:
            self.start = self.end = newNode
        else:
            self.end.next = newNode
            newNode.prev = self.end
            self.end = newNode
        self.size += 1

    def insert(self, value, index=None):

        if not index:
            self.insert_end(value)
        elif index > self.size - 1:
            raise IndexError('Index Out of Bounds')
        elif index < 0:
            raise IndexError('Index Out of Bounds')
        elif index == 0:
            self.insert_start(value)
        elif index == self.size - 1:
            self.insert_end(value)
        else:
            aux = self.__findNodeIndex(index)
            newNode = node(value, aux.next, aux)
            aux.next.prev = newNode
            aux.next = newNode
            self.size += 1

    def get(self, index):
        if index > self.size - 1:
            raise IndexError('Index Out of Bounds')
        elif index < 0:
            raise IndexError('Index Out of Bounds')
        elif self.size == 0:
            return None
        else:
            return self.__findNodeIndex(index)

    def contain(self, value):
        if self.size == 0:
            return False
        elif self.size == 1:
            return self.start.value == value
        return self.__findNodeValue(value).value == value

    def removeIndex(self, index):
        if index > self.size - 1:
            raise IndexError('Index Out of Bounds')
        elif index < 0:
            raise IndexError('Index Out of Bounds')
        elif index == 0:
            aux = self.start
            self.start = self.start.next
            del aux
        elif index == self.size - 1:
            aux = self.end
            self.end = self.end.prev
            del aux
        else:
            aux = self.__findNodeIndex(index)
            aux.prev.next = aux.next
            aux.next.prev = aux.prev
            del aux
        self.size -= 1

    def removeValue(self, value):
        aux = self.__findNodeValue(value)
        aux.prev.next = aux.next
        aux.next.prev = aux.prev
        del aux
        self.size -= 1

    def toArray(self):
        aux = self.start
        array = []
        while aux != None:
            array.append(aux.value)
            aux = aux.next
        return array


class Iterator:

    def __init__(self, linked_list):
        self.aux = linked_list.start

    def __iter__(self):
        return self

    def __next__(self):
        if self.aux:
            aux = self.aux
            self.aux = self.aux.next
            return aux
        else:
            raise StopIteration
