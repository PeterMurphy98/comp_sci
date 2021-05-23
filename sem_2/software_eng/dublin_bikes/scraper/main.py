import requests
import traceback
import datetime
import time
import dbinfo
from sqlalchemy import create_engine, Table, Column, Integer, Float, String, MetaData, DateTime

NAME = "Dublin"
STATIONS = "https://api.jcdecaux.com/vls/v1/stations"
KEY = "35013b9b4451f42c1ba1354f936739c0eb486c75"

engine = create_engine(f"mysql+mysqlconnector://{dbinfo.USER}:{dbinfo.PASS}@{dbinfo.DBURI}:{dbinfo.PORT}/{dbinfo.DB}")
print(engine.url)

meta = MetaData()
availability = Table(
    'availability', meta,
    Column('row', Integer, primary_key=True),
    Column('number', Integer),
    Column('bike_stands', Integer),
    Column('available_bike_stands', Integer),
    Column('available_bikes', Integer),
    Column('last_update', DateTime)
)
meta.create_all(engine)


def get_station(obj):
    return {'number': obj['number'],
            'bike_stands': obj['bike_stands'],
            'available_bike_stands': obj['available_bike_stands'],
            'available_bikes': obj['available_bikes'],
            'last_update': datetime.datetime.fromtimestamp(int(obj['last_update'] / 1e3))
            }


while True:
    try:
        r = requests.get(STATIONS, params={"apiKey": KEY, "contract": NAME})
        values = list(map(get_station, r.json()))
        ins = availability.insert().values(values)
        engine.execute(ins)

        time.sleep(3 * 60)

    except:
        print(traceback.format_exc())
