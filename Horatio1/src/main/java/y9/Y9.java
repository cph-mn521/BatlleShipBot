package y9;

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
public class Y9 implements PlayerFactory<BattleshipsPlayer> {

    public Y9() {
    }

    @Override
    public BattleshipsPlayer getNewInstance() {
        return new Horatio();
    }

    @Override
    public String getID() {
        return "Y9";
    }

    @Override
    public String getName() {
        return "Horatio";
    }

    @Override
    public String[] getAuthors() {
        String[] res = {"Niels Bang", "Martin Wulff"};
        return res;
    }

}
