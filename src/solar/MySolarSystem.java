package solar;

import java.awt.Graphics;
import java.awt.Image;
import myutil.Constant;
import myutil.GameUtil;
import myutil.MyFrame;
public class MySolarSystem extends MyFrame {
Image bg = GameUtil.getImage("images/bg.png");
Star sun = new Star("images/s.png",Constant.WIDTH/2,Constant.HEIGHT/2);
Planet earth = new Planet("images/e.png",sun,200,150,0.05);
Planet moon = new Planet("images/m.png",earth,50,40,0.15,true);
public void paint(Graphics g){
    g.drawImage(bg,0,0,null);
    sun.draw(g);
    earth.draw(g);
    moon.draw(g);
    
}

public static void main(String[] args){
    new MySolarSystem().launchFrame();
}
}