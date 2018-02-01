import operator
import functools


class Matrix:

    def __init__(self, rows=0, columns=0, matrix=None):
        if matrix:
            self.matrix = matrix
        else:
            self.matrix = [[0 for x in range(columns)] for y in range(rows)]
            '''
            0 0 0
            0 0 0
            0 0 0
            '''

    def __repr__(self):
        return 'Matrix()'

    def __str__(self):
        return '\n'.join([' '.join([str(item) for item in row]) for row in self.matrix])

    def __add__(self, other):
        if self.rows != other.rows and self.columns != other.columns:
            raise ArithmeticError('The two matrix need to have the same size')
        new_matrix = Matrix(self.rows, self.columns)
        for i in range(self.rows):
            for j in range(self.columns):
                new_matrix.matrix[i][j] = self.matrix[
                    i][j] + other.matrix[i][j]
        return new_matrix

    def __sub__(self, other):
        if self.rows != other.rows and self.columns != other.columns:
            raise ArithmeticError('The two matrix need to have the same size')
        new_matrix = Matrix(self.rows, self.columns)
        for i in range(self.rows):
            for j in range(self.columns):
                new_matrix.matrix[i][j] = self.matrix[
                    i][j] - other.matrix[i][j]
        return new_matrix

    def __mul__(self, other):

        if isinstance(other, int):
            return Matrix(matrix=[[item * other for item in row] for row in self.matrix])

        if self.columns != other.rows:
            raise ArithmeticError('Number of rows and columns wrong')
        new_matrix = Matrix(self.rows, other.columns)
        for i in range(new_matrix.rows):
            for j in range(new_matrix.columns):
                new_matrix.matrix[i][j] = sum(
                    [x * y for x, y in zip(self.get_row(i), other.get_column(j))])
        return new_matrix

    def get_row(self, i):
        return self.matrix[i]

    def get_column(self, j):
        return [row[j] for row in self.matrix]

    def set_row(self, i, *columns):
        if len(columns[0]) != self.columns:
            raise ArithmeticError('Wrong number of colums')
        for j in range(self.columns):
            self.matrix[i][j] = columns[0][j]

    def set_column(self, j, *rows):
        if len(rows[0]) != self.rows:
            raise ArithmeticError('Wrong number of rows')
        for i in range(self.rows):
            self.matrix[i][j] = rows[0][i]

    def is_quadratic(self):
        return self.rows == self.columns

    def is_triangular(self):
        for i in range(self.rows):
            for j in range(self.columns):
                if i == j:
                    if self.matrix[i][j] == 0:
                        return False
                else:
                    if self.matrix[i][j] != 0:
                        return False
        return True

    def is_identity(self):

        return self.matrix == [[0 if i != j else 1 for i in range(
            self.rows)] for j in range(self.columns)]

    def transpose(self):
        '''
        3 2 8
        1 5 4

        3 1
        2 5
        8 4
        '''
        new_matrix = [[0 for x in range(self.rows)]
                      for y in range(self.columns)]
        for j in range(self.columns):
            for i in range(self.rows):
                new_matrix[j][i] = self.matrix[i][j]
        return Matrix(matrix=new_matrix)

    def determinant(self):
        if not self.is_quadratic():
            raise ArithmeticError('Matrix is not quadratic')
        aux = Matrix(matrix=self.matrix)
        result = self.__determinant_fator(aux)
        return sum([result[i] if i % 2 == 0 else result[i] * -1 for i in range(len(result))])

    def __determinant_fator(self, matrix):
        # FIX BUG
        '''
        a11 a12 a13 a14
        a21 a22 a23 a24
        a31 a32 a33 a34
        a41 a42 a43 a44
        '''
        if matrix.rows == 2 and matrix.columns == 2:
            return matrix.matrix[0][0] * matrix.matrix[1][1] - matrix.matrix[1][0] * matrix.matrix[0][1]
        else:
            result = []
            for i in matrix.matrix[0]:
                aux = [[row[x] for x in range(len(row)) if row.index(row[x]) != matrix.matrix[
                    0].index(i)] for row in matrix.matrix[1:]]
                result.append(aux)
                result.append(i)
            print(result)
            return [result[i + 1] * self.__determinant_fator(Matrix(matrix=result[i])) for i in range(0, len(result), 2)]

    def inverse(self):
        if self.determinant() == 0:
            raise ArithmeticError("Matrix determinant can't be zero")

    @property
    def rows(self):
        return len(self.matrix)

    @property
    def columns(self):
        return len(self.matrix[0])

    @property
    def size(self):
        return '{}x{}'.format(self.rows, self.columns)


m = Matrix(2, 2)
m.set_row(0, [1, 2])
m.set_row(1, [3, 1])
# m.set_row(2, [4, 6, 8])
n = Matrix(4, 4)
n.set_row(0, [1, 2, 5, 9])
n.set_row(1, [3, 1, 7, 0])
n.set_row(2, [4, 6, 8, 4])
n.set_row(3, [6, 4, 5, 2])

print(m)
print(m.determinant())
print(n)
print(n.determinant())
