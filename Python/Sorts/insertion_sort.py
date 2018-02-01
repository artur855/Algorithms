
def calculateTime(func, array):
    import time
    start = time.time()
    func(array)
    print('Time spent for insertion sort: {:.3f}s'.format(time.time() - start))


def insertion_sort(array):
    for i in range(len(array)):
        x = array[i]
        j = i - 1
        while j >= 0 and array[j] > x:
            array[j + 1] = array[j]
            j -= 1
        array[j + 1] = x
    return array
