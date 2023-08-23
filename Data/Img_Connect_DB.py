# psycopg2와 flask를 이용해서 이미지 등록, 조회
from flask import Flask, request, send_file
import psycopg2 
from psycopg2 import sql

import os
import re

# 이미지 이름 처리
# folder_path = 'D:\AI Project\Test Data\AI_Result_img'
# replace_char = "_"  # 변경할 문자 (언더스코어나 하이픈 등)

# def process_image_names(folder_path):
#     if not os.path.exists(folder_path):
#         print("폴더가 존재하지 않습니다.")
#         return

#     for filename in os.listdir(folder_path):
#         if filename.endswith(".jpg") or filename.endswith(".png"):
#             # 이미지 이름에서 날짜와 시간 추출
#             match = re.search(r'Wimple_\d{4}-\d{2}-\d{2}=\d{2}\d{2}\d{2}', filename)

#             if match:
#                 date_time_str = match.group()
#                 new_filename = date_time_str.replace("-", "_").replace("=", "_").replace("", "_") + ".png" # 파일 확장자 조정
                
#                 original_path = os.path.join(folder_path, filename)
#                 new_path = os.path.join(folder_path, new_filename)
#                 os.rename(original_path, new_path)
#                 print(f"{filename}을(를) {new_filename}로 변경했습니다.")


# process_image_names(folder_path)


from flask import Flask, request, send_file
import psycopg2 
from psycopg2 import sql
import os
from datetime import datetime
from psycopg2.extensions import ISOLATION_LEVEL_AUTOCOMMIT

# Falsk 연결
app = Flask(__name__)

# 이미지 업로드 경로 설정
UPLOAD_FOLDER = 'C:/Users/user/Documents/Python_Scripts/postgreSQL_Test/images'  # 이미지를 저장할 경로
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

@app.route('/image', methods=['POST'])
def register_image():
    try: 
        img_base_url = f'http://localhost:8080/image/'

        if 'image_file' not in request.files:
            return 'No image file provided', 400
    
        image_file = request.files['image_file']
        
        if image_file.filename == '':
            return 'No image selected', 400

        if image_file.filename.endswith('.png'):
            mimetype = 'image/png'
        else:
            mimetype = 'image/jpeg'
            
        connection = psycopg2.connect(
            database="AI_DB",
            user="Happy", # 데이터베이스 사용자 이름
            password="1234", # 데이터베이스 비밀번호
            host="localhost", # 데이터베이스 호스트
            port="5432" # 데이터베이스 포트
        )
        
        cursor = connection.cursor()

        # 이미지 파일명에서 날짜와 시간 추출
        filename_parts = image_file.filename.split('_')
        date_str = filename_parts[1] + '-' + filename_parts[2] + '-' + filename_parts[3]
        time_str = filename_parts[4] + ':' + filename_parts[5] + ':' + filename_parts[6]

        image_datetime = datetime.strptime(date_str + ' ' + time_str, '%Y-%m-%d %H:%M:%S')

        # 이미지를 서버에 저장하고 URL 생성
        filename = image_file.filename
        image_path = os.path.join(app.config['UPLOAD_FOLDER'], filename)
        image_file.save(image_path)
        image_url = img_base_url + filename

        # 이미지 URL과 날짜/시간을 데이터베이스에 추가
        insert_query = sql.SQL("INSERT INTO recycling_img (img_url) VALUES (%s);")
        cursor.execute(insert_query, (image_url))
        connection.commit()
        
        return 'Image registered successfully', 200
    except Exception as e:
        return f'An error occurred: {str(e)}', 500 

if __name__ == '__main__':
    # 서버 실행
    app.run(host="localhost", port=8080, debug=True)
