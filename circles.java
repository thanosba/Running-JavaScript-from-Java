/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thanosbalas
 */
import java.applet.Applet;
import java.awt.*;
public class circles extends Applet implements Runnable {
private boolean draw_circles=false;
public void init(){
    setBackground(Color.white);
   }
    public void start_drawing(){
        Thread t= new Thread(this);
        t.start();
    }
    public void run(){
        Color[] c= {Color.black, Color.red, Color.green, Color.yellow};
        int i=0;
        int x,y;
        int width=getSize().width;
        int height=getSize().height;
        Graphics g=getGraphics();
        draw_circles=true;
        while (draw_circles){
            x=(int)Math.round(width*Math.random());
            y=(int)Math.round(height*Math.random());
            g.setColor(c[i]);
            i=(i+1)%c.length;
            g.fillOval(x, y, 10, 10);
            pause(0.5);
        }
    }
    public void stop_drawing(){
        draw_circles=false;
    }
    private void pause(double sec){
        try{
            Thread.sleep((int)(Math.round(sec * 1000.0)));
        }
        catch(InterruptedException e){}
    }
}

