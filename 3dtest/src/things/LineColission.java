/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package things;

/**
 *
 * @author G
 */
public class LineColission {
    boolean collides = false;
    double xcol;
    double ycol;
    Line l1, l2;
    public LineColission(Line _l1, Line _l2){
        l1 = _l1;
        l2 = _l2;
        if (l1.vertical == true){
            if (l2.vertical != true){
                //l1 vert
                xcol = l1.x1;
                if (xcol > l2.x1 && xcol < l2.x2){
                    ycol = (l2.slope * xcol) + l2.b;
                    if (ycol > l1.y2 && ycol < l1.y1){
                        collides = true;
                    }
                }
            }
        }else if (l2.vertical == true){
            //l2 vert
            
        }else{
            if (l1.slope != l2.slope){
                //no vert
                xcol = (l2.b - l1.b)/(l1.slope - l2.slope);
                ycol = (l1.slope * xcol) + l1.b;
                if (xcol > l1.x1 && xcol < l1.x2){
                    if (xcol > l2.x1 && xcol < l2.x2){
                        collides = true;
                    }
                }
            }
        }
    }
}
