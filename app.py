from flask import Flask, request, jsonify
from joblib import load
import json
import numpy as np

app = Flask(__name__)

# Load the saved SVM model
loaded_svm_model = load('svm_model.joblib')

# Load column names
with open('column_names.json', 'r') as f:
    column_names = json.load(f)

@app.route('/predict', methods=['POST'])
def predict():
    try:
        # Get array of feature values from request
        data = request.json
        
        # Ensure that all required features are provided
        if len(data) != len(column_names):
            return jsonify({'error': 'Incorrect number of features provided'}), 400
        
        # Convert input data to a numpy array
        input_data = np.array([[data[col] for col in column_names]], dtype=float)
        
        # Make prediction using the loaded SVM model
        prediction = loaded_svm_model.predict(input_data)
        
        # Convert prediction to Python integer
        prediction = int(prediction[0])
        
        return jsonify({'prediction': prediction})
    
    except Exception as e:
        return jsonify({'error': str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True)
