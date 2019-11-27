package com.sxwl.entity;

import com.sxwl.entity.abs.Bullet;
import com.sxwl.entity.abs.Plane;
import com.sxwl.utils.PathUtlis;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author reading
 * @time ：2019/11/3 22:31
 * @Description 敌机
 */
public class EnemyPlane extends Plane {
    public int feft=0;
    public   ImageIcon dj=new
            ImageIcon(PathUtlis.getPath("images/dj.png"));
    public   ImageIcon zd=new
            ImageIcon(PathUtlis.getPath("images/djzd.png"));
    public EnemyPlane(){
        int c=new  Random().nextInt(650)+50;
        x=c;
        y=-150;
        width=120;
        height=120;
    }
    public void drawMe(Graphics g) {
//        drawBullet(g);
        /**
         * 画出飞机
         */
        g.drawImage(dj.getImage(),
                (int)x,(int)y,width,height,null);
        y+=1;

    }
    @Override
    public Rectangle getRect() {

        return new Rectangle((int)x,(int)y,width,height);
    }
    //子弹类
    class  FighterPlaneBullet extends Bullet {
        public FighterPlaneBullet(){
            width=13;
            height=60;
        }
        @Override
        public void drawMe(Graphics g) {
            g.drawImage(zd.getImage(), (int)x+53,(int) y, width, height, null);
        }
        @Override
        public Rectangle getRect() {
            return new Rectangle((int)x,(int)y,width,height);
        }
    }
    class  ProductionBullet extends  Thread{
        List<FighterPlaneBullet>  arrayListBullet=new ArrayList<>();
        @Override
        public void run() {
            while (true){
                try {
                    FighterPlaneBullet fighterPlaneBullet=new FighterPlaneBullet();
                    fighterPlaneBullet.x=x;
                    fighterPlaneBullet.y=y;
                    arrayListBullet.add(fighterPlaneBullet);
                    sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
