import math


def calculateTime(func, array):
    import time
    start = time.time()
    func(value, array)
    return 'Time spent for binary search: {:.3f}s'.format(time.time() - start)


def jump_search(array, value):
    # TODO FIX BUG
    m = round(math.sqrt(len(array)))
    while array[m] < value:
        if array[m] == value:
            return m
        m += 4

    for i in range(m - 4, m):
        if array[i] == value:
            return i
