
package things;
import java.awt.*;
/**
 *
 * @author G
 */
public class Line {
    boolean horizontal;
    int x1,x2;
    int y1,y2;
    int slope, b;
    Point temp;
    public Line(Point p1, Point p2){
        if (p1.x == p2.x){
            if (p1.y > p2.y){
               temp = p1;
               p1 = p2;
               p2 = temp;
            }
        }else if (p2.y == p1.y){
            if (p1.x > p2.x){
               temp = p1;
               p1 = p2;
               p2 = temp;
            }
        }else{
            slope = (p2.y - p1.y)/(p2.x - p1.x);
            b = p1.y - (slope * p1.x);
            if (p1.x > p2.x){
               temp = p1;
               p1 = p2;
               p2 = temp;
            }
        }
    }
}
