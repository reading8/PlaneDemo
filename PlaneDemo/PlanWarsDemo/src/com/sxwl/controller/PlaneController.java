package com.sxwl.controller;

import com.sxwl.entity.FighterPlane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author reading
 * @time ：2019/11/4 14:47
 * @Description   战斗机控制类
 */
public class PlaneController extends KeyAdapter {
    FighterPlane fighterPlane;
    public PlaneController(FighterPlane fighterPlane){
        this.fighterPlane=fighterPlane;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        direction(e.getKeyCode());
    }
    public void direction(int code){
        switch (code){
            case 37:
                if(fighterPlane.x<=40){
                    return;
                }
                fighterPlane.x-=8;
                break;
            case 38:
                if(fighterPlane.y<=150){
                    return;
                }
                fighterPlane.y-=8;
                break;
            case 39:
                if(fighterPlane.x>=650){
                    return;
                }
                fighterPlane.x+=8;
                break;
            case 40:
                if(fighterPlane.y>600){
                    return;
                }
                fighterPlane.y+=8;
                break;
        }
    }
}
