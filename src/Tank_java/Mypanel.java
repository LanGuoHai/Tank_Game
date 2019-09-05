package Tank_java;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class Mypanel extends JPanel implements KeyListener,Runnable {
    Hero hero = null;
    Image im1, im2, im3;
    Vector<Bomb> bombs = new Vector<Bomb>();
    Vector<Enemy> ets = new Vector<Enemy>();
    Vector<Shot> ss = new Vector<Shot>();

    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.BLACK);
        drawTank(hero.x, hero.y, hero.direct, hero.color, g);
        //ets.get(0).setEts(ets);
        for (int i = 0; i < ets.size(); i++) {   // ets.get(i).setEts(ets);
            drawTank(ets.get(i).x, ets.get(i).y, ets.get(i).direct, ets.get(i).color, g);
            for (int j = 0; j < ets.get(i).ss.size(); j++) {
                Shot t = ets.get(i).ss.get(j);
                g.setColor(Color.yellow);
                g.fill3DRect(t.x, t.y, 4, 4, true);
            }
        }
        for (int i = 0; i < ss.size(); i++) {
            g.setColor(Color.RED);
            g.fill3DRect(ss.get(i).x, ss.get(i).y, 4, 4, true);
        }
        for (int i = 0; i < bombs.size(); i++) {
            Bomb b = bombs.get(i);
            if (b.lifetime > 6) {
                g.drawImage(im1, b.x - 15, b.y - 15, 30, 30, this);
            } else if (b.lifetime > 3) {
                g.drawImage(im2, b.x - 15, b.y - 15, 30, 30, this);
            } else {
                g.drawImage(im3, b.x - 15, b.y - 15, 30, 30, this);
            }
            b.lifedown();
            if (b.lifetime == 0) {
                bombs.remove(i);
                //System.out.println("bom __death");
            }
        }
    }

    public void drawTank(int tx, int ty, int direction, Color c, Graphics g) {
        {
            if (direction == 1) {
                g.setColor(c);
                g.fill3DRect(tx - 10, ty - 15, 5, 30, true);
                g.fill3DRect(tx + 5, ty - 15, 5, 30, true);
                g.fill3DRect(tx - 5, ty - 10, 10, 20, true);
                if (c == Color.BLUE)
                    g.setColor(Color.GREEN);
                if (c == Color.yellow)
                    g.setColor(Color.ORANGE);
                g.fillOval(tx - 5, ty - 5, 10, 10);
                g.drawLine(tx, ty, tx, ty - 15);
            } else if (direction == 2) {
                g.setColor(c);
                g.fill3DRect(tx - 10, ty - 15, 5, 30, true);
                g.fill3DRect(tx + 5, ty - 15, 5, 30, true);
                g.fill3DRect(tx - 5, ty - 10, 10, 20, true);
                if (c == Color.BLUE)
                    g.setColor(Color.GREEN);
                if (c == Color.yellow)
                    g.setColor(Color.ORANGE);
                g.fillOval(tx - 5, ty - 5, 10, 10);
                g.drawLine(tx, ty, tx, ty + 15);
            } else if (direction == 3) {
                g.setColor(c);
                g.fill3DRect(tx - 15, ty - 10, 30, 5, true);
                g.fill3DRect(tx - 15, ty + 5, 30, 5, true);
                g.fill3DRect(tx - 10, ty - 5, 20, 10, true);
                if (c == Color.BLUE)
                    g.setColor(Color.GREEN);
                if (c == Color.yellow)
                    g.setColor(Color.ORANGE);
                g.fillOval(tx - 5, ty - 5, 10, 10);
                g.drawLine(tx, ty, tx - 15, ty);
            } else {
                g.setColor(c);
                g.fill3DRect(tx - 15, ty - 10, 30, 5, true);
                g.fill3DRect(tx - 15, ty + 5, 30, 5, true);
                g.fill3DRect(tx - 10, ty - 5, 20, 10, true);
                if (c == Color.BLUE)
                    g.setColor(Color.GREEN);
                if (c == Color.yellow)
                    g.setColor(Color.ORANGE);
                g.fillOval(tx - 5, ty - 5, 10, 10);
                g.drawLine(tx, ty, tx + 15, ty);

            }
        }
    }

    public Mypanel() {
        try {
            im1 = ImageIO.read(new File("src/Tank_Img/bomb_1.gif"));
            im2 = ImageIO.read(new File("src/Tank_Img/bomb_2.gif"));
            im3 = ImageIO.read(new File("src/Tank_Img/bomb_3.gif"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        hero = new Hero(250, 250, 1);
        int i = 1;
        for (; i <= 4; i++) {
            Enemy enemy = new Enemy(i * 100, 100, 2);
            ets.addElement(enemy);
            Thread t1 = new Thread(enemy);
            t1.start();
        }
        //增加敌方坦克的模板
        for (int j = 1; j <= 4; j++) {
            Enemy enemy = new Enemy(j * 100, 200, 2);
            ets.add(enemy);
            Thread t2 = new Thread(enemy);
            t2.start();
        }
        for (int j = 1; j <= 4; j++) {
            Enemy enemy = new Enemy(j * 100, 300, 2);
            ets.add(enemy);
            Thread t2 = new Thread(enemy);
            t2.start();
        }
        for (int j = 1; j <= 4; j++) {
            Enemy enemy = new Enemy(j * 100, 350, 2);
            ets.add(enemy);
            Thread t2 = new Thread(enemy);
            t2.start();
        }
        for (int j = 1; j <= 4; j++) {
            Enemy enemy = new Enemy(j * 100, 400, 2);
            ets.add(enemy);
            Thread t2 = new Thread(enemy);
            t2.start();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            //System.out.println("up");
            if (hero.y <= 15) {
            } else {
                hero.y -= hero.speed;
                hero.direct = 1;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (hero.y >= 420) {
            } else {
                //System.out.println("down");
                //	System.out.println(hero.y);
                hero.y += hero.speed;
                hero.direct = 2;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //System.out.println("left");
            if (hero.x <= 15) {
            } else {
                hero.x -= hero.speed;
                hero.direct = 3;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            // System.out.println("rigth");
            //System.out.println(hero.x);
            if (hero.x >= 465) {
            } else {
                hero.x += hero.speed;
                hero.direct = 4;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            //System.out.println("shot");
            if (ss.size() < 6) {
                //System.out.println("shoting "+ss.size());
                hero.shotothers(hero.x, hero.y, hero.direct);
                ss.add(hero.shot);
            }
        }
    }

    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        //	int temp=0;
        //	int temp1=0;
        while (true) {
            ets.get(0).setEts(ets);
            for (int i = 0; i < ss.size(); i++)
                if (ss.get(i).x <= 0 || ss.get(i).x >= 500 || ss.get(i).y <= 0 || ss.get(i).y >= 500)
                    ss.remove(i);
            for (int i = 0; i < ets.size(); i++) {
                for (int j = 0; j < ets.get(i).ss.size(); j++) {
                    if (ets.get(i).ss.get(j).x <= 0 || ets.get(i).ss.get(j).x >= 500 ||
                            ets.get(i).ss.get(j).y <= 0 || ets.get(i).ss.get(j).y >= 500) {
                        ets.get(i).ss.remove(j);
                        break;
                    }
                }
            }
            for (int i = 0; i < ss.size(); i++) {
                for (int j = 0; j < ets.size(); j++) {
                    if (hitTank(ss.get(i), ets.get(j))) {
                        ets.remove(j);
                        ss.remove(i);
                        //System.out.println(i);
                        //	temp=1;
                        break;
                    }
                }
			   /*	if(temp==1){
					temp=0;
					break;
				}*/
            }
            for (int i = 0; i < ets.size(); i++) {
                for (int j = 0; j < ets.get(i).ss.size(); j++) {
                    if (hitTank(ets.get(i).ss.get(j), hero)) {
                        System.out.println("Game over !!");
                        ets.get(i).ss.remove(j);
                        Bomb bomb = new Bomb(hero.x, hero.y);
                        bombs.add(bomb);
                        //游戏结束
                        // ets.get(i).ss.remove(j);
                        //  return ;
                    }
                }
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            repaint();
        }

    }

    public boolean hitTank(Shot shot, Tank tank) {
		/*if(((shot.x==tank.x+15)&&(shot.y<=tank.y+15)&&(shot.y>=tank.y-15))||((shot.x==tank.x-15)&&(shot.y<=tank.y+15&&shot.y>=tank.y-15))
			||((shot.y==tank.y+15)&&(shot.x<=tank.x+15&&shot.x>=tank.x-15))||((shot.y==tank.y-15)&&(shot.x<=tank.x+15&&shot.x>=tank.x-15)))
		*/
        if (shot.x <= tank.x + 15 && shot.x >= tank.x - 15 && shot.y <= tank.y + 15 && shot.y >= tank.y - 15) {

            Bomb bomb = new Bomb(tank.x, tank.y);
            bombs.add(bomb);
            //System.out.println("add ___bomb");
            return true;
        }
        return false;
    }
}
