import re
import os
import requests
from bs4 import BeautifulSoup

path = os.path.join(os.getcwd(), 'images')
if not os.path.exists(path):
    print('Creating folder')
    os.makedirs('images')

quote_url = 'https://imgur.com'
size = 0
index = 1

res = requests.get(quote_url)
soup = BeautifulSoup(res.text, 'html.parser')
imgs = soup.find_all('img')
reg = re.compile(r'src="//?([^"]+)"')
srcs = re.findall(reg, str(imgs))
print('Numero de imagen: ' + str(len(srcs)))
for j in range(index, len(srcs)):
    url = 'http://' + srcs[index]
    res = requests.get(url)
    file = open(os.path.join(path, 'img{}.png'.format(index)), "wb")
    file.write(res.content)
    size += os.path.getsize(os.path.join(path, 'img{}.png'.format(index)))
    print('Download img {} Size: {} bytes'.format(
        index, os.path.getsize(os.path.join(path, 'img{}.png'.format(index)))))
    index += 1
print('Total files downloaded: {}\nTotal size: {}'.format(len(srcs), size))
print('Finished')
