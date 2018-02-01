
def calculateTime(func, array):
    import time
    start = time.time()
    func(array)
    print('Time spent for comb sort: {:.3f}s'.format(time.time() - start))


def comb_sort(array):
    gap = int(len(array) / 1.3)
    i = 0
    while gap > 0 and i != len(array) - 1:
        i = 0
        while i + gap < len(array):
            if array[i] > array[i + gap]:
                array[i], array[i + gap] = array[i + gap], array[i]
            i += 1
        gap = int(gap / 1.3)
    return array
