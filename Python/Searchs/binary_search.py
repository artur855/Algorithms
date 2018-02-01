
def calculateTime(func, value, array):
    import time
    start = time.time()
    func(value, array)
    return 'Time spent for binary search: {:.3f}s'.format(time.time() - start)


def binary_search(value, array):
    start_interval = 0
    end_interval = len(array) - 1

    while start_interval <= end_interval:
        half = int((start_interval + end_interval) // 2)
        if value == array[half]:
            return half
        elif value < array[half]:
            end_interval = half - 1
        else:
            start_interval = half + 1

    return None
