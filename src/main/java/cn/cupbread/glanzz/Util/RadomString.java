package cn.cupbread.glanzz.Util;

import java.util.Random;

/**
 * @Auther: CupOfBread
 * @Date: 2019/8/23/023 9:51
 * @Remark: 生成随机字符串
 */

public class RadomString {
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
