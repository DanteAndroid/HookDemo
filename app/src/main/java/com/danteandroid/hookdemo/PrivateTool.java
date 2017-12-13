package com.danteandroid.hookdemo;

import android.util.Log;

/**
 * Created by yons on 17/12/13.
 */

public class PrivateTool {
    private static final String TAG = "PrivateTool";
    private String name;

    public PrivateTool(String name) {
        this.name = name;
    }

    private String go(String paramA, String paramB) {
        Log.d(TAG, "go: " + paramA + ", " + paramB);
        return paramA + paramB;
    }


}
