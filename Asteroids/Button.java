
// Button.java
// James Feng
// class that contains useful fields and methods to make a button that detects when itself is clicked and reports the event back with a true or false 

import java.awt.*;

class Button {

    private AstGame game;
    private int x, y, width, height, xx, yy;
    private boolean hover = false, border;
    private String label;
    private Pen pen;

    public Button(AstGame g, int x, int y, String label,  int font_size) {
        game = g;
        this.x = x;
        this.y = y;
        this.label = label;

        pen = new Pen(this.game, "data/orbitron.ttf", font_size);
        this.width = pen.getTextSize(label, font_size)[0];
        this.height = pen.getTextSize(label, font_size)[1];
    }

    public boolean update() {
        int mx = game.getMousePos()[0], my = game.getMousePos()[1];
        xx = x - width/2;
        yy = y - height/2;
        // check if the mouse is on this button
        if (xx <= mx && mx <= xx + width && yy <= my && my <= yy+height) {
            hover = true;
        } else hover = false;

        if (hover) {
            for (int a : game.getMouseClick()) {
                if (a == -1) {
                    return true; // mouse 1 was let go on this button, return that this button was clicked
                }
            }
        }

        return false;
    }

    // draw on the screen
    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g.setColor(!hover? Color.WHITE : Color.YELLOW);
        g2.setStroke(new BasicStroke(3));

        if (border) g.drawRect(xx, yy, width, height);
        pen.write(g, x, y, 40, "center", label);
    }
    
    public void move(int x, int y) { this.x = x; this.y = y; }
}