# -*- coding: utf-8 -*-

import matplotlib as plot
import pandas as pd
import numpy as nm
import sklearn
import scipy
import os

if "nille" not in os.getcwd():
    path = "Martin indsæt din sti her."
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



