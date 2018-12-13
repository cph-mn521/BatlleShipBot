/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Martin Wulff
 */
public class ShipPlacer {

    private boolean[][] map;
    public final int x;
    public final int y;
    private final Random rd = new Random();
    private boolean vertical;

    public ShipPlacer(int x, int y) {
        this.x = x;
        this.y = y;
        map = new boolean[x][y];
        Arrays.fill(map, Boolean.FALSE);

    }

    public int[] placeShip(int size) {
        int[] position = new int[2];
        boolean vert = rd.nextBoolean();
        randomPos(position);
        if(!Placeable(position,size,vert)) return placeShip(size);
        else {
            addtomap(position,size,vert);
            vertical = vert;
            return position;
        }
        

    }

    public void addtomap(int[] pos, int size, boolean vert) {
        if (vert) {
            for (int i = 0; i < size; i++) {
                map[pos[0] + i][pos[1]] = true;
            }
        } else {
            for (int i = 0; i < size; i++) {
                map[pos[0]][pos[1]+i] = true;
            }
        }
    }
    
    
    

    public boolean Placeable(int[] pos, int size, boolean vert) {
        if (vert) {
            if (x + size > this.x - 1) {
                return false;
            } else {
                for (int i = 0; i < size; i++) {
                    if (map[pos[0]][pos[1] + i]) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            if (y + size > this.y - 1) {
                return false;
            } else {
                for (int i = 0; i < size; i++) {
                    if (map[pos[0] + 1][pos[1]]) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public void randomPos(int[] in) {
        in = new int[]{rd.nextInt(10), rd.nextInt(10)};
       

    }
    
    public boolean getvertical(){
        return vertical;
    }

}
