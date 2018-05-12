import praw


client_id = 'M4Ni3TmCSviPrQ'
client_secret = '_yI_aYFguxVQoPLONow-2c7kgm4'
username = input('Insert username:\n')
password = input('Insert password:\n')
subreddit = input('Insert subreddit:\n')
user_agent = 'PyEng Bot 0.1'


def bot_login():
    reddit = praw.Reddit(username=username,
                         password=password,
                         client_id=client_id,
                         client_secret=client_secret,
                         user_agent=user_agent
                         )
    return reddit


def run_bot(reddit):
    for post in reddit.subreddit(subreddit).hot(limit=5):
        print('Title : ' + str(post.title))
        print('Text : ' + str(post.selftext))
        print('Score : ' + str(post.score))
        print('-----------------------------------\n')


reddit = bot_login()
run_bot(reddit)
