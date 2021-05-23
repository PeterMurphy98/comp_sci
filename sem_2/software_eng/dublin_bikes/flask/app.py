from flask import Flask, render_template, request
from sqlalchemy import create_engine
import pandas as pd

import dbinfo

app = Flask(__name__)


@app.route('/')
def index():
    return render_template("index.html")


@app.route('/home')
def home():
    return render_template("index.html")


@app.route('/stations')
def stations():
    engine = create_engine(f"mysql+mysqlconnector://{dbinfo.USER}:{dbinfo.PASS}@{dbinfo.DBURI}:{dbinfo.PORT}/{dbinfo.DB}")
    df = pd.read_sql_table("stations", engine)
    return df.to_json(orient='records')


@app.route('/current/<st_number>')
def availability(st_number):
    engine = create_engine(f"mysql+mysqlconnector://{dbinfo.USER}:{dbinfo.PASS}@{dbinfo.DBURI}:{dbinfo.PORT}/{dbinfo.DB}")
    sql = f"select * from dbikes.availability2 where `number` = {st_number} and last_update = (select max(last_update) from dbikes.availability2 where `number` = {st_number});"
    df = pd.read_sql_query(sql, engine)
    return df.to_json(orient='records')


if __name__ == '__main__':
    app.run(debug=True)
