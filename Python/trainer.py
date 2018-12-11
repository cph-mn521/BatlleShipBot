# -*- coding: utf-8 -*-

import matplotlib as plot
import pandas as pd
import numpy as nm
import sklearn
import scipy
import os

if "nille" not in os.getcwd():
    path = "C:/Users/Martin Wulff/Documents/BattelShipBot/BatlleShipBot/Python"
else:
    path = "C:/Users/nille/Dropbox/Skole/CPHBusiness - Datamatiker/Projekter/BatlleShipBot/Udleveret Materiale/BattleShipsTournament_4"

os.chdir(path)

# Input
data_file = "Data.txt"

# Delimiter
data_file_delimiter = ','

# The max column count a line in the file could have
largest_column_count = 0

# Loop the data lines
with open(data_file, 'r') as temp_f:
    # Read the lines
    lines = temp_f.readlines()

    for l in lines:
        # Count the column count for the current line
        column_count = len(l.split(data_file_delimiter)) + 1

        # Set the new most column count
        largest_column_count = column_count if largest_column_count < column_count else largest_column_count

# Close file
temp_f.close()



# Generate column names (will be 0, 1, 2, ..., largest_column_count - 1)
column_names = [i for i in range(0, largest_column_count)]

# Read csv
df = pd.read_csv(data_file, header=None, delimiter=data_file_delimiter, names=column_names)
# print(df)
