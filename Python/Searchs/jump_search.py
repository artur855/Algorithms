import math


def jump_search(array, value):
    array_length = len(array)
    jump = round(math.sqrt(array_length))
    last = 0
    while array[min(jump, array_length) - 1] < value:
        last = jump
        jump += round(math.sqrt(array_length))
        if last > array_length:
            return
    while array[last] < value:
        last += 1
        if last == min(jump, array_length):
            return
    if array[last] == value:
        return last
    return None
