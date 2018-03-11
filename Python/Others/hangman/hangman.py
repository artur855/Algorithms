import random
import os

file = open(os.path.join(os.getcwd()+'\\hangman', 'dictionary.txt'), 'r')
words = file.read().splitlines()
answer = random.choice(words)
track = ['_' for i in answer]
guessed = []
life = 5
print('Welcome to the hangman game')

print('\n----------------------------------------------------------')
while life > 0:

    print('Progress: ' + ' '.join(track))
    print('Remaining chances: ' + str(life))
    if len(guessed) > 0:
        print('Guessed letters: ['+', '.join(guessed)+']')
    print('Guess a letter:')
    chute = input()
    print('----------------------------------------------------------\n')
    index = []
    if chute in guessed:
        print('You already guessed that letter')
    elif len(chute) != 1:
        print('Your guess can only one letter and no blank spaces')
    else:
        index = [i for i, ltr in enumerate(answer) if ltr == chute]
        if len(index) > 0:
            for i in index:
                track[i] = chute
        else:
            print("The word doesn't contain the guessed letter")
            life -= 1
    guessed.append(chute)
    if list(answer) == track:
        print('Congratulations!!!')
        print('You guessed the word "{}" correctly'.format(answer))
        break
    if life == 0:
        print('\nYou lost!! :(')
        print('The correct word is: "' + answer + '"')
