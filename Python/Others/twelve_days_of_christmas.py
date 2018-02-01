
vers = [
    'A partridge in a pear tree.', 'Two turtle doves and', 'Three french hens',
    'Four calling birds', 'Five golden rings', 'Six geese a-laying',
    'Seven swans a-swimming', 'Eight maids a-milking', 'Nine ladies dancing',
    'Ten lords a-leaping', 'Eleven pipers piping', 'Twelve drummers drumming'
]
days = ['first', 'second',  'third', 'fourth', 'fifth', 'sixty',
        'seventh', 'eight', 'ninth', 'tenth', 'eleventh', 'twelfth']
for i in range(12):
    print('On the {} day of Christmas,'.format(days[i]))
    print('My true love gave to me:')
    for j in range(i, -1, -1):
        print(vers[j])
    print()
