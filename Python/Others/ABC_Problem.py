blocs = '''(B O)
(X K)
(D Q)
(C P)
(N A)
(G T)
(R E)
(T G)
(Q D)
(F S)
(J W)
(H U)
(V I)
(A N)
(O B)
(E R)
(F S)
(L Y)
(P C)
(Z M)
'''.splitlines()

for i in range(len(blocs)):
    blocs[i] = tuple(x for x in blocs[i][1:-1].split())


def can_make_word(word):
    for char in word:
        has = False
        for block in blocs:
            if char.upper() in block:
                has = True
                blocs.remove(block)
                break
        if not has:
            return False
    return True

print('Insert the word to be made')
word = input()

print(can_make_word(word))
