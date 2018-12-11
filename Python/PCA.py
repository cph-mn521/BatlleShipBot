# -*- coding: utf-8 -*-
"""
Created on Mon Dec 10 12:31:56 2018

@author: Martin Wulff
"""
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
import random as rd
import os
os.chdir("C:\\Users\\Martin Wulff\\Documents\\BattelShipBot\\BatlleShipBot\\Python")


# Importing Data:
input = pd.read_csv('Data.txt')
data = input.split();
data.split(",")
Index = S[0]
Data = data[1:,:];
df = game_data.as_matrix

u, s, v = np.linalg.svd(game_data)


u

# Finding Eigen Values.
u
Eigenval = np.zeros(u.length())
print('Eigenvalues in descending order:')
for i in range(0, u.length()):
    Eigenval[i]= u[i,i]
    print(Eigenval[i])


#Plot of eigenvalue and caputred variance
tot = sum(s)
var_exp = [(i / tot)*100 for i in sorted(s, reverse=True)]
cum_var_exp = np.cumsum(var_exp)

plt.bar(range(1,len(var_exp)+1),var_exp)


#Projecting Data onto the first 3 principal components.
vectors = v[0:2,:]
Y = game_data.dot(np.transpose(vectors))
fig = plt.figure()
plt.scatter(Y[0],Y[1])
plt.grid()
plt.show()




#PCA for own shot data.
u, s, v = np.linalg.svd(own_shot_data)

#Plot of eigenvalue and caputred variance
tot = sum(s)
var_exp = [(i / tot)*100 for i in sorted(s, reverse=True)]
cum_var_exp = np.cumsum(var_exp)

plt.bar(range(1,len(var_exp)+1),var_exp)


#Projecting Data onto the first 3 principal components.
vectors = v[0:2,:]
Y = game_data.dot(np.transpose(vectors))
fig = plt.figure()
plt.scatter(Y[0],Y[1])
plt.grid()
plt.show()


