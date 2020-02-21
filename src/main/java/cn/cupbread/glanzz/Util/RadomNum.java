package cn.cupbread.glanzz.Util;

/**
 * @Auther: CupOfBread
 * @Date: 2019/9/17/017 18:19
 * @Remark:  生成随机数字
 */

public class RadomNum {
    public static String getRandomNum(int codeLen) {
        java.util.Random randomCode = new java.util.Random();
        String strCode = "";
        while (codeLen > 0) {
            int charCode = randomCode.nextInt(9);
            strCode += charCode;
            codeLen--;
        }
        return strCode;
    }
}
