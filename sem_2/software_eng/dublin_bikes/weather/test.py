import requests
import datetime

KEY = "e7dacb8911d862ac15467d834942acb1"
WEATHER = "http://api.openweathermap.org/data/2.5/weather?q=Dublin,ie&appid={}&units=metric".format(KEY)

res = requests.get(WEATHER)
print(res)

def get_weather(obj):
    return {'main': obj['weather'][0]['main'],
            'temp': obj['main']['temp'],
            'temp_min': obj['main']['temp_min'],
            'temp_max': obj['main']['temp_max'],
            'pressure': obj['main']['pressure'],
            'humidity': obj['main']['humidity'],
            'wind_speed': obj['wind']['speed'],
            'wind_dir': obj['wind']['deg'],
            'cloudiness': obj['clouds']['all'],
            'last_update': datetime.datetime.utcfromtimestamp(int(obj['dt'])).strftime('%y-%m-%d %H:%M:%S')
            }

print(get_weather(res.json()))