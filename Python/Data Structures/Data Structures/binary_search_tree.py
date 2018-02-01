from queue import queue


class node:

    def __init__(self, key, value, right=None, left=None, parent=None):
        self.key = key
        self.value = value
        self.right = right
        self.left = left
        self.parent = parent

    def __str__(self):
        return 'Key: {} Value: {}'.format(self.key.__str__(), self.value.__str__())

    def __repr__(self):
        return 'Node()'

    def isLeaf(self):
        if not self.right and not self.left:
            return True
        return False


class search_tree:

    def __init__(self, root=None):
        self.root = root

    def __iter__(self):
        return BSTIterator(self)

    def find_min(self):
        aux = self.root
        if not aux:
            return None
        while aux.left:
            aux = aux.left
        return aux

    def find_max(self):
        aux = self.root
        if not aux:
            return None
        while aux.right:
            aux = aux.right
        return aux

    def insert(self, key, value=None):
        if not key:
            raise KeyError('Null key')
        if not value:
            newNode = node(key, key)
        else:
            newNode = node(key, value)
        if not self.root:
            self.root = newNode
        else:
            aux = self.root
            while aux != None or aux.key != key:
                if key > aux.key and aux.right == None:
                    aux.right = newNode
                    aux.right.parent = aux
                    break
                elif key < aux.key and aux.left == None:
                    aux.left = newNode
                    aux.left.parent = aux
                    break

                if key > aux.key:
                    aux = aux.right

                elif key < aux.key:
                    aux = aux.left

                else:
                    aux.key, aux.value = key, value
                    break

    def search(self, key):
        aux = self.root
        if not aux or not key:
            return None
        while aux != None:
            if key > aux.key:
                aux = aux.right
            elif key < aux.key:
                aux = aux.left
            else:
                return aux
        return None

    def remove(self, key):
        if key:
            aux = self.search(key)
            if aux:
                if aux.isLeaf():
                    if aux.parent.right == aux:
                        aux.parent.right = None
                    else:
                        aux.parent.left = None
                    del aux
                elif not aux.right and aux.left:
                    if aux.parent.left == aux:
                        aux.parent.left = aux.left
                        aux.left.parent = aux.parent
                        aux.parent, aux.left = None, None
                        del aux
                    else:
                        aux.parent.right == aux.left
                        aux.left.parent = aux.parent
                        aux.parent, aux.left = None, None
                        del aux
                elif aux.right and not aux.left:
                    if aux.parent.left == aux:
                        aux.parent.left = aux.right
                        aux.right.parent = aux.parent
                        aux.parent, aux.right = None, None
                        del aux
                    else:
                        aux.parent.right = aux.right
                        aux.right.parent = aux.parent
                        aux.parent, aux.right = None, None
                        del aux
                else:
                    consec = aux.right
                    while consec.left:
                        consec = consec.left

                    aux.key, aux.value = consec.key, consec.value
                    if consec.isLeaf():
                        consec.parent.right = None
                        consec.parent = None
                        del consec
                    elif consec.right:
                        consec.right.parent = consec.parent
                        consec.parent.right = consec.right
                        consec.parent, consec.right = None, None
                        del consec
        else:
            raise KeyError('Null key')

    def __preorderR(self, array, node):
        if node:
            array.append(node.value)
            self.__preorderR(array, node.left)
            self.__preorderR(array, node.right)
            return array

    def preorder(self):
        array = []
        array = self.__preorderR(array, self.root)
        return array

    def __posorderR(self, array, node):
        if node:
            self.__posorderR(array, node.left)
            self.__posorderR(array, node.right)
            array.append(node.value)
            return array

    def posorder(self):
        array = []
        array = self.__posorderR(array, self.root)
        return array

    def __inorderR(self, array, node):
        if node:
            self.__inorderR(array, node.left)
            array.append(node.value)
            self.__inorderR(array, node.right)
            return array

    def inorder(self):
        array = []
        array = self.__inorderR(array, self.root)
        return array


class BSTIterator:

    def __init__(self, search_tree):
        self.queue = queue()
        self.aux = search_tree.root
        self.queue.add(self.aux)

    def __iter__(self):
        return self

    def __next__(self):
        if not self.queue.is_empty():
            no = self.queue.pop()
            if no.left:
                self.queue.add(no.left)
            if no.right:
                self.queue.add(no.right)
            return no.value
        else:
            raise StopIteration
