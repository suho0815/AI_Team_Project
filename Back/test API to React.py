# TEST - api 구현, db연동해서 react에 url 전달 성공
# Flask
from flask import Flask, jsonify
# CORS 설정
from flask_cors import CORS
# DB Connect
import psycopg2
import datetime
# from credentials import DATABASE as DB


app = Flask(__name__)
# cors 허용
cors = CORS(app, resources={r"/data/*": {"origins" : "*"}})
    
@app.route('/data', methods=['GET'])
def get_data():
    conn = psycopg2.connect(
                      dbname='AI_resultSet_test',
                      user='postgres',
                      host='localhost',
                      password='tiger',
                      port=5432
                      )
    cur = conn.cursor()
    cur.execute('select * from test_res')
    rows = cur.fetchall()
    conn.close()
    
    # 시간 값을 문자열로 변환
    data = []
    for row in rows:
        serialized_row = list(row)
        serialized_row[4] = row[4].strftime('%H:%M:%S')  # 시간을 문자열로 변환
        data.append(serialized_row)
        
    return jsonify(data)


if __name__ == '__main__':
    app.run(host='localhost', port=8080, debug=True)