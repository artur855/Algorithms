# convert from binary to octal, decimal e hexadecimal

# TODO CONVERTER FRACTIONAL BASE2 NUMBER TO BASE 10


def from2_to10(x, steeps=None):
    x = str(x)[::-1]  # return from MSB to LSB
    dec = 0
    array = [int(i) for i in x]
    for i in range(len(array) - 1, -1, -1):
        if steeps:
            print('{}^{} = {}'.format(array[i], i, array[i] * (
                2**i)))
        dec += array[i] * (2**i)
    return dec

# TODO CONVERTER FRACTIONAL BASE2 NUMBER TO BASE 8


def from2_to8(x, steeps=None):
    dic = {'000': '0', '001': '1', '010': '2', '011': '3',
           '100': '4', '101': '5', '110': '6', '111': '7'}
    size = len(str(x)) + (3 - (len(str(x)) % 3)
                          ) if len(str(x)) % 3 != 0 else len(str(x))
    x = str(x).rjust(size, '0')
    x = [x[i:i + 3] for i in range(0, len(x), 3)]
    octo = ''
    for i in x:
        if steeps:
            print('{} = {}'.format(i, dic[i]))
        octo += dic[i]
    return int(octo)

# TODO CONVERTER FRACTIONAL BASE2 NUMBER TO BASE 16


def from2_to16(x, steeps=None):
    dic = {'0000': '0', '0001': '1', '0010': '2', '0011': '3',
           '0100': '4', '0101': '5', '0110': '6', '0111': '7',
           '1000': '8', '1001': '9', '1010': 'A', '1011': 'B',
           '1100': 'C', '1101': 'D', '1110': 'E', '1111': 'F'}

    size = len(str(x)) + (4 - (len(str(x)) % 4)
                          ) if len(str(x)) % 4 != 0 else len(str(x))
    x = str(x).rjust(size, '0')
    x = [x[i:i + 4] for i in range(0, len(x), 4)]
    hexa = ''
    for i in x:
        if steeps:
            print('{} = {}'.format(i, dic[i]))
        hexa += dic[i]
    return hexa
