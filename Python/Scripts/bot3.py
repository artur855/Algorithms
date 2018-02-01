import urllib
import urllib.request
import re
import os
from os.path import basename
from urllib.parse import urlsplit
from urllib.parse import urlparse
from posixpath import basename, dirname

# function that processes url, if there are any spaces it replaces with
# '%20' ##


def process_url(raw_url):
    if ' ' not in raw_url[-1]:
        raw_url = raw_url.replace(' ', '%20')
        return raw_url
    elif ' ' in raw_url[-1]:
        raw_url = raw_url[:-1]
        raw_url = raw_url.replace(' ', '%20')
        return raw_url

# give the url here
url = 'https://blog.miguelgrinberg.com/post/the-flask-mega-tutorial-part-v-user-logins-legacy'
parse_object = urlparse(url)
dirname = basename(parse_object.path)
if not os.path.exists('images'):
    os.mkdir("images")
# os.mkdir("images/" + dirname)
# os.chdir("images/" + dirname)

urlcontent = urllib.request.urlopen(url).read()
imgurls = re.findall('img .*?src="(.*?)"', str(urlcontent))
for imgurl in imgurls:
    try:
        imgurl = process_url(imgurl)
        imgdata = urllib.request.urlopen(imgurl).read()
        filname = basename(urlsplit(imgurl)[2])
        output = open(filname, 'wb')
        output.write(imgdata)
        output.close()
        os.remove(filename)
    except:
        pass
