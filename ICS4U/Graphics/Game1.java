/* Game1.java
 * This example uses two classes for the basic set-up to fix the coordinate problem.
 *  
 * We Add a KeyListener to move a box on the screen, but we see that there is a problem 
 * putting our code in the keyPressed event.
 *
 **/
 
 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game1 extends JFrame{
	GamePanel game= new GamePanel();
		
    public Game1() {
		super("Move the Box");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(game);
		pack();  // set the size of my Frame exactly big enough to hold the contents
		setVisible(true);
    }
    
    public static void main(String[] arguments) {
		Game1 frame = new Game1();		
    }
}

class GamePanel extends JPanel implements KeyListener{
	private int boxx, boxy;
	public GamePanel(){
		boxx = 400;
		boxy = 300;
		setPreferredSize(new Dimension(800, 600));
		
		setFocusable(true);  // By default, the JFrame has focus. This means when 
		requestFocus();      // we press keys they go to it.

		addKeyListener(this);
	}

	
	/* This is triggered when a key would be typed in an editor. This does not trigger
	 * for keys that do not produce typing like the arrow keys. If you press and hold
	 * It will trigger once, wait a bit then trigger frequently. Not good for most games.
	 */
	@Override
	public void keyTyped(KeyEvent ke){
		System.out.println("KEY TYPED");
	}

	// Triggers oince when a key on the keyboard goes up.
	@Override
	public void keyReleased(KeyEvent ke){
		
	}	
	
	// Same as keyTyped, but works for all keys.
	@Override
	public void keyPressed(KeyEvent ke){
		int key = ke.getKeyCode();
		if(key == KeyEvent.VK_LEFT){
			boxx -= 10;
		}		
		else if(key == KeyEvent.VK_RIGHT){
			boxx += 10;
		}		
		else if(key == KeyEvent.VK_UP){
			boxy -= 10;
		}		
		else if(key == KeyEvent.VK_DOWN){
			boxy += 10;
		}
		repaint();
	}


	@Override
	public void paint(Graphics g){
		g.setColor(new Color(111,222,111));
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(Color.RED);
		g.fillRect(boxx,boxy,40,40);
    }
}