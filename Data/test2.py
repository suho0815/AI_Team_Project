from flask import Flask
from flask_sqlalchemy import SQLAlchemy
import os
import re

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'postgresql://Happy:1234@localhost:5432/AI_DB'
db = SQLAlchemy(app)

class ImageLog(db.Model):
    __tablename__ = 'recycling_img'
    detect_log_id = db.Column(db.Integer, primary_key=True)
    date = db.Column(db.Date)
    time = db.Column(db.Time)
    img_url = db.Column(db.String)

def extract_datetime_from_filename(filename):
    match = re.match(r'Wimple_(\d{4})_(\d{2})_(\d{2})_(\d{2})_(\d{2})_(\d{2})', filename)
    if match:
        year, month, day, hour, minute, second = match.groups()
        img_datetime = f'{year}-{month}-{day}', f'{hour}:{minute}:{second}'
        return img_datetime
    return None

@app.route('/insert_images_to_db')
def insert_images_to_db():
    image_folder_path = 'D:\AI Project\Test Data\AI_Result_img'  # 이미지 파일이 있는 폴더 경로 입력
    image_files = os.listdir(image_folder_path)

    for image_file in image_files:
        if image_file.startswith('Wimple_'):
            img_datetime = extract_datetime_from_filename(image_file)
            if img_datetime:
                img_url = f'http://localhost:8080/image/{image_file}'  # 이미지 파일의 URL 형식을 만듭니다.
                
                # 이미지 정보를 데이터베이스에 삽입
                new_image = ImageLog(date=img_datetime[0], time=img_datetime[1], img_url=img_url)
                db.session.add(new_image)
    
    db.session.commit()
    return 'Images inserted to database successfully!'

if __name__ == '__main__':
    app.run(debug=True)
