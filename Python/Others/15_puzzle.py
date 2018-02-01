import random


class Puzzle:
    """

    0  1  2   3
    4  5  6   7
    8  9  10 11
    12 13 14 15

    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15


    """

    def __init__(self):
        self.board = [str(i) for i in range(16)]
        self.board[0] = ''
        random.shuffle(self.board)

    def draw_board(self):
        print()
        for i in range(0, 16, 4):
            print('+' * 33)
            print('| {:^5} | {:^5} | {:^5} | {:^5} |'.format(
                self.board[i], self.board[i + 1], self.board[i + 2], self.board[i + 3]))
        print('+' * 33)
        print()

    def get_adjacentes(self, n):
        index = self.board.index(str(n))
        if index == 0:
            # return [self.board.index(self.board[0]),
            # self.board.index(self.board[4])]
            return ['R', 'D']
        elif index == 3:
            return ['L', 'D']
        elif index == 12:
            return ['R', 'U']
        elif index == 15:
            return ['L', 'U']
        elif index == 13 or index == 14:
            return ['L', 'R', 'U']
        elif index == 1 or index == 2:
            return ['L', 'R', 'D']
        elif index == 4 or index == 8:
            return ['R', 'U', 'D']
        elif index == 7 or index == 11:
            return ['L', 'U', 'D']
        else:
            return ['L', 'R', 'U', 'D']

    def move(self, n, direction):
        if direction.lower() == 'r':
            self.board[n], self.board[n + 1] = self.board[n + 1], self.board[n]
        elif direction.lower() == 'l':
            self.board[n], self.board[n - 1] = self.board[n - 1], self.board[n]
        elif direction.lower() == 'u':
            self.board[n], self.board[n - 4] = self.board[n - 4], self.board[n]
        elif direction.lower() == 'd':
            self.board[n], self.board[n + 4] = self.board[n + 4], self.board[n]
        else:
            print('Invalid input')

    def get_direction(self, n, direction):
        if direction.lower() == 'l':
            return n - 1
        elif direction.lower() == 'r':
            return n + 1
        elif direction.lower() == 'u':
            return n - 4
        elif direction.lower() == 'd':
            return n + 4
        else:
            print('Invalid direction')

    def make_move(self):
        index = self.board.index('')
        possible = self.get_adjacentes('')
        adj = []
        for i in range(len(possible)):
            adj.append(self.get_direction(index, possible[i]))
        if len(adj) == 2:
            print('These are the possible movements\n{:>15} | {:<15}\n{:>15} | {:<15}'.format(
                self.board[adj[0]],
                self.board[adj[1]],
                possible[0],
                possible[1]
            )
            )
            move = input()
            if move.upper() in possible:
                self.move(index, move)
            else:
                print('Invalid')
        elif len(adj) == 3:
            print('These are the possible movements\n{:>10} | {:^10} | {:<10}\n{:>10} | {:^10} | {:<10}'.format(
                self.board[adj[0]],
                self.board[adj[1]],
                self.board[adj[2]],
                possible[0],
                possible[1],
                possible[2]
            )
            )
            move = input()
            if move.upper() in possible:
                self.move(index, move)
            else:
                print('Invalid movement')

        elif len(adj) == 4:
            print('These are the possible movements\n{:>8} | {:^8} | {:^8} | {:<8}\n{:>8} | {:^8} | {:^8} | {:<8}'.format(
                self.board[adj[0]],
                self.board[adj[1]],
                self.board[adj[2]],
                self.board[adj[3]],
                possible[0],
                possible[1],
                possible[2],
                possible[3]
            )
            )
            move = input()
            if move.upper() in possible:
                self.move(index, move)
            else:
                print('Invalid movement')

    def game_over(self):
        if self.board[:15] == list(range(1, 16)):
            return True
        else:
            return False

    def start_game(self):
        print('Welcome to the 15-puzzle')
        print('To win the game you have to make the board,\nby making sliding moves that use the empty space')
        print('Example of the board when the game is complete')
        array = list(range(1, 16))
        array.append('')
        print()
        for i in range(0, 16, 4):
            print('+' * 33)
            print('| {:^5} | {:^5} | {:^5} | {:^5} |'.format(
                array[i], array[i + 1], array[i + 2], array[i + 3]))
        print('+' * 33)
        print('\nYou can insert the letters to make the movements:\nl - left\nr - Right\nu - Up\nd - Down\n')
        print('To start the game insert 1, or exit by inserting 0')
        option = input()
        if option == str(1):
            print('\nGame starting')
            while True:
                self.draw_board()
                p.make_move()
                if p.game_over():
                    self.draw_board()
                    print('Congratulations!!! You conclued the puzzle')
                    break

    def auto_solve(self):
        pass

    def set_difficult(self):
        pass
