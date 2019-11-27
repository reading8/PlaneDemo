package com.sxwl.entity.abs;

import java.awt.*;

/**
 * @author reading
 * @time ：2019/11/3 22:23
 * @Description :飞机类
 */
public abstract class Plane {
    /**
     * 飞机的x,y坐标
     */
    public   double x,y;
    /**
     * 飞机的宽度和高度
     */
    public int width,height;
    /**
     *
     * @param g  画出飞机
     */
    public abstract  void drawMe(Graphics g);
    /**
     *
     *
     * @return  返回一个矩形用于检测飞机是否发生碰撞
     */
    public  abstract   Rectangle getRect();

}
