# -*- coding: utf-8 -*-
"""
Created on Wed Dec 12 14:12:20 2018

@author: Lord
"""
import matplotlib
import matplotlib.pyplot as plt
from keras.models import Sequential
from keras.layers import LSTM, Dense, Activation
import numpy as np

model = Sequential()

model.add(Dense(100,input_dim=100,activation = "relu"))
model.add(Dense(100,activation = "sigmoid"))
model.add(Dense(100,activation = "sigmoid"))
model.add(Dense(100, activation = "sigmoid"))
model.summary()

model.compile(optimizer = "adam", loss = "binary_crossentropy",metrics=["accuracy"])

results = model.fit(X_train,y_train, 
                    epochs =400, 
                    batch_size = 50, 
                    validation_data = (X_test,y_test))



sampleVector = "somedatahere"


result = model.predict(samplevector)


fig, ax = plt.subplots()

plt.setp(rotation = 45, ha="right",rotation_mode="anchor")

fig.tight_layout()

plt.show()




tesdt 