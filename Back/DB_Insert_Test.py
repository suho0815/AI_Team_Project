from flask import Flask, request
import psycopg2
import csv
from datetime import datetime
import json

app = Flask(__name__)

# PostgreSQL 연결 정보 설정
db = psycopg2.connect(host='localhost', database='Board_DB', user='Happy', password='1234', port=5432)

@app.route('/upload', methods=['POST'])
def upload_file():
    cursor = db.cursor()

    file = request.files['file']
    csv_data = file.read().decode('utf-8').splitlines()

    for row in csv.reader(csv_data):
        detect_log_id, device_id, ai_result_json, date, time, state, ce, rm, reason = row

        datetime_obj = datetime.strptime(date + ' ' + time, '%Y-%m-%d %H:%M:%S')
        state = state.lower() == 'true'
        ce = int(ce) if ce else None
        rm = int(rm) if rm else None

        query = "INSERT INTO Total_Recycle (detect_log_id, device_id, ai_result, date, time, state, ce, rm, reason) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s);"
        data = (detect_log_id, device_id, ai_result_json, datetime_obj.date(), datetime_obj.time(), state, ce, rm, reason)
        cursor.execute(query, data)

    db.commit()
    cursor.close()

    return 'Upload successful'

if __name__ == '__main__':
    app.run(host = 'localhost', )
