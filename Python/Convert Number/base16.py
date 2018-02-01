# convert from hexadecimal to binary, octal e decimal

# TODO CONVERTER FRACTIONAL BASE16 NUMBER TO BASE 2


def from16_to2(x, steeps=None):
    dic = {'0': '0000', '1': '0001', '2': '0010', '3': '0011',
           '4': '0100', '5': '0101', '6': '0110', '7': '0111',
           '8': '1000', '9': '1001', 'A': '1010', 'B': '1011',
           'C': '1100', 'D': '1101', 'E': '1110', 'F': '1111'}
    binary = ''
    for i in x:
        if steeps:
            print('{} = {}'.format(i, dic[i]))
        binary += dic[i]
    return binary.lstrip('0')


# TODO CONVERTER FRACTIONAL BASE16 NUMBER TO BASE 8

def from16_to8(x, steeps=None):
    binary = from16_to2(x, steeps)
    dic = {'000': '0', '001': '1', '010': '2', '011': '3',
           '100': '4', '101': '5', '110': '6', '111': '7'}
    size = len(str(binary)) + (3 - (len(str(binary)) % 3)
                               ) if len(str(binary)) % 3 != 0 else len(str(binary))
    binary = binary.rjust(size, '0')
    binary = [binary[i:i + 3] for i in range(0, len(binary), 3)]
    octal = ''
    for i in binary:
        if steeps:
            print('{} = {}'.format(i, dic[i]))
        octal += dic[i]
    return int(octal)


# TODO CONVERTER FRACTIONAL BASE16 NUMBER TO BASE 10

def from16_to10(x, steeps=None):
    dic = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7,
           '8': 8, '9': 9, 'A': 10, 'B': 11, 'C': 12, 'D': 13, 'E': 14, 'F': 15}
    decimal = 0
    x = x[::-1]
    for i in range(len(x) - 1, -1, -1):
        if steeps:
            print('{}x16^{} = {}'.format(dic[x[i]], i, dic[x[i]] * (16**i)))
        print(decimal)
        print(x[i])
        print(i)
        decimal += dic[x[i]] * (16**i)
    return decimal
