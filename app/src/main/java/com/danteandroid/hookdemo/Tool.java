package com.danteandroid.hookdemo;

import com.genymobile.mirror.annotation.Class;
import com.genymobile.mirror.annotation.Constructor;

/**
 * Created by yons on 17/12/13.
 */
@Class("com.danteandroid.hookdemo.PrivateTool")
public interface Tool {

    @Constructor
    void callConstructor(String name);
    String go(String a,String b);

}
