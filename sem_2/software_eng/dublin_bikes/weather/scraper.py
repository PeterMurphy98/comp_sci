import requests
import traceback
import datetime
import time
import dbinfo
from sqlalchemy import create_engine, Table, Column, String, Float, Integer, MetaData, DateTime

KEY = "e7dacb8911d862ac15467d834942acb1"
WEATHER = "http://api.openweathermap.org/data/2.5/weather?q=Dublin,ie&appid={}&units=metric".format(KEY)

engine = create_engine(f"mysql+mysqlconnector://{dbinfo.USER}:{dbinfo.PASS}@{dbinfo.DBURI}:{dbinfo.PORT}/{dbinfo.DB}")
print(engine.url)

meta = MetaData()
weather = Table(
    'weather', meta,
    Column('row', Integer, primary_key=True),
    Column('main', String(256)),
    Column('temp', Float),
    Column('temp_min', Float),
    Column('temp_max', Float),
    Column('pressure', Float),
    Column('humidity', Float),
    Column('wind_speed', Float),
    Column('wind_dir', Float),
    Column('cloudiness', Float),
    Column('last_update', DateTime)
)
meta.create_all(engine)


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


while True:
    try:
        r = requests.get(WEATHER)
        value = get_weather(r.json())
        ins = weather.insert().values(value)
        engine.execute(ins)

        time.sleep(6 * 60)

    except:
        print(traceback.format_exc())
