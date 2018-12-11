# -*- coding: utf-8 -*-

import matplotlib as plot
import pandas as pd
import numpy as nm
import sklearn
import scipy
import os

# changes the path on the computerr
if "nille" not in os.getcwd():
    path = "C:/Users/Martin Wulff/Documents/BattelShipBot/BatlleShipBot/Python"
else:
    path = "C:/Users/nille/Dropbox/Skole/CPHBusiness - Datamatiker/Projekter/BatlleShipBot/Udleveret Materiale/BattleShipsTournament_4"

os.chdir(path)

# Input files
game_data_file = "Data.txt"
own_shot_data_file = "OwnShots.txt"
enemy_shot_data_file = "EnemyShots.txt"

# read data
game_data = pd.read_csv(game_data_file)


####Since enemy data is uneven:

# Delimiter
data_file_delimiter = ','

# The max column count a line in the file could have
largest_column_count = 0

# Loop the data lines
with open(enemy_shot_data_file, 'r') as enemy_shot_temp:
    # Read the lines
    lines =enemy_shot_temp.readlines()
    
    for l in lines:
        # Count the column count for the current line
        column_count = len(l.split(data_file_delimiter)) + 1

        # Set the new most column count
        largest_column_count = column_count if largest_column_count < column_count else largest_column_count

# Close file
enemy_shot_temp.close()

# Generate column names (will be 0, 1, 2, ..., largest_column_count - 2)
column_names = [i for i in range(0, largest_column_count -2)]

# Read the data
enemy_shot_data = pd.read_csv(enemy_shot_data_file, 
                                      header=None,
                                      names = column_names, 
                                      delimiter=data_file_delimiter, 
                                      usecols = range(1,largest_column_count-1)
                                      ).fillna(0)
own_shot_data = pd.read_csv(own_shot_data_file, 
                            header= None, 
                            names = column_names, 
                            delimiter = data_file_delimiter
                            ).fillna(0)




#cleans unwanted variables
del [column_count, column_names, data_file_delimiter, l, lines, largest_column_count]