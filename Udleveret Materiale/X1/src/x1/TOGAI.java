/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;


import battleship.interfaces.BattleshipsPlayer;
import battleship.interfaces.Board;
import battleship.interfaces.Fleet;
import battleship.interfaces.Position;
import java.util.Random;
import x1.placers.ShipPlacer;
import x1.shooters.Shooter;

/**
 *
 * @author Tobias Grundtvig
 */
public class TOGAI implements BattleshipsPlayer
{
    private final Random rnd;
    private Shooter shooter;
    private ShipPlacer placer;
    private int round;

    public TOGAI()
    {
        rnd = new Random();
        shooter = null;
        placer = null;
        
    }
    
    @Override
    public void startMatch(int rounds, Fleet ships, int sizeX, int sizeY)
    {
        shooter = new Shooter(sizeX, sizeY, rnd);
        placer = new ShipPlacer(sizeX, sizeY, rnd);
    }

    @Override
    public void startRound(int round)
    {
       this.round = round;
    }

    @Override
    public void placeShips(Fleet fleet, Board board)
    {
        shooter.newRound(round);
        placer.placeShips(fleet, board);
    }

    @Override
    public void incoming(Position pos)
    {
        placer.incoming(pos);
    }

    @Override
    public Position getFireCoordinates(Fleet enemyShips)
    {
        return shooter.getFireCoordinates(enemyShips);
    }

    @Override
    public void hitFeedBack(boolean hit, Fleet enemyShips)
    {
        shooter.hitFeedBack(hit, enemyShips);
    }

    @Override
    public void endRound(int round, int points, int enemyPoints)
    {
        
    }

    @Override
    public void endMatch(int won, int lost, int draw)
    {
        
    }
}
