package com.sxwl.entity;
import com.sxwl.entity.abs.Plane;
import com.sxwl.utils.PathUtlis;
import javax.swing.*;
import java.awt.*;
/**
 * @author reading
 * @time ：2019/11/4 21:54
 * @Description :类描述
 */
public class Explode  {
   public static Image[] image=new Image[8];
    static {
        for (int i = 1; i < 9; i++) {
            image[i-1]=new ImageIcon(PathUtlis.getPath("images/dd"+i+".png")).getImage();
        }

    }
    public void drawMe(Graphics g,int x,int y) {
        for (int i = 0; i <8 ; i++) {
            g.drawImage(image[i],x,y,300,300,null);

        }

    }
}
