/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package x1;

import battleship.interfaces.BattleshipsPlayer;
import tournament.player.PlayerFactory;

/**
 *
 * @author Tobias Grundtvig
 */
public class X1 implements PlayerFactory<BattleshipsPlayer>
{

    public X1(){}
    
    
    @Override
    public BattleshipsPlayer getNewInstance()
    {
        return new TOGAI();
    }

    @Override
    public String getID()
    {
        return "X1";
    }

    @Override
    public String getName()
    {
        return "Codename: Litra A";
    }

    @Override
    public String[] getAuthors()
    {
        String[] res = {"Tobias Grundtvig"};
        return res;
    }
}
