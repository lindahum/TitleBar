package com.milinda.titlebar;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by humeiling on 2017/9/11.
 */

public class Utils {

    public static float getDenity(Context context){
        DisplayMetrics dm =context.getResources().getDisplayMetrics();
        return dm.density;
    }
}
