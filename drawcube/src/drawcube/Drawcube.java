
package drawcube;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.util.*;
public class Drawcube extends JFrame {
    
    int width = 150;
    int height = 150;
    int x = 400;
    int y = 400;
    JTextField inputfield = new JTextField();
    JButton inputbutton = new JButton("Enter");
    public Drawcube(){
        
        super ("Drawcube");
        setSize(1300,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        
        
        
        inputfield.setBounds(50, 50, 100, 20);
        inputbutton.setBounds(150,50,100,50);
        add(inputfield);
        add(inputbutton);
        setVisible(true);
        
        inputbutton.addActionListener(new java.awt.event.ActionListener(){
        
        public void actionPerformed(java.awt.event.ActionEvent evt){
        inputbuttonActionPerformed(evt);
        }    
    });
        
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
    
    public void inputbuttonActionPerformed(java.awt.event.ActionEvent evt){
        width = Integer.parseInt(inputfield.getText());
        repaint();
        
    }
    public void paint(Graphics g) {
        super.paint(g);  // fixes the immediate problem.
        
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
        //SEAN VERSION SERIOUSLY GUYS 
        Line2D lin0 = new Line2D.Float(x, y, x-width,y);
        Line2D lin1 = new Line2D.Float(x, y, x, y-height);
        Line2D lin2 = new Line2D.Float(x, y, x+slantwidth, y-slantheight);
        Line2D lin3 = new Line2D.Float(x, y-height, x-width, y-height);
        Line2D lin4 = new Line2D.Float(x - width, y, x-width, y-height);
        Line2D lin5 = new Line2D.Float(x - width, y-height, x-width+slantwidth, y-height-slantheight);
        Line2D lin6 = new Line2D.Float(x, y-height, x+slantwidth, y-height-slantheight);
        Line2D lin7 = new Line2D.Float(x+slantwidth, y-slantheight, x+slantwidth,y-height-slantheight);
        Line2D lin8 = new Line2D.Float(x-width+slantwidth, y-height-slantheight,x+slantwidth,y-height-slantheight);
        g2.setColor(Color.red);
        g2.draw(lin0);
        g2.draw(lin1);
        g2.draw(lin2);
        g2.draw(lin3);
        g2.draw(lin4);
        g2.draw(lin5);
        g2.draw(lin6);
        g2.draw(lin7);
        g2.draw(lin8);
    }
    
    public static void main(String[] args) {
        Drawcube frame = new Drawcube(); 
    }
    
}