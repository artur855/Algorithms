import random

number = ''.join([str(x) for x in random.sample(list(range(1, 10)), 4)])
size = 4
guesses = 0
while True:
    guesses += 1
    print('Insert {} digit number'.format(size))
    guess = input()
    if len(guess) < size or len(guess) > size:
        print('Invalid input\nInsert a number with exactly {} digits'.format(size))
    elif guess == number:
        print('Congratulations you guessed the number in {} guesses'.format(guesses))
        break
    else:
        cow = 0
        bull = 0
        for i in range(len(guess)):
            if guess[i] == number[i]:
                bull += 1
            elif guess[i] in number:
                cow += 1
        print('{} cow(s) and {} bull(s)'.format(cow, bull))
