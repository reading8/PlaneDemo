package com.sxwl.run;

import com.sxwl.controller.PlaneController;
import com.sxwl.entity.EnemyPlane;
import com.sxwl.entity.FighterPlane;
import com.sxwl.entity.Particles;
import com.sxwl.entity.ProductionEnemyPlane;
import com.sxwl.view.GamePanel;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class PlaneStart {
    public static void main(String[] args) {
        FighterPlane fighterPlane=new FighterPlane();//创建一个战斗机
        EnemyPlane  enemyPlane1=new EnemyPlane();//创建敌机
        ProductionEnemyPlane  productionEnemyPlane=new ProductionEnemyPlane();
        Thread thread=new Thread(productionEnemyPlane);
        thread.start();
        Random random=new Random();
        ArrayList<Particles> bullets=new ArrayList<Particles>();
        for(int i=0;i<50;i++) {
            double x=random.nextInt(800)+1;
            double y=random.nextInt(800)+1;
            Particles bullet=new Particles(x,y);
            bullets.add(bullet);
        }
        GamePanel gamePanel=new GamePanel(fighterPlane,bullets);//创建一个游戏面板
        PlaneController  controller=new PlaneController(fighterPlane);
        PlaneStart  planeStart=new PlaneStart();
        planeStart.Launch(gamePanel,controller);
    }
    public void Launch(GamePanel gamePanel,PlaneController  controller){
        JFrame frmae=new JFrame();
        frmae.add(gamePanel);
        frmae.setTitle("飞机大战");
        frmae.setSize(800,800);
        frmae.setResizable(false);
        frmae.setLocationRelativeTo(null);
        frmae.setVisible(true);
        frmae.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmae.addKeyListener(controller);
    }
}
