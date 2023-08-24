import psycopg2
import csv
from datetime import datetime
import json  # JSON 변환을 위해 필요한 모듈

# 연결 DB 정보
db = psycopg2.connect(host='localhost', database='Board_DB', user='Happy', password='1234', port=5432)

# CSV 파일 경로
csv_file_path = 'D:/AI Project/Test Data/treated_recycling_data2.csv'

# 데이터베이스 커서 생성
cursor = db.cursor()

# CSV 파일 읽기
with open(csv_file_path, 'r', encoding='UTF-8') as file:
    reader = csv.reader(file)
    next(reader)  # 첫 줄은 헤더이므로 건너뜀
    for row in reader:
        detect_log_id, device_id, ai_result, date, time, state, ce, rm, reason = row

        # date와 time을 합쳐서 datetime 객체 생성
        datetime_obj = datetime.strptime(date + ' ' + time, '%Y-%m-%d %H:%M:%S')

        # ai_result를 JSONB 형식으로 변환
        ai_result_json = json.dumps({"ai_result": ai_result})  # 딕셔너리를 JSON 문자열로 변환

        # state를 boolean으로 변환
        state = state.lower() == 'true'

        # ce와 rm 값을 빈 문자열이 아닌 경우에는 정수로 변환, 빈 문자열인 경우에는 None으로 처리
        ce = int(ce) if ce else None
        rm = int(rm) if rm else None

        # PostgreSQL 쿼리 실행
        query = "INSERT INTO Total_Recycle (detect_log_id, device_id, ai_result, date, time, state, ce, rm, reason) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s);"
        data = (detect_log_id, device_id, ai_result_json, datetime_obj.date(), datetime_obj.time(), state, ce, rm, reason)
        cursor.execute(query, data)

# 변경 사항 커밋
db.commit()

# 커넥션 닫기
cursor.close()
db.close()
