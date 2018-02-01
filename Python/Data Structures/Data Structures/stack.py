class node:

    def __init__(self, value, next=None):
        self.value = value
        self.next = next

    def __str__(self):
        return 'Value: {}'.format(self.value)

    def __repr__(self):
        return 'Node()'


class stack:

    def __init__(self):
        self.top = None
        self.size = 0

    def __str__(self):
        aux = self.top
        string = ''
        while aux:
            string += str(aux) + '\n'
            aux = aux.next
        return string

    def __repr__(self):
        return 'Stack()'

    def push(self, value):
        new = node(value, self.top)
        self.top = new
        self.size += 1

    def pull(self):
        aux = self.top
        self.top = self.top.next
        self.size -= 1
        return aux

    @property
    def empty(self):
        return self.size == 0


class Iterator:

    def __init__(self, stack):
        self.top = stack.top

    def __iter__(self):
        return self

    def __next__(self):
        if self.top:
            top = self.top
            self.top = self.top.next
            return top
        else:
            raise StopIteration


class stack_easy:

    def __init__(self):
        self.stack = []

    def __str__(self):
        return '\n'.join(['Value: {}'.format(x) for x in self.stack][::-1])

    def push(self, value):
        self.stack.append(value)

    def pull(self):
        return self.stack.pop()

    def first(self):
        return self.stack[-1]
