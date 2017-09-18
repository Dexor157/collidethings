package pkg3dtest;
import java.awt.*;
import things.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Game extends JPanel implements Runnable { 
    boolean
        bool_right = false, //If right arrow is pressed (can be overwritten by other keys)
        bool_left = false, //If left arrow is pressed (can be overwritten by other keys)
        bool_right2 = false, //If right arrow is pressed (cannot be overwritten by other keys)
        bool_left2 = false; //If left arrow is pressed (cannot be overwritten by other keys)
    ;
    int gamewidth = 400;
    int gameheight = (int)(gamewidth * .75);
    int direc = 90;
    int view = 66;
    Point player = new Point(50,25);
    Point[] edgepoints = {
        new Point(0,0), 
        new Point(0,100),
        new Point(100,100),
        new Point(100,0)
    };
    Point[] pillarpoints = {
        new Point(20,20), 
        new Point(20,40),
        new Point(40,40),
        new Point(40,20)
    };
    Net pillar = new Net(pillarpoints);
    Net edge = new Net(edgepoints);
    Map m1 = new Map(edge, pillar);
    Line[] rays = new Line[m1.totalpoints()];
    String 
        str_appath = (System.getProperty("user.dir"))
    ;
    Thread 
        timer
    ;
    public Game() {
        timer=new Thread(this); //initializes the thread and puts Class1 into it
        timer.start(); //begins the thread
    }
    public void paintComponent(Graphics gc){
        setOpaque(false); //wipes everything on the frame
        super.paintComponent(gc); //creates the class for painting indavidual objects in the frame
        gc.setColor(Color.WHITE);
        gc.fillRect(0, 0, 405, 405);
        gc.setColor(Color.BLACK);
        gc.fillRect(0, 0, 405, 5);
        gc.fillRect(0, 0, 5, 405);
        gc.fillRect(0, 395, 405, 5);
        gc.fillRect(395, 0, 5, 405);
    }
    public void keyPressed(KeyEvent evt){
        switch(evt.getKeyCode()){
            case KeyEvent.VK_LEFT:
                bool_left2 = true;
                bool_left = true;
                bool_right = false;
            break;
            case KeyEvent.VK_RIGHT:
                bool_right = true;
                bool_right2 = true;
                bool_left = false;
            break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
            break;
        }
    }
    public void keyReleased(KeyEvent evt){
        switch(evt.getKeyCode()){
            case KeyEvent.VK_LEFT:
                bool_left = false;
                bool_left2 = false;
                if (bool_right2 == true){
                    bool_right = true;
                }
            break;
            case KeyEvent.VK_RIGHT:
                bool_right = false;
                bool_right2 = false;
                if (bool_left2 == true){
                    bool_left = true;
                }
            break;
        }
    }
    public void Rays(){
        for (int x = 0;x<m1.nets.length;x++){
            for (int y = 0;y<m1.nets[x].length();y++){
                rays[x+y] = new Line(m1.nets[x].points[y],player);
                sysout("rays (" + x +", "+ y + ")",rays[x+y].toString());
            }
        }
    }
    public void sysout(Object... in){
        for (int x = 0;x<in.length;x++){
            System.out.println(in[x]);
        }
    }
    public void run() {
        
        while(true){
            Rays();
            repaint();
            try{
                Thread.sleep(33); //delays loop by 1/30th of a second to save cpu
            }catch(InterruptedException ex){
            } 
        }
    }
}