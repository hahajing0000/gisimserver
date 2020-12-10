package com.zy.gisim.utils;

import java.util.Random;

public class NormalUtils {
    /**
     * 生成随机数
     * @param min 最小范围
     * @param max 最大范围
     * @return
     */
    public static int getRandomInt(int min,int max){
        Random rand=new Random();
        int randNumber =rand.nextInt(max - min + 1) + min;
        return randNumber;
    }
}
