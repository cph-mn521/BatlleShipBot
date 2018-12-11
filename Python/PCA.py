# -*- coding: utf-8 -*-
"""
Created on Mon Dec 10 12:31:56 2018

@author: Martin Wulff
"""
import plotly.plotly as py
from plotly.graph_objs import *
import plotly.tools as tls
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
df = df.fillna(0)
u, s, v = np.linalg.svd(np.transpose(df))


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

trace1 = Bar(
        x=['PC %s' %i for i in range(1,5)],
        y=var_exp,
        showlegend=False)

trace2 = Scatter(
        x=['PC %s' %i for i in range(1,5)], 
        y=cum_var_exp,
        name='cumulative explained variance')

data = Data([trace1, trace2])

layout=Layout(
        yaxis=YAxis(title='Explained variance in percent'),
        title='Explained variance by different principal components')

fig = Figure(data=data, layout=layout)
py.iplot(fig)

# Projection onto eigen subspace.
W_mat = Data.dot(v[0:2])

