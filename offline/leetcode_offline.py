from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time, os, re, random

CODE_DRIVER = webdriver.Chrome("./chromedriver")

def sign_into_leetcode():
    CODE_DRIVER.implicitly_wait(2+random.random())
    CODE_DRIVER.get("https://leetcode.com/accounts/login/")
    CODE_DRIVER.find_element_by_xpath('// *[ @ id = "id_login"]').send_keys('7__')
    CODE_DRIVER.find_element_by_xpath('// *[ @ id = "id_password"]').send_keys('qizqyc-vysgyk-4bukdA')
    CODE_DRIVER.find_element_by_xpath('// *[ @ id = "id_password"]').send_keys(Keys.ENTER)
    CODE_DRIVER.implicitly_wait(0)

def get_description(url):

    try:
        time.sleep(2+random.random())
        CODE_DRIVER.get(url)
        time.sleep(2+random.random())
        title = CODE_DRIVER.find_element_by_xpath('//*[@id="app"]/div/div[2]/div[1]/div/div[1]/div/div[1]/div[1]/div/div[2]/div/div[1]/div[1]').text
        qid = title.split('.')[0]
        name = title.split('.')[1]
        # text = CODE_DRIVER.find_element_by_class_name('description__24sA').text
        # print(qid)
        # print(name)
        diff = CODE_DRIVER.find_element_by_xpath('//*[@id="app"]/div/div[2]/div[1]/div/div[1]/div/div[1]/div[1]/div/div[2]/div/div[1]/div[2]/div').text
        # print(diff)

        # content = CODE_DRIVER.find_element_by_class_name('content__u3I1 question-content__JfgR')
        content = CODE_DRIVER.find_element_by_xpath('//*[@id="app"]/div/div[2]/div[1]/div/div[1]/div/div[1]/div[1]/div/div[2]/div/div[2]').text
        # print(content)

        with open(os.path.join('problems', diff.upper()+qid+'.txt'), 'w') as f:
            f.write(title)
            f.write('\n')
            f.write(diff)
            f.write('\n\n')
            f.write(content)

    except:
        print(url)

if __name__ == "__main__":
    if not os.path.exists('problems'):
        os.makedirs('problems')
    sign_into_leetcode()

    with open('links.txt', 'r') as links:
        for line in links:
            get_description(line)
            # print(line, end='')
    CODE_DRIVER.close()