
def calculateTime(func, array):
    import time
    start = time.time()
    func(array)
    return 'Time spent for selection sort: {:.3f}s'.format(time.time() - start)


def selection_sort(array):
    for i in range(len(array) - 1):
        minor = i
        for j in range(minor, len(array)):
            if array[minor] > array[j]:
                minor = j
        array[i], array[minor] = array[minor], array[i]
    return array
