import requests
from io import BytesIO
import pandas


NAVER_URL = "http://dart.fss.or.kr/pdf/download/excel.do?rcp_no=20201113000918&dcm_no=7545316&lang=ko"
user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Whale/2.9.114.33 Safari/537.36"

resp = requests.get(NAVER_URL, headers = {"user-agent" : user_agent})

data = BytesIO(resp.content)
print(pandas.read_excel(data))