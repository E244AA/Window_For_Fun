import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Frame extends JFrame {

    int x = 50;
    int y = 50;
    int dx = 10;
    int dy = 15;

    public Frame(int a, int b, int c, int d) throws InterruptedException {
        x = a; y = b; dx = c; dy = d;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,500);
        setBounds(0,0,500,500);
        setName("Yeah boy");

        for (int i = 0; i < 15; i++) {
            JFrame f = new JFrame();
            f.setSize(500, 500);
            f.setVisible(true);
            setVisible(true);
        }

        setBackground(new Color(50 + r.nextInt(10), 50 + r.nextInt(10), r.nextInt(10)));
        setForeground(new Color(50 + r.nextInt(10), 50 + r.nextInt(10), r.nextInt(10)));

        while(true) {
            if (x >= 2000 || x <= -3000) {
                dx *= -1;
            }
            if (y >= 2000 || y <= 0) {
                dy *= -1;
            }

            x += dx;
            y += dy;

            setLocation(x,y);

            Thread.sleep(10);
        }

    }

    public void paint(Graphics g){

        super.paint(g);
        g.setColor(new Color(10+r.nextInt(50), 10 + r.nextInt(50),  10 + r.nextInt(50)));
        g.fillRect(0,0,500,500);

    }

    static Random r = new Random();;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            int finalI = i;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        new Frame(r.nextInt(100), r.nextInt(100), r.nextInt(30), r.nextInt(30));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            ).start();
        }
    }

}
