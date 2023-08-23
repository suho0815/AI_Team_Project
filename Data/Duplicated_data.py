import pandas as pd


recycling_data = pd.read_csv("D:\AI Project\Test Data\AI_Result_Convert.csv")

recycling_data = recycling_data.drop_duplicates(subset=["detect_log_id"])

print("Recycling Data After Removing Duplicates:")
print(recycling_data)

recycling_data.to_csv('treated_recycling_data.csv') # 그냥 csv로 저장