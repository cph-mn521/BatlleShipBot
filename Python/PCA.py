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

if "nille" not in os.getcwd():
    os.chdir("C:\\Users\\Martin Wulff\\Documents\\BattelShipBot\\BatlleShipBot\\Python")
else:
    os.chdir("C:/Users/nille/Dropbox/Skole/CPHBusiness - Datamatiker/Projekter/BatlleShipBot/Udleveret Materiale/BattleShipsTournament_4")

#Finding all won games
results = game_data['matchResult']
wongames  = []
lostgames = []
tiedgames = []
for i in range(0,len(results)):
    if results[i] < 0:
        lostgames.append(i)
    if results[i] > 0:
        wongames.append(i)
    if results[i] == 0:
        tiedgames.append(i)



#svd
u, s, v = np.linalg.svd(game_data)


#Plot of eigenvalue and caputred variance
tot = sum(s)
var_exp = [(i / tot)*100 for i in sorted(s, reverse=True)]
cum_var_exp = np.cumsum(var_exp)

plt.bar(range(1,len(var_exp)+1),var_exp)


#Projecting Data onto the first 3 principal components.
vectors = v[0:2,:]

Y = game_data.dot(np.transpose(vectors))
T1 = Y.loc[wongames]
T2 = Y.loc[tiedgames]
T3 = Y.loc[lostgames]
fig = plt.figure()

plt.scatter(T3[0],T3[1],color='blue')
plt.scatter(T2[0],T2[1],color='green')
plt.scatter(T1[0],T1[1],color='red')
plt.grid()
plt.show()




#PCA for own shot data.
ShotData = own_shot_data.fillna(0)
u, s, v = np.linalg.svd(ShotData)


#Plot of eigenvalue and caputred variance
tot = sum(s)
var_exp = [(i / tot)*100 for i in sorted(s, reverse=True)]
cum_var_exp = np.cumsum(var_exp)

plt.bar(range(1,len(var_exp)+1),var_exp)


#Projecting Data onto the first 3 principal components.
vectors = v[0:2,:]
Y = ShotData.dot(np.transpose(vectors))
T1 = Y.loc[wongames]
T2 = Y.loc[tiedgames]
T3 = Y.loc[lostgames]
fig = plt.figure()

plt.scatter(T3[0],T3[1],color='blue')
plt.scatter(T2[0],T2[1],color='green')
plt.scatter(T1[0],T1[1],color='red')
plt.grid()
plt.show()


#PCA forcombined data


DATA = pd.concat([game_data,own_shot_data],axis =1 )
u, s, v = np.linalg.svd(DATA)


#Plot of eigenvalue and caputred variance
tot = sum(s)
var_exp = [(i / tot)*100 for i in sorted(s, reverse=True)]
cum_var_exp = np.cumsum(var_exp)

plt.bar(range(1,len(var_exp)+1),var_exp)


#Projecting Data onto the first 3 principal components.
vectors = v[0:2,:]
Y = DATA.dot(np.transpose(vectors))
T1 = Y.loc[wongames]
T2 = Y.loc[tiedgames]
T3 = Y.loc[lostgames]
fig = plt.figure()

plt.scatter(T3[0],T3[1],color='blue')
plt.scatter(T2[0],T2[1],color='green')
plt.scatter(T1[0],T1[1],color='red')
plt.grid()
plt.show()




DATA_nm = np.concatenate((game_data_nml,own_shot_data_nml),axis=1)
u, s, v = np.linalg.svd(DATA_nm)

vectors = v[0:2,:]
Y = DATA_nm.dot(np.transpose(vectors))
T1 = Y[wongames]
T2 = Y[tiedgames]
T3 = Y[lostgames]


fig = plt.figure()

plt.scatter(T3[:,0],T3[:,1],color='blue')
plt.scatter(T2[:,0],T2[:,1],color='green')
plt.scatter(T1[:,0],T1[:,1],color='red')
plt.grid()
plt.show()










test =np.matrix([[1, 2],[2, 4],[3, 4],[3, 5],[5, 6]])
ind = [0,2,4]




test[ind]


Y.as_matrix[ind]

