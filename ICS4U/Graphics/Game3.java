/* Game3.java
 * This example add 3 things.
 * 1. How to load and display an image.
 * 2. Mouse interactions.
 * 3. Although we can have multiple windows in Swing, it is usually
 *    easiest to just have one, and keep track of what screen we are on. 
 **/
 
 
 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game3 extends JFrame{
	GamePanel game= new GamePanel();
		
    public Game3() {
		super("Move the Box");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(game);
		pack();
		setVisible(true);
    }
    
    public static void main(String[] arguments) {
		new Game3();		
    }
}

class GamePanel extends JPanel implements KeyListener, ActionListener, MouseListener{
	public static final int INTRO=0, GAME=1, END=2;
	private int screen = INTRO;
	
	private boolean []keys;
	Timer timer;
	Image back;
	private Ball ball; 
	
	public GamePanel(){
		/* Java graphics started with a slow Internet in mind. There was a simple
		 * getImage command, but it did not load the image right away to avoid freezing
		 * the web page. There are a few ways to force the image to be loaded immediately, 
		 * This is the way I prefer.
		 */
		back = new ImageIcon("OuterSpace.jpg").getImage();
		keys = new boolean[KeyEvent.KEY_LAST+1];
		ball = new Ball(400,300);
		
		setPreferredSize(new Dimension(800, 600));
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
		addMouseListener(this);
		timer = new Timer(20, this);
		timer.start();
	}

	public void move(){
		if(screen == INTRO){
			
		}
		else if(screen == GAME){
			ball.move();
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		move(); 
		repaint(); 

	}
	
	@Override
	public void keyReleased(KeyEvent ke){
		int key = ke.getKeyCode();
		keys[key] = false;
	}	
	
	@Override
	public void keyPressed(KeyEvent ke){
		int key = ke.getKeyCode();
		keys[key] = true;
	}
	
	@Override
	public void keyTyped(KeyEvent ke){}
	@Override
	public void	mouseClicked(MouseEvent e){}

	@Override
	public void	mouseEntered(MouseEvent e){}

	@Override
	public void	mouseExited(MouseEvent e){}

	@Override
	public void	mousePressed(MouseEvent e){
		if(screen == INTRO){
			screen = GAME;
		}	
	}

	@Override
	public void	mouseReleased(MouseEvent e){}

	@Override
	public void paint(Graphics g){
		if(screen == INTRO){
			g.setColor(new Color(137,196,234));
			g.fillRect(0,0,getWidth(), getHeight());					
		}
		else if(screen == GAME){
			// The last parameter is an ImageObserver. Back when images were not loaded
			// right away you would specify what object would be notified when it was loaded.
			// We are not doing that, so null will always be fine.
			g.drawImage(back, 0, 0, null);
			ball.draw(g);
		}
    }
}

class Ball{
	private int x, y, vx;
	
	public Ball(int xx, int yy){
		x = xx;
		y = yy;
		vx = 5;
	}
	
	public void move(){
		x += vx;
		if(x<0 || x>800){
			vx *= -1;
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(x,y,20,20);
	}
}