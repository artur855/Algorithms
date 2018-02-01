from bs4 import BeautifulSoup
import requests
import os
import time
import re

s = time.time()
quote_page = 'https://c.xkcd.com/random/comic/'
path = os.path.join(os.getcwd(), 'images')
if not os.path.exists(path):
    print('Creating images folder')
    os.makedirs('images')
size = 0
for i in range(50):
    page = requests.get(quote_page)
    soup = BeautifulSoup(page.text, 'html.parser')
    reg = re.compile(r'src="//?([^"]+)"')
    imgs = soup.select('#comic')
    src = re.search(reg, str(imgs))
    if src:
        img = requests.get('http://' + src.group(1))
        file = open(os.path.join(path, 'img{}.png'.format(i)), 'wb')
        file.write(img.content)
        size += os.path.getsize(os.path.join(path, 'img{}.png'.format(i)))
        print('Downloaded img ' + str(i) + ' Size: ' +
              str(os.path.getsize(os.path.join(path, 'img{}.png'.format(i)))) + 'bytes')
    else:
        print('Error in image src')

print('On total where downloaded ' + str(size) + ' bytes')
print('Time spent to download all images: ' + str(time.time() - s))
