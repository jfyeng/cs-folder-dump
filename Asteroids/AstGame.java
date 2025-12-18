
// AstGame.java
// James Feng
// The class that does all the game logic and stores all the entities, and game classes in it.

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AstGame extends JPanel implements KeyListener, ActionListener, MouseListener {

    private final int WIDTH = 1000, HEIGHT = 800;
    private final boolean ENABLE_SOUNDS = true, SHOW_FPS_COUNTER = true;
    private final int BOUND_MARGIN = 80; // how much distance outside the bounds until entities will wrap.

    private Timer timer;
    private Player player;

    // private Pen pen = new Pen(this, "data/orbitron.ttf", 100);
    // private Pen pen = new Pen(this, "data/orbitron.ttf", 50);
    private Pen pen = new Pen(this, "data/orbitron.ttf", 25);

    // input fields
    private boolean[] keys = new boolean[KeyEvent.KEY_LAST+1];
    private ArrayList<Integer> mouse_click = new ArrayList<Integer>();
    private ArrayList<Integer> key_press = new ArrayList<Integer>();
    private int mx = 0, my = 0;

    // arraylists holding entities so they can be rendered and updated
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private ArrayList<SpaceRock> spacerocks = new ArrayList<SpaceRock>();
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    private double dt; // delta time in seconds
    private long last_tick = System.nanoTime(); // last tick used to determine delta time

    // buttons used for navigation
    private Button play_button = new Button(this, WIDTH/2, HEIGHT/2 + 20, "PLAY", 40);
    private Button highscore_button = new Button(this, WIDTH/2, HEIGHT/2 + 60 + 20, "HIGHSCORES", 40);
    private Button help_button = new Button(this, WIDTH/2, HEIGHT/2 + 120 + 20, "HELP", 40);
    private Button retry_button = new Button(this, WIDTH/2, HEIGHT/2 - 30, "RETRY", 40);
    private Button back_button = new Button(this, WIDTH/2, HEIGHT/2, "BACK", 40);

    private int mode = 1; // 0 = gaming, 1 = menu, 2 = help, 3 = high score, 4 = death screen
    private int rock_spawn_count = 4; // determines how many rocks are spawned per round
    private long score = 0, score_max = 100; // keep track of score, score max is used to determine how much score asteroids give
    private long last_enemy_spawn = 0; // the last time an enemy was spawned

    ArrayList<Long> highscores = new ArrayList<Long>();

    // constructor to setup the window
    public AstGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
        addMouseListener(this);

        keys = new boolean[525];
        timer = new Timer(0, this);
        timer.start();

        player = new Player(this);
        readScores();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        update();
        // reset click and key events
        key_press.clear();
        mouse_click.clear();
        repaint();
    }

    // update entities and properties every frame
    public void update() {
        dt = (double)(System.nanoTime() - last_tick) / 1e9; // delta time in seconds
        last_tick = System.nanoTime();

        // update spacerocks and enemies, remove them if they are dead
        // this is out here because it doesn't really matter what mode it is, they should be updated if the arraylists are not empty
        for (SpaceRock sr : new ArrayList<SpaceRock>(spacerocks)) { if (sr.update(dt)) { spacerocks.remove(sr); } }
        for (Enemy e : new ArrayList<Enemy>(enemies)) { if (e.update(dt)) { enemies.remove(e); }}

        if (mode == 0) { // GAMEPLAY
            for (Bullet b : new ArrayList<Bullet>(bullets)) { if (b.update(dt)) bullets.remove(b); }

            if (spacerocks.size() == 0) {
                rock_spawn_count += 1;
                playDing();
                generateSpaceRocks(rock_spawn_count, true);
            }
            
            // spawn enemies after a cooldown and if there isn't too many already
            if (System.currentTimeMillis() - last_enemy_spawn > 20000 / max((double)(rock_spawn_count-5)/4, 1) && enemies.size() < 3) {
                last_enemy_spawn = System.currentTimeMillis();
                enemies.add(new Enemy(this));
            }

            if (player.update(dt)) {
                addScore();
                mode = 4;
            }
        } else if (mode == 1) { // MENU
            if (spacerocks.size() == 0) {
                generateSpaceRocks(20, false);
            }

            // drawing the buttons
            if (play_button.update()) { reset(); mode = 0; playSelect(); }
            if (highscore_button.update()) { mode = 3; playSelect(); }
            if (help_button.update()) { mode = 2; playSelect(); }

        } else if (mode == 2) { // HELP
            if (back_button.update()) { mode = 1; playSelect(); }
        } else if (mode == 3) { // HIGHSCORE
            if (back_button.update()) { mode = 1; playSelect(); }
        } else if (mode == 4) { // GAME OVER SCREEN
            player.resetMotion();
            player.update(dt);

            // still want some things to be moving even on the death screen
            for (Enemy e : new ArrayList<Enemy>(enemies)) { if (e.update(dt)) enemies.remove(e); }
            for (Bullet b : new ArrayList<Bullet>(bullets)) { if (b.update(dt)) bullets.remove(b); }
            if (retry_button.update()) { mode = 0; reset(); playSelect(); }
            if (back_button.update()) { mode = 1; reset(); playSelect(); }
        }
    }


    @Override
    public void paint(Graphics g) {
        // calculate mouse position on the window
		Point mouse = MouseInfo.getPointerInfo().getLocation();
		Point offset = getLocationOnScreen();
		mx = mouse.x - offset.x;
		my = mouse.y - offset.y;

        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, getWidth(), getHeight());

        if (mode == 0) { // GAMEPLAY
            for (SpaceRock r : spacerocks) r.render(g);
            for (Enemy e : enemies) e.render(g);
            for (Bullet b : bullets) b.render(g);
            player.render(g);

            g.setColor(Color.WHITE);
            pen.write(g, 10, HEIGHT - 15, 30, Long.toString(score));
            if (SHOW_FPS_COUNTER) pen.write(g, 10, 30, 25, "FPS: " + Integer.toString((int)getFPS()));

        } else if (mode == 1) { // MENU
            for (SpaceRock r : spacerocks) r.render(g);
            g.setColor(Color.WHITE);
            pen.write(g, WIDTH/2, HEIGHT/2-100, 100, "center", "ASTEROIDS");
            play_button.render(g); highscore_button.render(g); help_button.render(g);

        } else if (mode == 2) { // HELP
            back_button.move(80, HEIGHT - 40);
            back_button.render(g);
            g.setColor(Color.WHITE);
            pen.paragraph(g, 50, 50, 700, 10, 25, "Welcome to my Asteroids clone! nl Use arrow keys LEFT and RIGHT to turn, nl UP to accelerate, nl SPACE to fire, nl and hold SHIFT while turning to turn slower. nl nl Shoot the asteroids and enemy spaceships to gain score! You have a health bar on the top and you can see your current score at the bottom left.");

        } else if (mode == 3) { // SCORES
            back_button.move(80, HEIGHT - 40);
            back_button.render(g);

            // displaying the highscores using the pen class I made
            g.setColor(Color.WHITE);
            int x = 100, y = 100;
            for (int i = 0; i < highscores.size(); ++i) {
                pen.write(g, x, y, 40, (i+1) + ".   " + highscores.get(i).toString());
                y += 50;
            }
        } else if (mode == 4) { // GAME OVER SCREEN
            for (SpaceRock r : spacerocks) r.render(g);
            for (Enemy e : enemies) e.render(g);
            for (Bullet b : bullets) b.render(g);
            player.render(g);

            g.setColor(Color.WHITE);
            pen.write(g, 10, HEIGHT - 15, 25, Long.toString(score));
            retry_button.render(g);
            back_button.move(WIDTH/2, HEIGHT/2 + 30);
            back_button.render(g);
        }
    }

    // reset properties so a new game can be started
    private void reset() {
        spacerocks.clear();
        bullets.clear();
        player.revive();
        enemies.clear();
        rock_spawn_count = 4;
        key_press.clear();
        mouse_click.clear();
        for (int i = 0; i < keys.length; ++i) { keys[i] = false; }
        score = 0;
        last_enemy_spawn = System.currentTimeMillis();
    }

    // generate some rocks!
    private void generateSpaceRocks(int amount, boolean range) {
        Random rand = new Random();
        for (int i = 0; i < amount; ++i){
            SpaceRock sr = new SpaceRock(
                this,
                rand.nextDouble(WIDTH),
                rand.nextDouble(HEIGHT),
                rand.nextDouble(40)+40
            );

            if (range) {
                if (sr.dist(player) <= (sr.getRadius() + player.getRadius())*1.5) {
                    --i; continue;
                }
            }

            spacerocks.add(sr);
        }
    }

    private double frame_count = 0;
    private double last_fps_tick = System.nanoTime();
    private double fps;
    // for the FPS counter, displays current frames per second
    public double getFPS() {
        ++frame_count;
        double fdt = (System.nanoTime() - last_fps_tick)/1e9; // change in time in seconds
        if (fdt >= .5) {
            // fps = frames divided by seconds passed
            fps = (int)((double)frame_count / fdt);
            last_fps_tick = System.nanoTime();
            frame_count = 0;
        }

        return fps;
    }

    // generate a random position outside of the visible area
    public Point randomOuterPos(int offset) {
        Random rand = new Random();

        int x, y;
        if (rand.nextInt(10) % 2 == 0) {
            y = rand.nextInt(HEIGHT);
            if (rand.nextInt(10) % 2 == 0) x = -offset;
            else x = WIDTH + offset;
        } else {
            x = rand.nextInt(WIDTH);
            if (rand.nextInt(10) % 2 == 0) y = -offset;
            else y = HEIGHT + offset;

        }

        return new Point(x, y);
    }

    public void increaseScore(int x) { // increase score
        if (mode == 0) {
            score += x;
        }
    }

    public void addScore() { // add new score to the highscores arraylist, then only keep the top 10
        highscores.add(score);
        Collections.sort(highscores, Collections.reverseOrder());
        ArrayList<Long> temp = new ArrayList<>();
        for (int i = 0; i < min(highscores.size(), 10); ++i) {
            temp.add(highscores.get(i));
        }
        highscores = new ArrayList<Long>(temp);
        saveScores();
    }

    // save scores to file
    public void saveScores() {
        try {
            FileWriter fw = new FileWriter("data/highscore.txt");
            String str_scores = "";
            for (long i : highscores) {
                str_scores += i + " ";
            }
            fw.write(str_scores);
            fw.close();
        } catch (Exception e) {
            System.out.println("Unable to save scores.");
        }
    }

    // read scores from the file
    public void readScores() {
        try {
            highscores.clear();
            FileReader fr = new FileReader("data/highscore.txt");
            Scanner scner = new Scanner(fr);
            String[] data = scner.nextLine().split(" ");
            for (String i : data) {
                highscores.add(Long.parseLong(i));
            }
            scner.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Unable to read scores.");
            highscores.clear();
            highscores.add((long)0);
        }
    }

    // sound effects
    // a new instance of the class is made so that the sound effects can stack over each other and not cut off.
    public void playExplosion() {
        if (!ENABLE_SOUNDS) return;
        new SoundEffect("data/sfx/explosion.wav").play();
    }
    public void playShoot() {
        if (!ENABLE_SOUNDS) return; 
        new SoundEffect("data/sfx/shoot.wav").play();
    }
    public void playSelect() {
        if (!ENABLE_SOUNDS) return;
        new SoundEffect("data/sfx/select.wav").play();
    }
    public void playDing() {
        if (!ENABLE_SOUNDS) return;
        new SoundEffect("data/sfx/ding.wav").play();
    }
    public void playHurt() {
        if (!ENABLE_SOUNDS) return;
        new SoundEffect("data/sfx/hurt.wav").play();
    }

	@Override
	public void keyPressed(KeyEvent k){
        if (keys[k.getKeyCode()] == false) {
            key_press.add(k.getKeyCode());
        }
        keys[k.getKeyCode()] = true;
    }
	@Override
	public void keyReleased(KeyEvent k){
        if (keys[k.getKeyCode()] == true) {
            key_press.add(-k.getKeyCode());
        }
        keys[k.getKeyCode()] = false;
    }
	@Override
	public void keyTyped(KeyEvent ke){ }

    @Override
    public void mousePressed(MouseEvent e) { mouse_click.add(e.getButton()); }
    @Override
    public void mouseReleased(MouseEvent e) { mouse_click.add(-e.getButton()); }
    @Override
    public void mouseClicked(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }

    // provide public access for private fields
    public int[] WH() { return new int[]{ WIDTH, HEIGHT }; }
    public boolean[] getKeys() { return keys; }
    public ArrayList<Bullet> getBullets() { return bullets; }
    public ArrayList<SpaceRock> getSpaceRocks() { return spacerocks; }
    public Player getPlayer() { return player; }
    public ArrayList<Integer> getKeyPress() { return key_press; }
    public ArrayList<Integer> getMouseClick() { return mouse_click; }
    public int[] getMousePos() { return new int[]{ mx, my}; }
    public long getScoreOffset() { return score_max; }
    public int getRockSpawnCount() { return rock_spawn_count; }
    public ArrayList<Enemy> getEnemies() { return enemies; }
    public int getMode() { return mode; }
    public int getBoundMargin() { return BOUND_MARGIN; }

}