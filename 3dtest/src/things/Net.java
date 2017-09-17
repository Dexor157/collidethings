/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package things;
import java.awt.*;
/**
 *
 * @author G
 */
public class Net {
    Point[] points;
    Line[] lines;
    public Net(Point... _points){
        points = _points;
        lines = new Line[points.length];
        for (int x = 0;x<lines.length;x++){
            if (x == 0){
                lines[x] = new Line(points[x], points[lines.length - 1]);
            }else{
                lines[x] = new Line(points[x], points[x-1]);
            }
        }
    }
}
