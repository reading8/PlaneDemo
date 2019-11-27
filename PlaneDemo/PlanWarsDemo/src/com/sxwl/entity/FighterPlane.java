package com.sxwl.entity;
import com.sxwl.entity.abs.Bullet;
import com.sxwl.entity.abs.Plane;
import com.sxwl.utils.PathUtlis;
import com.sxwl.view.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author reading
 * @time ：2019/11/3 22:31
 * @Description :战斗机
 */
public class FighterPlane extends Plane {
    List<FighterPlaneBullet>  arrayListBullet=new ArrayList<>();
    public int left=1;
    ProductionBullet productionBullet;
    public   ImageIcon imageIcon=new
            ImageIcon(PathUtlis.getPath("images/zdj.png"));
    public   ImageIcon zd=new
            ImageIcon(PathUtlis.getPath("images/zd.png"));
  public  Explode explode=null;
    public FighterPlane(){
        System.out.println(imageIcon);
        x=300;
        y=600;
        width=150;
        height=150;
        productionBullet=new  ProductionBullet();
        productionBullet.start();
    }
    public void drawMe(Graphics g) {
        /**
         * 画出飞机
         */
        g.drawImage(imageIcon.getImage(),
                (int)x,(int)y,width,height,null);
        //画出子弹
        drawBullet(g);
    }
    /**
     * 画出子弹
     */
    public  void drawBullet(Graphics g){
        if(productionBullet!=null){
            for(int i=0;i<arrayListBullet.size();i++){
                FighterPlaneBullet fighterPlaneBullet=  arrayListBullet.get(i);
                if(fighterPlaneBullet.y<=50){
                    arrayListBullet.remove(i);
                }
                ArrayList<EnemyPlane> enemyPlanes = GamePanel.arrayList;
                for(int j=0;j<enemyPlanes.size();j++){
                    if( enemyPlanes.get(j).getRect().intersects(fighterPlaneBullet.getRect())){
                        enemyPlanes.get(j).feft=8;
                        arrayListBullet.remove(i);
                        break;
                    }
                }
                fighterPlaneBullet.drawMe(g);
                fighterPlaneBullet.y-=6;
            }
        }
    }
    @Override
    public Rectangle getRect() {
        return new Rectangle((int)x,(int)y,width,height);
    }
    //子弹类
    class  FighterPlaneBullet extends Bullet {
        public FighterPlaneBullet(){
            width=20;
            height=120;
        }
        @Override
        public void drawMe(Graphics g) {
            g.drawImage(zd.getImage(), (int)x,(int) y, width, height, null);
        }
        @Override
        public Rectangle getRect() {

            return new Rectangle((int)x,(int)y,width,height);
        }
    }
    class  ProductionBullet extends  Thread{
        @Override
        public void run() {
            while (true){
                try {
                    FighterPlaneBullet fighterPlaneBullet=new FighterPlaneBullet();
                    fighterPlaneBullet.x=x+65;
                    fighterPlaneBullet.y=y+45;
                    arrayListBullet.add(fighterPlaneBullet);
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}