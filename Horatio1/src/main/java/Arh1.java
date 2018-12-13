
import battleship.interfaces.BattleshipsPlayer;
import tournament.player.PlayerFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin Wulff
 */
public class Arh1 implements PlayerFactory<BattleshipsPlayer>{
    public Arh1(){}
    
    @Override
    public BattleshipsPlayer getNewInstance()
    {
        return new Horatio();
    }

    @Override
    public String getID()
    {
        return "E1";
    }

    @Override
    public String getName()
    {
        return "Random player";
    }

    @Override
    public String[] getAuthors()
    {
        String[] res = {"Tobias Grundtvig", "Hans Hansen"};
        return res;
    }
    
}
