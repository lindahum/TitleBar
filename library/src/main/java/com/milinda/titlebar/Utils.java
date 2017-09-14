package com.milinda.titlebar;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 作者:Milinda 邮件:Milinda.Hu@gmail.com
 * 创建时间:2017/9/11
 * 描述:工具类
 */

public final class Utils {

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     *获取手机的屏幕像素密度==>即每英寸多少像素
     * @param context
     * @return
     */
    public static float getDenity(Context context){
        DisplayMetrics dm =context.getResources().getDisplayMetrics();
        return dm.density;
    }

    /**
     * px转sp
     * @param pxValue px值
     * @return sp值
     */
    public static int px2sp(Context context,final float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 判断字符串是否为null或全为空格
     *
     * @param s 待校验字符串
     * @return {@code true}: null或全空格<br> {@code false}: 不为null且不全空格
     */
    public static boolean isTrimEmpty(final String s) {
        return (s == null || s.trim().length() == 0);
    }
}
