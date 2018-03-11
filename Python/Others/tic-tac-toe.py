
p1 = 'X'
p2 = 'O'

board = [['-' for i in range(3)] for i in range(3)]


def drawTab():
    draw = ''
    for row in board:
        for col in row:
            draw += '| ' + col + ' '
        draw += '|\n'
    print(draw)


def checar():
    for row in board:
        if(row.count(p1) == 3):
            return [True, p1]
        elif(row.count(p2) == 3):
            return [True, p2]
    for i in range(3):
        column = [row[i] for row in board]
        if column.count(p1) == 3:
            return [True, p1]
        elif column.count(p2) == 3:
            return [True, p2]
    digP = [board[0][0], board[1][1], board[2][2]]

    if digP.count(p1) == 3:
        return [True, p1]
    elif digP.count(p2) == 3:
        return [True, p2]

    digS = [board[0][2], board[1][1], board[2][0]]

    if digS.count(p1) == 3:
        return [True, p1]
    elif digP.count(p2) == 3:
        return [True, p2]

    return[False, '']


print('Welcome to tic-tac-toe')
turn = 0
while True:
    print('Turn ' + str(turn + 1))
    drawTab()
    if turn % 2 == 0:
        print('First player turn')
        print('Insert row number')
        row = int(input())
        print('Insert column number')
        col = int(input())
        if board[row - 1][col - 1] != '-':
            print("You can't mark this position")
            turn -= 1
        else:
            board[row - 1][col - 1] = p1
    else:
        print('Second player turn')
        print('Insert row number')
        row = int(input())
        print('Insert column number')
        col = int(input())
        if board[row - 1][col - 1] != '-':
            print("You can't mark this position")
            turn -= 1
        else:
            board[row - 1][col - 1] = p2
    result = checar()
    if result[0]:
        if result[1] == p1:
            drawTab()
            print('Congratulations player 1!\nYou Win!!!')
            break
        else:
            drawTab()
            print('Congratulations player 2!\nYou Win!!!')
            break

    turn += 1
