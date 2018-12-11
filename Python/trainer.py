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

# Input files
game_data_file = "Data.txt"
own_shot_data_file = "OwnShots.txt"
enemy_shot_data_file = "EnemyShots.txt"

# read data
game_data = pd.read_csv(game_data_file)

#Since data might be uneven.
own_shot_data = pd.read_csv(own_shot_data_file,header = None)
enemy_shot_data = pd.read_csv(enemy_shot_data_file, header = None)




# Set the new most column count
largest_column_count = column_count if largest_column_count < column_count else largest_column_count

# Close file
temp_f.close()



# Generate column names (will be 0, 1, 2, ..., largest_column_count - 1)
column_names = [i for i in range(0, largest_column_count)]

# Read csv
df = pd.read_csv(data_file, header=None, delimiter=data_file_delimiter, names=column_names)
# print(df)

