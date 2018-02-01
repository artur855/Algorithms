

def calculateTime(func, array):
    import time
    start = time.time()
    func(value, array)
    return 'Time spent for binary search: {:.3f}s'.format(time.time() - start)


def exponential_search(array, value):
    i = 1
    while i * 2 < len(array) and array[i] < value:
        i *= 2

    start = i / 2
    end = len(array)

    while start <= end:
        half = int((start + end) // 2)
        if value == array[half]:
            return half
        elif value < array[half]:
            end = half - 1
        else:
            start = half + 1
