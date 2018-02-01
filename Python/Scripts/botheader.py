import requests
import re
url = 'https://youtu.be/z9iABHXJLdc'


def is_downloadable(url):

    h = requests.head(url, allow_redirects=True)
    header = h.headers
    content_type = header.get('content-type')
    if 'text' in content_type.lower() or 'html' in content_type.lower():
        return False
    return True


def get_filename_from_cd(cd):

    if not cd:
        return None
    fname = re.findall('filename=(.+)', cd)
    if len(fname) == 0:
        return None
    return fname[0]
