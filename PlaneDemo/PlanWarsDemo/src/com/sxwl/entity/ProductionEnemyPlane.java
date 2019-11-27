package com.sxwl.entity;

import com.sxwl.view.GamePanel;

import java.util.ArrayList;

/**
 * @author reading
 * @time ：2019/11/4 17:42
 * @Description :类描述
 */
public class ProductionEnemyPlane implements  Runnable {
    @Override
    public void run() {
       for(int i=0;i<8;i++){
           GamePanel.arrayList.add( new EnemyPlane());
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
