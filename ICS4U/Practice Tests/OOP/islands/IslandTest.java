/* Challenge Test for ICS4U
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class IslandTest extends BaseFrame{	
	private IslandMap islands;
		
    public static void main(String[] args) {
		int [][] map = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
							{1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
							{1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
							{0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
							{0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
							
		IslandTest frame = new IslandTest(map);
    }
    
    public IslandTest(int [][]map){
   		super("OOP Test", map.length*64,map[0].length*64);   	
		islands = new IslandMap(map);
    }
    
    @Override
	public void draw(Graphics g){
		islands.draw(g);
		
	}	
}