// Main.java
// James Feng
// The main file and extends JFrame to make the window

import javax.swing.*;

class Main extends JFrame {
    AstGame game = new AstGame();

    public Main() {
        super("Asteroids");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(game);
        pack();
        setVisible(true);
        setResizable(false);
    }  

    public static void main(String[] args) { new Main(); }
}
