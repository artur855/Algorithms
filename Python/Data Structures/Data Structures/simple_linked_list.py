class NodeS:

    def __init__(self, node_value, next_node=None):
        self.value = node_value
        self.next = next_node

    def __str__(self):
        return self.value.__str__()

    def __repr__(self):
        return 'NodeS()'


class slinked_list:

    def __init__(self):
        self.size = 0
        self.start = None
        self.end = None

    def __repr__(self):
        return 'SimpleLinkedList()'

    def __str__(self):
        return ' -> '.join([str(x) for x in self.toArray()])

    def __iter__(self):
        return slist_iterator(self)

    def __findNodeIndex(self, index):
        aux = self.start
        for i in range(index):
            aux = aux.next
        return aux

    def __findNodeValue(self, value):
        aux = self.start
        for i in range(self.size):
            if self.value == value:
                return aux
        return None

    def insert_start(self, value):
        newNode = NodeS(value)
        if self.size == 0:
            self.start = newNode
            self.end = newNode
        else:
            newNode.next = self.start
            self.start = newNode
        self.size += 1

    def insert(self, value, index):
        if index == 0:
            insert_start(value)
        elif index == self.size - 1:
            insert_end(value)
        else:
            aux = self.__findNodeIndex(index - 1)
            newNode = NodeS(value, aux.next)
            aux.next = newNode
            self.size += 1

    def insert_end(self, value):
        newNode = NodeS(value)
        if self.size == 0:
            self.start = newNode
            self.end = newNode
        else:
            self.end.next = newNode
            self.end = newNode
        self.size += 1

    def contains(self, value):
        if self.size == 0:
            return None
        elif self.size == 1:
            return self.start.value == value
        else:
            aux = self.start
            while(aux.value != value):
                aux = aux.next
            return aux.value == value
        return False

    def get(self, index):
        if index < 0:
            raise ValueError('Invalide index')
        elif index > self.size - 1:
            raise ValueError('Index out of bounds')
        elif self.size == 0:
            return None
        else:
            return self.__findNodeIndex(index)

    def removeIndex(self, index):

        if index < 0:
            raise ValueError('Invalide index')
        elif index > self.size:
            raise ValueError('Index out of bounds')
        elif index == 0:
            aux = self.start
            self.start = self.start.next
            del aux
        else:
            aux = self.__findNodeIndex(index)
            aux_prev = self.__findNodeIndex(index - 1)
            aux_prev.next = aux.next
            del aux
        self.size -= 1

    def restart(self):
        aux = self.start
        aux2 = self.start
        for i in range(self.size):
            aux2 = aux
            aux = aux.next
            del aux2
        return slinked_list()

    def toArray(self):
        aux = self.start
        array = []
        while(aux != None):
            array.append(aux.value)
            aux = aux.next
        return array


class slist_iterator:

    def __init__(self, slinked_list):
        self.aux = slinked_list.start

    def __str__(self):
        return self.aux.value

    def __repr__(self):
        return 'SimpleLinkedListIterator()'

    def __iter__(self):
        return self

    def __next__(self):
        if self.aux.next:
            self.aux2 = self.aux
            self.aux = self.aux.next
            return self.aux2
        else:
            raise StopIteration
