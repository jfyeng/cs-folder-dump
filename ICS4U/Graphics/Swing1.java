/* Swing1.java
 * Mr. McKenzie
 *
 * Graphics in Java
 * 1. AWT - Abstract Windowing Template
 *        - Basic GUI Toolkit
 * 2. Swing
 *        - A "lightweight" framework. Written in Java.
 *        - A little better.
 *        - "J" for Swing Button -> JButton
 * 3. JavaFX
 *        - newest framework. Not fully embraced by the community.
 * 4. libGDX
 *        - packages up some free Java graphics extensions and makes them easier to use.
 *
 * This example shows the basic setup of a JFrame
 * https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html
 * Should show
 * 1. Class hierarchy, J for Swing, Frame vs Window
 * 2. static & non-static in same class
 * 3. super - as a call to super-class constructor
 * 4. setSize, setVisible, setDefaultCloseOperation and what happens without them.
 *
 */

import javax.swing.*;  // Lightweight - Built in Java

/* extends, means "inherits from"
 * Our class "is-a" JFrame. This means, everything JFrame has, we have.
 * All fields and methods.
 */
class Swing1 extends JFrame{
    public Swing1 (){
		super("Swing example 1"); // call the constructor in the superclass
		setSize(800, 600);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args){
		Swing1 eg1 = new Swing1();	
		Swing1 eg2 = new Swing1();	
    }
}
