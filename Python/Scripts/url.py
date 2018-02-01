import urllib.request
import os
import re

file = open('html.txt', 'w')
html = urllib.request.urlopen('http://python.org/').read()
file.write(str(html))
print('HTML Salvo')


pat = re.compile('<DT><a href="[^"]+">(.+?)</a>')

url = 'http://www.infolanka.com/miyuru_gee/art/art.html'

sock = urllib.request.urlopen(url).read().decode("utf-8")

li = pat.findall(sock)

print(li)
