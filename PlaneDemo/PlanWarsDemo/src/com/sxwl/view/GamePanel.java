package com.sxwl.view;

import com.sxwl.entity.*;
import com.sxwl.utils.P;
import com.sxwl.utils.PathUtlis;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author reading
 * @time ：2019/11/3 22:42
 * @Description :游戏界面
 */
public class GamePanel extends JPanel {
    public static  long count=0;
    public boolean flag=true;
    public static ArrayList<EnemyPlane> arrayList=new ArrayList<>();
    public   ImageIcon bz2=new
            ImageIcon(PathUtlis.getPath("images/dd2.png"));
    private FighterPlane fighterPlane;
    ArrayList<Particles> particlesArrayList;
    public GamePanel (FighterPlane fighterPlane, ArrayList<Particles> particlesArrayList){
        this.fighterPlane=fighterPlane;
        this.particlesArrayList=particlesArrayList;
        new updateView().start();
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,P.FRAME_WIDTH,P.FRAME_WIDTH);
        g.setColor(Color.red);
        g.drawString("杀敌数量:"+count,650,50);
        for (int i=0;i<particlesArrayList.size();i++){
            particlesArrayList.get(i).drawMe(g);
        }
        //画出战斗机
        if(fighterPlane!=null&&fighterPlane.left>0){
            fighterPlane.drawMe(g);
        }else{

        }
        //画出敌机
        drawEnemys(g);

    }

    /**
     * 画出敌机
     * @param g
     */
    public void drawEnemys(Graphics g){
        //画出所以敌机
        for(int i=0;i<arrayList.size();i++){
            //判断敌机和战斗机是否发生碰撞
            if(fighterPlane.getRect().intersects(arrayList.get(i).getRect())){
                fighterPlane.left=0;
//                g.drawImage(bz2.getImage(),(int)arrayList.get(i).x,(int)arrayList.get(i).y,150,150,null);
                g.drawImage(bz2.getImage(),(int)fighterPlane.x,(int)fighterPlane.y,150,150,null);

            }
            if(arrayList.get(i).y>=800){
                int c=new Random().nextInt(650)+50;
                arrayList.get(i).x=c;
                arrayList.get(i).y=-150;
            }
            if(arrayList.get(i).feft<=0){
                arrayList.get(i).drawMe(g);
            }else{
                int  x=(int)arrayList.get(i).x,y=(int)arrayList.get(i).y;
              g.drawImage(bz2.getImage(),x,y,150,150,null);
                arrayList.get(i).feft--;
                if(arrayList.get(i).feft==1){
                    int c=new Random().nextInt(650)+50;
                    arrayList.get(i).x=c;
                    arrayList.get(i).y=-150;
                    GamePanel.count++;
                }
           }
        }
    }
    class updateView extends Thread{
        @Override
        public void run() {
           while (flag){
               repaint();

           }
        }
    }

}
