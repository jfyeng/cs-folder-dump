/* OOP Test for ICS4U
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.Random;

class IslandMap{
	
	private Color[]colours = {new Color(52,118,153), new Color(240,214,151), new Color(92, 162, 200), new Color(110, 214, 90)};
	private	int [][] map;

    public static final int DEEP = 0, SAND = 1, SHALLOW = 2, GREEN = 3;
	
	public IslandMap(int [][] map){
		this.map = map;
	}
   	
	public void draw(Graphics g){
		for(int x=0; x<map.length; x++){			
			for(int y=0; y<map[x].length; y++){
				int val = map[x][y];
				g.setColor(colours[val]);
				g.fillRect(x*64,y*64,64,64);
			}
		}
	}	

    public int get(Point p) {
        return get(p.x, p.y);
    }

    public int get(int x, int y) {
        if (x < 0 || map[0].length <= x ||
            y < 0 || map.length <= y) return -1;
        return map[y][x];
    }

    public void set(Point p, int val) {
        return set(p.x, p.y, val);
    }

    public void set(int x, int y, int val) {
        if (x < 0 || map[0].length <= x ||
            y < 0 || map.length <= y) return;
        map[y][x] = val;
    }


    public ArrayList<Point> adjacentTiles(Point p) {
        ArrayList<Point> ret = new ArrayList<Point>();
        for (int y = p.y-1; y <= p.y+1; ++y) {
            for (int x = p.x-1; x <= p.x+1; ++x) {
                if (x < 0 || map[0].length <= x ||
                    y < 0 || map.length <= y) continue;
                ret.add(new Point(x, y));
            }
        }
        return ret;
    }

    public void addShallows() {
        for (int y = 0; y < map.length; ++y) {
            for (int x = 0; x < map[0].length; ++x) {
            }
        }
    }

    public int islandSize(Point p) {
        if (x < 0 || map[0].length <= x ||
            y < 0 || map.length <= y) return 0;
    }
}