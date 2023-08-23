from flask import Flask, request, jsonify
# from flask_sqlalchemy import SQLAlchemy
import psycopg2
import os
import re

app = Flask(__name__)

# DB Connect
def connectDB():
    return psycopg2.connect(
        dbname='AI_resultSet_test',
        user='postgres',
        host='localhost',
        password='tiger',
        port=5432
    )
    
@app.route('/update_image', methods=["PUT"])
def update_image():
    try:
      image_dir = 'C:\AI_Result_img'  # 이미지 파일이 있는 폴더 경로 입력

      conn = connectDB()
      cur = conn.cursor()
      
      for filename in os.listdir(image_dir):
          if filename.endswith('.jpg') or filename.endswith('.png'):
              image_path = os.path.join(image_dir, filename)
              image_url = f'http://localhost:8080/images/{filename}'
              
              # Insert ImageURL to DB
              cur.execute('update recycling_img set img_url = %s where id = %d', (image_url,))
    
            # 
      conn.commit()
    #   close DB
      conn.close()
      
      response = {'message': 'Image URLs updated successfully'}
      return jsonify(response), 200
    except Exception as e:
      response = {'message': 'Error occurred', 'error': str(e)}
      return jsonify(response), 500
      
# @app.route('/read_images', methods=['GET'])
# def readIMG():
    
if __name__ == '__main__':
    app.run(host='localhost', port=8080, debug=True)
