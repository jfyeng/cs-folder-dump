/* Swing2.java
 * Mr. McKenzie
 * This example shows:
 * 1. How to add JButtons
 * 2. How to add Components to a Container (JPanel)
 * 3. Border Layout vs Flow Layout 
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
 *
 */


import javax.swing.*;

public class Swing2 extends JFrame{
    JButton load = new JButton("Load");    
    JButton save = new JButton("Save");    
    JButton exit = new JButton("Exit");    

    public Swing2 (){
		super("Fun with buttons");
		
		setSize (80,170);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Try this first
		add(load);
		add(save);
		add(exit);

		JPanel pane = new JPanel();
		pane.add(load);
		pane.add(save);
		pane.add(exit);
		add(pane);
		
		//System.out.println(getLayout());
		setVisible (true);
    }
    
    public static void main(String[] args){
		Swing2 sButtons = new Swing2();
    }
}
