
package things;
import java.awt.*;
/**
 *
 * @author G
 */
public class Line {
    public boolean vertical;
    public double x1,x2;
    public double y1,y2;
    public double rise,run;
    public double slope, b;
    Point p1,p2;
    Point temp;
    public Line(Point _p1, Point _p2){
        p1 = _p1;
        p2 = _p2;
        if (p1.x == p2.x){
            vertical = true;
            if (p1.y > p2.y){
               temp = p1;
               p1 = p2;
               p2 = temp;
            }
            y1 = p1.y;
            y2 = p2.y;
        }else if (p2.y == p1.y){
            vertical = false;
            if (p1.x > p2.x){
               temp = p1;
               p1 = p2;
               p2 = temp;
            }
            x2 = p2.x;
            x1 = p1.x;
        }else{
            vertical = false;
            rise = p2.y-p1.y;
            run = p2.x-p1.x;
            slope = rise/run;
            b = p1.y - (slope * p1.x);
            if (p1.x > p2.x){
               temp = p1;
               p1 = p2;
               p2 = temp;
            }
            x1 = p1.x;
            x2 = p2.x;
        }
    }
    public void sysout(Object... in){
        for (int x = 0;x<in.length;x++){
            System.out.println(in[x]);
        }
    }
    public String toString(){
        
        return p1.toString() + p2.toString() + slope + " " + b;
        /*String x = "";
        if (vertical == true){
            x = "Vertical\ny1 " + y1 + "\ny2 " + y2;
        }else if (slope != 0){
            x = "Slanted\nSlope " + slope + "\nb " + b + "\nx1 " + x1 + "\nx2 " + x2;
        }else{
            x = "Horizontal\nx1 " + x1 + "\nx2 " + x2;
        }
        return x;*/
    }
}
