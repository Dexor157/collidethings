/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguesser;

/**
 *
 * @author SeanDunlop0502
 */
public class NumberGuesser {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
	System.out.println("Hey There");
        System.out.println("It works");
        System.out.println("Pull?");
        Class1 help = new Class1("Hey");
        sysout(help.hello.toString());
    }
    public static void sysout(Object... in){
        for (int x=0;x<in.length;x++){
            System.out.println(in[x]);
        }
    }
}
