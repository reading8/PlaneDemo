package com.sxwl.utils;

import java.net.URL;

/**
 * @author reading
 * @time ：2019/11/3 22:43
 * @Description : 获取类路径下的文件夹
 */
public class PathUtlis {
    public static URL getPath(String name){
        URL resource = PathUtlis.class.getClassLoader().getResource(name);
        return resource;
    }
}
