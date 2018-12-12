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
    out[(int(x)-1)*10+int(y)]=val
    return


for i in range(0,2000-1):
    for j in range(2,300-1,3):
        if(own_shot_data[j][i]):
            for n in range(0,j-3,3):
                if(own_shot_data[n+2][i]): toVectorIndex(own_shot_data[n][i],own_shot_data[n+1][i],1,InputData)
                else: toVectorIndex(own_shot_data[n][i],own_shot_data[n+1][i],-1,InputData)
            outputset.append(InputData)
            InputData = np.zeros(100)
            toVectorIndex(own_shot_data[j-2][i],own_shot_data[j-1][i],1,InputData)
            targetSet.append(InputData)
            InputData = np.zeros(100)
            
            
            
        
    
    
