package com.danteandroid.clickhooker;

import android.view.View;

/**
 * Created by yons on 17/12/13.
 */

public class OnLongClickListenerProxy implements View.OnLongClickListener {
    private static final String TAG = "OnLongClickListenerProxy";
    private View.OnLongClickListener onLongClickListener;
    private HookListener.OnLongClickListener listener;

    public OnLongClickListenerProxy(View.OnLongClickListener onLongClickListener, HookListener.OnLongClickListener listener) {
        this.onLongClickListener = onLongClickListener;
        this.listener = listener;
    }


    @Override
    public boolean onLongClick(View v) {
        if (onLongClickListener != null) onLongClickListener.onLongClick(v);
        if (listener != null) listener.onLongClick(v);
        return false;
    }
}
