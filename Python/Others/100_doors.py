

door = [0] * 100

for n in range(100):
    for i in range(n, 100, n + 1):
        if door[i] == 0:
            door[i] = 1
        else:
            door[i] = 0

print(door)
