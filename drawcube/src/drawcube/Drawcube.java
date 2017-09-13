//Dawson was working on ths one in his branch!



//neat
package drawcube;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.util.*;
public class Drawcube extends JFrame {
    
    public Drawcube(){
        
        super ("Drawcube");
        setSize(1300,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }
    public double howlong(int x1, int x2, int y1, int y2){
    double length;
    length = Math.sqrt(Math.abs(((x2 - x1)^2) + ((y2 - y1)^2)));
    return length;
    }
    public double howlong(int width, int height){
    double length;
    length = Math.sqrt(Math.pow(width,2) + (Math.pow(height,2)));
    
    return length;
    }
    
    
    public void paint(Graphics g) {
        super.paint(g);  // fixes the immediate problem.
        int x = 400;
        int y = 400;
        int width = 150;
        int height = 150;
        double angle = Math.PI/4;
        //double slantlength = howlong(width, height);
        double slantlength = width;
        System.out.println(slantlength);
        int slantwidth = (int)(slantlength * Math.cos(angle));
        int slantheight = (int)(slantlength * Math.sin(angle));
        
        System.out.println(slantwidth);
        System.out.println(slantheight);
        Graphics2D g2 = (Graphics2D) g;
        //This one is the sean version actually
        Line2D lin0 = new Line2D.Float(x, y, x-width,y);
        Line2D lin1 = new Line2D.Float(x, y, x, y-height);
        Line2D lin2 = new Line2D.Float(x, y, x+slantwidth, y-slantheight);
        Line2D lin3 = new Line2D.Float(x, y-height, x-width, y-height);
        g2.draw(lin0);
        g2.draw(lin1);
        g2.draw(lin2);
        g2.draw(lin3);
    }
    
    public static void main(String[] args) {
        Drawcube frame = new Drawcube(); 
    }
    
}