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

/**
 *
 * @author Tobias
 */
public class ExampleTournament {

    public static void main(String[] args) {
        int numberofplayers = 3; //number of random players for generating data.

        Loader loader = new Loader("C:\\Users\\nille\\Dropbox\\Skole\\CPHBusiness - Datamatiker\\Projekter\\BatlleShipBot\\Udleveret Materiale");

        Collection<PlayerFactory<BattleshipsPlayer>> listOfAIs = new ArrayList<>();

        for (int i = 0; i < numberofplayers; i++) {
            listOfAIs.add(loader.loadAI("E1\\dist\\E1.jar", "e1.E1"));
        }

        //listOfAIs.add(loader.loadAI("X1\\dist\\X1.jar", "x1.X1"));
        TextTournamentUI.turnOffIO();
        Tournament.run(Battleships.getGameFactory(), listOfAIs, true);

        TextTournamentUI.turnOnIO();
    }
}
