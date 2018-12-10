/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipstournament;

import battleship.implementations.Battleships;
import battleship.interfaces.BattleshipsPlayer;
import java.util.ArrayList;
import java.util.Collection;
import tournament.Tournament;
import tournament.impl.simpleui.TextTournamentUI;
import tournament.player.PlayerFactory;
import java.io.File;
import battleshipstournament.DataAcessor;
import battleshipstournament.DataException;

/**
 *
 * @author Tobias
 */
public class ExampleTournament {

    public static void main(String[] args) {
        int numberofplayers = 2; //number of random players for generating data.
        int numberofships = 5;
        //Resets files
        File data = new File("Data.txt");
        File enemyshots = new File("EnemyShots.txt");
        File ownshots = new File("OwnShots.txt");
        if (data.delete()) {
            System.out.println("Data deleted");
        } else {
            System.out.println("Data not deleted");
        }
        if (enemyshots.delete()) {
            System.out.println("Enemyshots deleted");
        } else {
            System.out.println("enemyshots not deleted.");
        }
        if (ownshots.delete()) {
            System.out.println("own shots deleted");
        } else {
            System.out.println("own shots not deleted.");
        }

        DataAcessor dataA = new DataAcessor("Data.txt");
        DataAcessor enshA = new DataAcessor("EnemyShots.txt");
        DataAcessor owshA = new DataAcessor("OwnShots.txt");

        StringBuilder dataEntry = new StringBuilder();
        dataEntry.append("mapX,mapY,NumberOfShips,Blocks");

        for (int i = 0; i < numberofships; i++) {
            dataEntry.append(",ship").append(i).append(",ship").append(i).append("x,ship").append(i).append("y").append(",ship").append(i).append("vertical");
        }
        dataEntry.append(",myScore").append(",enemyScore").append(",matchResult");

        try {
            dataA.addEntry(dataEntry.toString());
        } catch (DataException e) {
            e.printStackTrace();
        }
        Loader loader;
        if (data.getAbsolutePath().contains("nille")) {
            loader = new Loader("C:\\Users\\nille\\Dropbox\\Skole\\CPHBusiness - Datamatiker\\Projekter\\BatlleShipBot\\Udleveret Materiale");
        } else {
            loader = new Loader("C:\\Martins sti her");
        }

        Collection<PlayerFactory<BattleshipsPlayer>> listOfAIs = new ArrayList<>();

        for (int i = 0; i < numberofplayers; i++) {
            listOfAIs.add(loader.loadAI("E1\\dist\\E1.jar", "e1.E1"));
        }

        //listOfAIs.add(loader.loadAI("X1\\dist\\X1.jar", "x1.X1"));
        TextTournamentUI.turnOffIO();
        Tournament.run(Battleships.getGameFactory(), listOfAIs, true);
        TextTournamentUI.turnOnIO();

        //adds correct headers to files
    }
}
