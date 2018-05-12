def exponential_search(array, value):
    i = 0
    while i * 2 < len(array) and array[i] < value:
        i *= 2

    start = i / 2
    end = len(array) - 1

    while start <= end:
        half = int((start + end) // 2)
        if value == array[half]:
            return half
        elif value < array[half]:
            end = half - 1
        else:
            start = half + 1
