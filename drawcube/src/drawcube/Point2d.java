/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawcube;

/**
 *
 * @author G
 */
public class Point2d extends Drawcube{
    int x;
    int y;
    int scalex;
    int scaley;
    int offsetx;
    int offsety;
    public Point2d(Point p){
    
        x = scalex*p.x+offsetx;
        y = scaley*p.z+offsety;
    }
}
