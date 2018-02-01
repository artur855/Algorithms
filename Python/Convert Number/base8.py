# convert from octal to binary, decimal e hexadecimal

# TODO CONVERTER FRACTIONAL BASE8 NUMBER TO BASE 2


def from8_to2(x, steeps=None):
    dic = {'0': '000', '1': '001', '2': '010', '3': '011',
           '4': '100', '5': '101', '6': '110', '7': '111'}
    q = str(x)
    binary = ''
    for i in q:
        if steeps:
            print('{} = {}'.format(i, dic[i]))
        binary += dic[i]
    return binary.lstrip('0')


# TODO CONVERTER FRACTIONAL BASE8 NUMBER TO BASE 10


def from8_to10(x, steeps=None):
    array = [int(x) for x in str(x)[::-1]]
    decimal = 0
    for i in range(len(array) - 1, -1, -1):
        if steeps:
            print('{}^{} = {}'.format(array[i], i, array[i] * (
                8**i)))
        decimal += array[i] * (8**i)
    return decimal

# TODO CONVERTER FRACTIONAL BASE8 NUMBER TO BASE 16


def from8_to16(x, steeps=None):
    x = from8_to2(x, steeps)
    dic = {'0000': '0', '0001': '1', '0010': '2', '0011': '3',
           '0100': '4', '0101': '5', '0110': '6', '0111': '7',
           '1000': '8', '1001': '9', '1010': 'A', '1011': 'B',
           '1100': 'C', '1101': 'D', '1110': 'E', '1111': 'F'}

    size = len(str(x)) + (4 - (len(str(x)) % 4)
                          ) if len(str(x)) % 4 != 0 else len(str(x))
    x = x.rjust(size, '0')
    x = [x[i:i + 4] for i in range(0, len(x), 4)]
    hexa = ''
    for i in x:
        if steeps:
            print('{} = {}'.format(i, dic[i]))
        hexa += dic[i]
    return hexa
