
def calculateTime(func, array):
    import time
    start = time.time()
    func(array)
    return 'Time spent for bubble_sort: {}s'.format(time.time() - start)


def bubble_sort(array, reverse=False):
    for i in range(len(array)):
        in_order = True
        for j in range(len(array) - 1):
            if reverse:
                if array[j] < array[j + 1]:
                    array[j], array[j + 1] = array[j + 1], array[j]
                    in_order = False
            else:
                if array[j] > array[j + 1]:
                    array[j], array[j + 1] = array[j + 1], array[j]
                    in_order = False
        if in_order:
            break
    return array
