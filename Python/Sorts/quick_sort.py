def quicksort(array, start, end):
    if start < end:
        pivot = partition(array, start, end)
        quicksort(array, start, pivot - 1)
        quicksort(array, pivot + 1, end)


def partition(array, start, end):
    pivot = array[end]
    wall = start - 1
    for i in range(start, end):
        if array[i] <= pivot:
            wall += 1
            array[i], array[wall] = array[wall], array[i]
    array[wall + 1], array[end] = array[end], array[wall + 1]
    return wall + 1
