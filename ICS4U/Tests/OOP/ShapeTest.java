import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapeTest extends JFrame {
    int mx, my;
    private final int NUM_RECT = 25;
    
    Rect [] rList = new Rect[NUM_RECT];
    
    double rand(double a, double b){
		return Math.random()*(b-a) + a;
    }
    
    public ShapeTest(){
		super ("Fun with Boxes");

		for(int i=0; i<NUM_RECT; i++){
		    rList[i] = new Rect(rand(0,450),rand(30,450),rand(10,50),rand(10,50));
		}        
			
		setSize (500, 500);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setVisible (true);
    }

    public boolean overlaps(Rect r){
		int c=0;
			
		// Uncomment if overlap() works
		for(int i=0; i<NUM_RECT; i++){
		   if(r.overlaps(rList[i]))
			c++;
		}
		return c==1? false: true;
    }
    
    public void draw(){
		Graphics g=getGraphics();
		Point mouse = MouseInfo.getPointerInfo().getLocation();
		Point offset = getLocationOnScreen();
		mx = mouse.x-offset.x;
		my = mouse.y-offset.y;
		for(int i=0; i<NUM_RECT; i++){
			
			    if(overlaps(rList[i]))
					g.setColor(Color.red);
			    else
					g.setColor(Color.green);
			    
			    g.fillRect((int)rList[i].getX(),(int)rList[i].getY(),(int)rList[i].getWidth(),(int)rList[i].getHeight());
		
			
			// Uncomment if contains() and centre() work
			    if(rList[i].contains(mx,my)){
					int x = (int)rList[i].centre()[0]-2;
					int y = (int)rList[i].centre()[1]-2;
					g.setColor(Color.black);
					g.fillOval(x,y,4,4);
			    }
			
		    // Uncomment if union() works
		    g.setColor(Color.blue);
		    Rect rectU = rList[2].union(rList[3]);
		    g.drawRect((int)rectU.getX(),(int)rectU.getY(),(int)rectU.getWidth(),(int)rectU.getHeight());
		    	
		}
	     
    }
    
    public static void delay (long len){
		try{
		    Thread.sleep (len);
		}
		catch (InterruptedException ex){
		    System.out.println("I hate when my sleep is interrupted");
		}
    }

    public static void main (String[] args){
		ShapeTest shapes = new ShapeTest();
		
		while(true){
		    delay(50);
		    // Uncomment if translate() works
		    // shapes.rList[0].translate(2,2);
	
		    // Uncomment if resize() works
		    // shapes.rList[1].resize(1.1);

		    
		    shapes.draw();
		}
    } 
} 
