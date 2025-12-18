
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class CheckersTest extends JFrame {

    public CheckersBoard board = new CheckersBoard();

    public CheckersTest() {
        super("Checkers");
        this.setSize(500, 530);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }


    public void paint(Graphics g) {
        Color[] boxCol = new Color[]{Color.lightGray, new Color(113, 56, 0)};
        Color[] pieceCol = new Color[]{Color.black, Color.red};
        g.setColor(new Color(214, 145, 75));
        g.fillRect(0, 0, 500, 530);

        for(int x = 50; x <= 400; x += 50) {
            for(int y = 50; y <= 400; y += 50) {
                int gx = x / 50 - 1;
                int gy = y / 50 - 1;
                int boxNum = (gx + gy) % 2;
                g.setColor(boxCol[boxNum]);
                g.fillRect(x, y + 30, 50, 50);
                int pieceNum = this.board.get(gx, gy);
                if (pieceNum > 0) {
                    g.setColor(pieceCol[pieceNum - 1]);
                    g.fillOval(x + 5, y + 35, 40, 40);
                }
            }
        }

    }

	public static void delay(long len) {
        try {
            Thread.sleep(len);
        } catch (InterruptedException var3) {
            System.out.println(var3);
        }

    }

    public static void main(String[] args) {
        CheckersTest frame = new CheckersTest();

        delay(1000L);
        frame.board.move(2, 2, 1, 3);
        frame.repaint();
        delay(1000L);
        frame.board.move(1, 3, 2, 4);
        frame.repaint();
        delay(1000L);
        frame.board.move(3, 5, 1, 3);
        frame.repaint();
        delay(1000L);
        frame.board.move(2, 6, 3, 5);
        frame.repaint();
        delay(1000L);
        frame.board.move(3, 5, 4, 4);
        frame.repaint();
        delay(1000L);
        frame.board.move(4, 4, 3, 3);
        frame.repaint();
        delay(1000L);
        frame.board.move(4, 6, 3, 5);
        frame.repaint();
        delay(1000L);
        frame.board.move(1, 1, 2, 2);
        frame.repaint();
        delay(1000L);
        frame.board.move(2, 2, 2, 6);
        frame.repaint();
        delay(1000L);
        frame.board.move(3, 1, 2, 2);
        frame.repaint();
        delay(1000L);
        frame.board.move(5, 1, 4, 2);
        frame.repaint();
        delay(1000L);
        frame.board.move(3, 7, 1, 5);
        frame.repaint();
        delay(1000L);
        frame.board.move(1, 5, 2, 6);
        frame.repaint();
        delay(1000L);
        frame.board.move(2, 6, 0, 4);
        frame.repaint();
        delay(1000L);
        frame.board.move(2, 6, 2, 6);
        frame.repaint();
        frame.board.display();
    }
}