# -*- coding: utf-8 -*-
"""
Created on Wed Dec 12 12:38:50 2018

@author: Martin Wulff
"""

import numpy as np
import pandas as pd
import random as rd
import os
outputset =[]
targetSet = []
InputData = np.zeros(100)

def toVectorIndex(x,y,val,out):
    out[100-10*int(y+1)+int(x+1)-1]=val
    return

a,b = own_shot_data.shape
for i in range(0,a-1):
    for j in range(2,b-1,3):
        if(own_shot_data[j][i]):
            for n in range(0,j-3,3):
                if(own_shot_data[n+2][i]): toVectorIndex(own_shot_data[n][i],own_shot_data[n+1][i],1,InputData)
                else: toVectorIndex(own_shot_data[n][i],own_shot_data[n+1][i],-1,InputData)
            outputset.append(InputData)
            InputData = np.zeros(100)
            toVectorIndex(own_shot_data[j-2][i],own_shot_data[j-1][i],1,InputData)
            targetSet.append(InputData)
            InputData = np.zeros(100)
            
            
            
        
def toCordinateIndex(i):
    row = int(i%10)+1
    collum =10-int((i/10))
    return [row,collum]

def f(x,y):
    return 100-10*int(y)+int(x)-1
    