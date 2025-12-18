/* Swing3.java 
 * Mr. McKenzie
 * This example introduces the idea of an Interface through ActionListener.
 * It shows how to set up a button: make, add, addActionListener, actionPerformed 
 * sets a new Layout for the content pane
 * add pack()
 */ 


import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
											// ActionListener is an Interface
											// An interface is a deal between you and Java
											// - Your part of the deal is to add the methods
											// from the interface to your code. 
											// - Java's part is to call your methods at the right time.
public class Swing3 extends JFrame implements ActionListener {
    JButton bStay = new JButton("Stay");
    JButton bGo = new JButton("Go");

    public Swing3() {
		super("Title Bar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bStay.addActionListener(this);
		bGo.addActionListener(this);
		
		FlowLayout flow = new FlowLayout();
		setLayout(flow);
		add(bStay);
		add(bGo);
		
		pack(); // 
		setVisible(true);
    }

	@Override
    public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source == bStay) {
		    setTitle("Stay");
		} else if (source == bGo) {
		    setTitle("Go");
		}
    }

    public static void main(String[] arguments) {
		Swing3 frame = new Swing3();
    }
  
}
