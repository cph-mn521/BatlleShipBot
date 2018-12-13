# -*- coding: utf-8 -*-

#import matplotlib as plot
import pandas as pd
#import numpy as nm
#import sklearn
#import scipy
import os

# changes the path on the computerr
if "nille" and "Lord" not in os.getcwd():
    path = "C:/Users/Martin Wulff/Documents/BattelShipBot/BatlleShipBot/Python"

elif "Lord" in os.getcwd():
    path = "C:/Users/Lord/Documents/GitHub/BatlleShipBot/Udleveret Materiale/BattleShipsTournament_4"
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
enemy_largest_column_count = 0
own_largest_column_count = 0

# Loop the data lines
with open(enemy_shot_data_file, 'r') as enemy_shot_temp:
    # Read the lines
    enemy_lines = enemy_shot_temp.readlines()    
    
    for l in enemy_lines:
        # Count the column count for the current line
        enemy_column_count = len(l.split(data_file_delimiter))

        # Set the new most column count
        enemy_largest_column_count = enemy_column_count if enemy_largest_column_count < enemy_column_count else enemy_largest_column_count

    
# Close file
enemy_shot_temp.close()

enemy_column_names = [i for i in range(0, enemy_largest_column_count -1)]

enemy_shot_data = pd.read_csv(enemy_shot_data_file, 
                                      header=None,
                                      names = enemy_column_names, 
                                      delimiter=data_file_delimiter, 
                                      usecols = range(1,enemy_largest_column_count)
                                      ).fillna(0)

with open(own_shot_data_file, 'r') as own_shot_temp:
    #readlines
    own_lines = own_shot_temp.readlines()

for l in own_lines:
        # Count columns for current line
        own_column_count = len(l.split(data_file_delimiter))
        
        # Set hte new most column count
        own_largest_column_count = own_column_count if own_largest_column_count < own_column_count else own_largest_column_count

own_shot_temp.close()

# Generate column names (will be 0, 1, 2, ..., largest_column_count)

own_column_names = [i for i in range(0,own_largest_column_count)]

# Read the data

own_shot_data = pd.read_csv(own_shot_data_file, 
                            header= None, 
                            names = own_column_names, 
                            delimiter = data_file_delimiter
                            ).fillna(0)



#standarized datasets
from sklearn.preprocessing import StandardScaler
sc = StandardScaler()
enemy_shot_data_std = sc.fit_transform(enemy_shot_data)
game_data_std = sc.fit_transform(game_data)
own_shot_data_std = sc.fit_transform(own_shot_data)

#normalized datasets
from sklearn.preprocessing import normalize
enemy_shot_data_nml = normalize(enemy_shot_data, axis = 0)
own_shot_data_nml = normalize(own_shot_data, axis = 0)
game_data_nml = normalize(game_data, axis = 0)

#cleans unwanted variables
del [own_column_count, own_column_names, own_largest_column_count, own_shot_data_file, own_lines, 
     enemy_column_names, enemy_column_count, enemy_largest_column_count, enemy_shot_data_file, enemy_lines,
     data_file_delimiter, l,
     game_data_file, path]