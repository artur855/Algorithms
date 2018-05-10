def selection_sort(array):
    for i in range(len(array) - 1):
        minor = i
        for j in range(minor, len(array)):
            if array[minor] > array[j]:
                minor = j
        array[i], array[minor] = array[minor], array[i]
    return array
