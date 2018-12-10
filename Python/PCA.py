# -*- coding: utf-8 -*-
"""
Created on Mon Dec 10 12:31:56 2018

@author: Martin Wulff
"""

import numpy as np
import pandas as pd
import random as rd


# Importing Data:
data = open('database.txt').read();
S = data.split();
Index = S[0]
Data = data[1:,:];

u, s, v = np.linalg.svd(Data)


u

# Finding Eigen Values.


for i in range(1, length):
    

EigenVal.sort()
EigenVal.reverse()
print('Eigenvalues in descending order:')
for i in eig_pairs:
    print(i[0])
    
