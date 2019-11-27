package com.sxwl.entity.abs;

import java.awt.*;

/**
 * @author reading
 * @time ：2019/11/4 15:38
 * @Description 子弹类
 */
public  abstract class Bullet {
    public  double x,y;
    public int width,height;
    public  abstract  void drawMe(Graphics g);
    public   abstract  Rectangle getRect();
}
