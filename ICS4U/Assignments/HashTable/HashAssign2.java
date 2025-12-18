
// James Feng
// HashAssign2.java
// 

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

class HashAssign2 extends JFrame {

    Panel pan = new Panel();

    public HashAssign2() {
        super("HashAssign2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(pan);
        pack();
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) { new HashAssign2(); }
}

class Panel extends JPanel implements KeyListener, ActionListener, MouseListener {

    Image img = new ImageIcon("windsor.png").getImage();
    HashTable<Entry> entries = new HashTable<Entry>();

    // point and mouse positions (point is the center of circle to display emotions)
    private int px = 0, py = 0;
    private int mx = 0, my = 0;
    private boolean display = false;
    private int mb = 0;
    private final int display_radius = 10;

    Timer timer;

    // constructor to setup the window
    public Panel() {
        setPreferredSize(new Dimension(800, 600));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
        addMouseListener(this);

        timer = new Timer(0, this);
        timer.start();

        // read the data
        try {
            File file = new File("creeper.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                
                String[] info = st.split(" ");
                entries.add(new Entry(
                    Integer.parseInt(info[0]),
                    Integer.parseInt(info[1]),
                    Integer.parseInt(info[2]),
                    Integer.parseInt(info[3]),
                    Integer.parseInt(info[4])
                ));

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void update() { }

    @Override
    public void actionPerformed(ActionEvent e) { 
        update();
        repaint();
    }

    @Override
    public void paint(Graphics g) { 
		Point mouse = MouseInfo.getPointerInfo().getLocation();
		Point offset = getLocationOnScreen();
		mx = mouse.x - offset.x;
		my = mouse.y - offset.y;

        if (mb == 1) { px = mx; py = my; display = true; }

        g.drawImage(img, 0, 0, null);
        
        if (display) // display if the user has clicked once or more times
            for (int dy = -display_radius; dy <= display_radius; ++dy) {
                for (int dx = -display_radius; dx <= display_radius; ++dx) {
                    if (Math.hypot(Math.abs(dx), Math.abs(dy)) <= display_radius) {
                        int ax = px + dx, ay = py + dy;
                        LinkedList<Entry> lst = entries.get(new Entry(ax, ay));
                        if (lst.size() > 0) {
                            Entry avg = new Entry(lst, ax, ay); // make a new average entry
                            avg.render(g);
                        }
                    }
                }
            }

        // for (Entry e : entries.toArray()) e.render(g);
    }

    @Override
    public void keyPressed(KeyEvent k) { }
	@Override
	public void keyReleased(KeyEvent k) { }
	@Override
	public void keyTyped(KeyEvent ke) { }
    @Override
    public void mousePressed(MouseEvent e) { mb = 1; }
    @Override
    public void mouseReleased(MouseEvent e) { mb = 0; }
    @Override
    public void mouseClicked(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }

}

class Entry implements Comparable<Entry> {

    private int x, y, LH, HS, EB, r, g, b;

    public Entry(int x, int y, int LH, int HS, int EB) { // construct entry with full data known
        this.x = x; this.y = y;
        this.LH = LH; this.HS = HS; this.EB = EB;
        r = (int)((LH + 100) / 200f * 255f);
        g = (int)((HS + 100) / 200f * 255f);
        b = (int)((EB + 100) / 200f * 255f);
    }
    public Entry(int x, int y) { // construct entry with only x and y data
        this.x = x; this.y = y;
        LH = 0; HS = 0; EB = 0;
    }
    public Entry(LinkedList<Entry> lst, int x, int y) { // construct average entry from a given linkedlist of other entries
        this.x = x; this.y = y;
        LH = 0; HS = 0; EB = 0;

        for (Entry e : lst) {
            LH += e.getLH();
            HS += e.getHS();
            EB += e.getEB();
        }

        LH /= lst.size();
        HS /= lst.size();
        EB /= lst.size();

        r = (int)((LH + 100) / 200f * 255f);
        g = (int)((HS + 100) / 200f * 255f);
        b = (int)((EB + 100) / 200f * 255f);
    }

    public void render(Graphics gg) { // draw on screen
        gg.setColor(new Color(r, g, b));
        gg.fillRect(x, y, 1, 1);
    }


    @Override
    public int compareTo(Entry o) { // sort compare
        int val1 = x * 1000 + y;
        int val2 = o.x * 1000 + o.y;
        return val1 - val2;
    }

    @Override
    public boolean equals(Object o) { // check if 2 entries have the same x and y, we don't care about color
        if (o instanceof Entry) {
            Entry oo = (Entry)o;
            return x == oo.x && y == oo.y;
        }
        return false;
    }

    @Override
    public int hashCode() { return x * 1000 + y; } // unique hash

    @Override
    public String toString() {
        return String.format("%d %d %d %d %d", x, y, LH, HS, EB);
    }

    public int getLH() { return LH; }
    public int getHS() { return HS; }
    public int getEB() { return EB; }
}
