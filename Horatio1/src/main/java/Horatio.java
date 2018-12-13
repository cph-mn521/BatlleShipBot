/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import battleship.interfaces.BattleshipsPlayer;
import tournament.player.PlayerFactory;
import battleship.interfaces.Fleet;
import battleship.interfaces.Position;
import battleship.interfaces.Board;
import battleship.interfaces.Ship;
import java.util.Random;

/**
 *
 * @author Martin Wulff
 */
public class Horatio implements BattleshipsPlayer {

    private int turnNumber = 1;
    private final static Random rnd = new Random();
    private int sizeX;
    private int sizeY;
    private int fleetblocks;
    private int nrOfShips;
    private StringBuilder DATA = new StringBuilder();
    private StringBuilder enemyShots = new StringBuilder();
    private StringBuilder ownShots = new StringBuilder();
    private StringBuilder ShipData = new StringBuilder();
    private StringBuilder emptyLineBuffer = new StringBuilder();

    private final Brain BigThink = new Brain();
    private ShipPlacer BoatsMan;
    private int[] Gameboard = new int[100];
    int pix;

    public Horatio() {

    }

    /**
     * Called in the beginning of each match to inform about the number of
     * rounds being played.
     *
     * @param rounds int the number of rounds i a match
     */
    @Override
    public void startMatch(int rounds, Fleet ships, int sizeX, int sizeY) {

        this.sizeX = sizeX;

        this.sizeY = sizeY;
        /*
        int mapsize = sizeX * sizeY;

        for (int i = 0; i < mapsize; i++) {
            emptyLineBuffer.append(",,");
        }
         */
        nrOfShips = ships.getNumberOfShips();

        fleetblocks = 0;
        for (Ship ship : ships) {
            fleetblocks += ship.size();
        }
        //DA.newDataEntry("d"+sizeX + "," + sizeY  +","+nrOfShips+"," + fleetblocks+"d");
    }

    /**
     * The method called when its time for the AI to place ships on the board
     * (at the beginning of each round).
     *
     * The Ship object to be placed MUST be taken from the Fleet given (do not
     * create your own Ship objects!).
     *
     * A ship is placed by calling the board.placeShip(..., Ship ship, ...) for
     * each ship in the fleet (see board interface for details on placeShip()).
     *
     * A player is not required to place all the ships. Ships placed outside the
     * board or on top of each other are wrecked.
     *
     * @param fleet Fleet all the ships that a player should place.
     * @param board Board the board were the ships must be placed.
     */
    @Override
    public void placeShips(Fleet fleet, Board board) {
        BoatsMan = new ShipPlacer(sizeX, sizeY);
        ShipData = new StringBuilder();
        String name = "";
        for (int i = 0; i < fleet.getNumberOfShips(); ++i) {
            Ship s = fleet.getShip(i);

            int[] placement = BoatsMan.placeShip(s.size());
            Position pos = new Position(placement[0], placement[1]);

            board.placeShip(pos, s, BoatsMan.getvertical());
        }

    }

    /**
     * Called every time the enemy has fired a shot.
     *
     * The purpose of this method is to allow the AI to react to the enemy's
     * incoming fire and place his/her ships differently next round.
     *
     * @param pos Position of the enemy's shot
     */
    @Override
    public void incoming(Position pos) {
        System.out.println("reeee!");
    }

    /**
     * Called by the Game application to get the Position of your shot.
     * hitFeedBack(...) is called right after this method.
     *
     * @param enemyShips Fleet the enemy's ships. Compare this to the Fleet
     * supplied in the hitFeedBack(...) method to see if you have sunk any
     * ships.
     *
     * @return Position of you next shot.
     */
    @Override
    public Position getFireCoordinates(Fleet enemyShips) {
        pix = BigThink.usebrain(Gameboard);
        int[] position = pixToCoordinates(pix);

        turnNumber++;
        return new Position(position[0], position[1]);
    }

    /**
     * Called right after getFireCoordinates(...) to let your AI know if you hit
     * something or not.
     *
     * Compare the number of ships in the enemyShips with that given in
     * getFireCoordinates in order to see if you sunk a ship.
     *
     * @param hit boolean is true if your last shot hit a ship. False otherwise.
     * @param enemyShips Fleet the enemy's ships.
     */
    @Override
    public void hitFeedBack(boolean hit, Fleet enemyShips) {
        if (hit) {
            Gameboard[pix] = 1;
        } else {
            Gameboard[pix] = -1;
        }

        //Do nothing
    }

    /**
     * Called at the beginning of each round.
     *
     * @param round int the current round number.
     */
    @Override
    public void startRound(int round
    ) {
        Gameboard = new int[100];
    }

    /**
     * Called at the end of each round to let you know if you won or lost.
     * Compare your points with the enemy's to see who won.
     *
     * @param round int current round number.
     * @param points your points this round: 100 - number of shot used to sink
     * all of the enemy's ships.
     *
     * @param enemyPoints int enemy's points this round.
     */
    @Override
    public void endRound(int round, int points, int enemyPoints
    ) {
        if (points > enemyPoints) {
            System.out.println("Heeheee.");
        }

        //Do nothing endgame stuff here
    }

    /**
     * Called at the end of a match (that usually last 1000 rounds) to let you
     * know how many losses, victories and draws you scored.
     *
     * @param won int the number of victories in this match.
     * @param lost int the number of losses in this match.
     * @param draw int the number of draws in this match.
     */
    @Override
    public void endMatch(int won, int lost, int draw
    ) {
        //Do nothing not of wurf to our data.
    }

    private int[] pixToCoordinates(int in) {
        int[] out = new int[2];
        out[0] = in % 10 + 1;
        out[1] = 10 - (int) (in / 10);
        return out;
    }
}
