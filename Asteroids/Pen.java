
// Pen.java
// James Feng
// A class that stores its own font and provides useful utility to draw text without too much fiddling in other classes

import java.awt.*;

import java.io.File;
import java.io.IOException;

class Pen {

    private AstGame game;
    private Font font;
    private FontMetrics fm;
    private String font_path;

    public Pen(AstGame g, String font_path, int size) {
        this.game = g;
        this.font_path = font_path;
        this.font = loadFont(font_path, size);
        this.fm = game.getFontMetrics(font);
    }

    // generate a new font with a new size
    public void setSize(int size) {
        this.font = loadFont(font_path, size);
        this.fm = game.getFontMetrics(font);
    }

    // load font from a path
	public Font loadFont(String path, int size){
		Font font = null;
    	try {
			File fntFile = new File(path);
    		font = Font.createFont(Font.TRUETYPE_FONT, fntFile).deriveFont((float)size);
    	} catch (IOException ex) {
    		System.out.println(ex);	
    	} catch (FontFormatException ex) {
    		System.out.println(ex);	
    	}
		return font;
	}

    // draw text on the screen
    public void write(Graphics g, int x, int y, int size, String text) {
        setSize(size);
        g.setFont(font);
        g.drawString(text, x, y);
    }
    // overloaded with an extra string align to help center texts
    public void write(Graphics g, int x, int y, int size, String align, String text) {
        setSize(size);
        if (align == "center") {
            g.setFont(font);
            g.drawString(text, x - fm.stringWidth(text)/2, y - fm.getHeight()/2 + fm.getAscent());
        } else { 
            g.setFont(font);
            g.drawString(text, x, y);
        }
    }

    // draw an entire paragraph
    public void paragraph(Graphics g, int x, int y, int width, int line_gap, int size, String text) {
        String[] words = text.split(" ");

        setSize(size);
        g.setFont(font);

        String line = "";
        int y2 = 0;

        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals("nl")) {
                g.drawString(line, x, y + y2);
                y2 += fm.getHeight() + line_gap;
                line = "";
                continue;
            }
            line += words[i];
            if (i + 1 < words.length) {
                if (fm.stringWidth(line + words[i+1]) > width) {
                    if (line.length() == 0) return; // we can't fit anything on this width! panic!
                    g.drawString(line, x, y + y2);
                    y2 += fm.getHeight() + line_gap;
                    line = "";
                } else line += " ";
            }
        }
        g.drawString(line, x, y + y2);
    }

    // return this pen's current font 
    public Font getFont(int size) { setSize(size); return font; }
    public int[] getTextSize(String text, int size) {
        setSize(size);
        return new int[]{ fm.stringWidth(text), fm.getHeight() };
    }
}