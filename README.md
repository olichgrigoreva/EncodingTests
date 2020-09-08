# EncodingTests
# Тест 1
1. Открыть https://api.encoding.com/
2. В поиске ввести 'getStatus'
3. Перейти по результату 'GetStatus (extended)'
4. Проверить текущий URL 'https://api.encoding.com/reference#responses-getstatus-extended'
5. На открытой странице в секции 'Response' во вкладке JSON проверить:
 - параметр 'processor' содержит значения 'AMAZON' и 'RACKSPACE'
 - на уровне 'format' параметр 'status' равен 'Status'

# Тест 2
Отправить запрос с вариантами параметров XML и JSON

XML: https://status.encoding.com/status.php?format=xml
JSON: https://status.encoding.com/status.php?format=json

Проверить в ответе:
1. Параметр status равен Ok
2. Параметр lastYear равен 1
3. Проверить uptime (сек) больше 1 суток

# Maven lib
com.fasterxml.jackson.core:jackson-annotations:2.11.1
com.fasterxml.jackson.core:jackson-databind:2.11.1
com.fasterxml.jackson.core:jackson-core:2.11.1

# External lib
https://www.selenium.dev/downloads/ Selenium Client & WebDriver Language Bindings

# ChromeDriver
https://sites.google.com/a/chromium.org/chromedriver/ 
