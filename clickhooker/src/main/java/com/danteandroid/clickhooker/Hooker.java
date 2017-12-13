package com.danteandroid.clickhooker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yons on 17/12/13.
 */

public class Hooker {
    public static final String VIEW_CLASS_NAME = "android.view.View";
    private static Hooker instance;
    private ListenerManager manager;

    public static Hooker getInstance() {
        if (instance == null) {
            instance = new Hooker();
        }
        return instance;
    }

    public void start(Activity activity, ListenerManager manager) {
        this.manager = manager;

        List<View> views = getAllViews(activity.getWindow().getDecorView());
        for (View view :
                views) {
            hookViewListener(view);
        }
    }

    @SuppressLint("PrivateApi")
    private void hookViewListener(View view) {
        Object listenerInfo = ReflectionObject.toReflection(view, VIEW_CLASS_NAME).method("getListenerInfo");
        ReflectionObject listenerInfoObject = ReflectionObject.toReflection(listenerInfo, VIEW_CLASS_NAME + "$ListenerInfo");
        View.OnClickListener clickListener = listenerInfoObject.field("mOnClickListener");
        View.OnLongClickListener onLongClickListener = listenerInfoObject.field("mOnLongClickListener");
        View.OnFocusChangeListener onFocusChangeListener = listenerInfoObject.field("mOnFocusChangeListener");
        listenerInfoObject.setField("mOnClickListener", new OnClickListenerProxy(clickListener, manager.onClickListener));
        listenerInfoObject.setField("mOnLongClickListener", new OnLongClickListenerProxy(onLongClickListener, manager.onLongClickListener));
        listenerInfoObject.setField("mOnFocusChangeListener", new OnFocusChangeListenerProxy(onFocusChangeListener, manager.onFocusChangeListener));


    }

    private List<View> getAllViews(View view) {
        List<View> views = new ArrayList<>();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                views.add(child);
                views.addAll(getAllViews(child));
            }
        }
        return views;
    }

}
