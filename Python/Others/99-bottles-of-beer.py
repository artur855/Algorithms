"""
99 bottles of beer on the wall
99 bottles of beer
Take one down, pass it around
98 bottles of beer on the wall

98 bottles of beer on the wall
98 bottles of beer
Take one down, pass it around
97 bottles of beer on the wall
"""

for i in range(99, 0, -1):
    print('{x} {bottle} of beer on the wall'.format(
        x=i if i != 0 else 'No more', bottle='bottles' if i != 1 else 'bottle'))

    print('{x} {bottle} of beer'.format(x=str(i) if i !=
                                        0 else 'No more', bottle='bottles' if i != 1 else 'bottle'))
    print('Take one down, pass it around')

    print('{x} {bottle} of beer on the wall\n'.format(x=str(i - 1)
                                                      if i != 1 else 'No more', bottle='bottles' if i - 1 != 1 else 'bottle'))
