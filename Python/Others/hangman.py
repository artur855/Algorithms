import random
words = ['house', 'rat', 'table', 'dog',
         'door', 'school', 'computer', 'internet']
answer = random.choice(words)
track = ['_' for i in answer]
lifes = 5
print('Welcome to the hangman game')
while(lifes > 0):
    print('\n----------------------------------------------------------')

    print('Progress: ' + ' '.join(track))
    print('Remaining chances: ' + str(lifes))
    print('Guess a letter:')
    chute = input()
    print('----------------------------------------------------------\n')
    indexs = []
    if chute in track:
        print('You already guessed that letter')
    elif len(chute) != 1:
        print('Your guess can only one letter and no blank spaces')
    else:
        indexs = [i for i, ltr in enumerate(answer) if ltr == chute]
        if len(indexs) > 0:
            for i in indexs:
                track[i] = chute
        else:
            print("The word doesn't contain the guessed letter")
            lifes -= 1
    if list(answer) == track:
        print('Congratulations!!!')
        print('You guessed the word "{}" correctly'.format(answer))
        break
    if lifes == 0:
        print('\nYou lost!! :(')
        print('The correct word is: "' + answer + '"')
