# convert from decimal to binary, octal e hexadecimal

# TODO CONVERTER FRACTIONAL BASE10 NUMBER TO BASE 2


def from10_to2(x, steeps=None):
    q = x
    binary = ''
    while(q != 0):
        r = str(q % 2)
        if steeps:
            print('{} / 2  = {}, remainder = {}'.format(q, q // 2, r))
        q = q // 2
        binary += r
    return binary[::-1]  # return from MSB to LSB

# TODO CONVERTER FRACTIONAL BASE10 NUMBER TO BASE 8


def from10_to8(x):
    q = x
    octo = ''
    while (q != 0):
        r = str(q % 8)
        if steeps:
            print('{} / 8  = {}, remainder = {}'.format(q, q // 8, r))
        q = int(q / 8)
        octo += r
    return octo[::-1]  # return from MSB to LSB

# TODO CONVERTER FRACTIONAL BASE10 NUMBER TO BASE 16


def from10_to16(x):
    dic = {0: '0', 1: '1', 2: '2', 3: '3', 4: '4', 5: '5', 6: '6', 7: '7',
           8: '8', 9: '9', 10: 'A', 11: 'B', 12: 'C', 13: 'D', 14: 'E', 15: 'F'}
    q = int(x)
    hexa = ''
    while (q > 0):
        r = q % 16
        if steeps:
            print('{} / 2  = {}, remainder = {}'.format(q, q // 2, r))
        q = int(q / 16)
        hexa += dic[r]
    return hexa[::-1]  # return from MSB to LSB
