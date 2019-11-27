package com.sxwl.entity;

import java.awt.*;
import java.util.Random;

/**
 * @author reading
 * @time ：2019/11/5 9:56
 * @Description 粒子效果
 */
/**
 * @author reading
 * @version 创建时间：2019年10月31日 下午9:34:41
 * @Description 子弹类
 */
public class Particles  {
    double x,y;
    int width=2,height=2;
    public double degree=Math.random()*Math.PI*2;
    public Particles(Double x, Double y) {
        this.x = x;
        this.y = y;
        this.width=4;
        this.height=4;

    }


    public Rectangle getPoint() {
        return new Rectangle((int)this.x,(int)this.y,this.width,this.height);
    }


    public void drawMe(Graphics g) {
        // TODO Auto-generated method stub
        g.setColor(new Color(getRgb(), getRgb(), getRgb()));
        g.fillOval((int)x,(int) y, this.width, this.height);
        if(x<=0||x>=800) {
            degree=Math.PI-degree;
        }
        if(y>=800||y<=0) {
            degree=-degree;
        }
        x+=4*Math.cos(degree);
        y+=4*Math.sin(degree);

    }
    public static int getRgb()
    {
        return new Random().nextInt(256);
    }
}
