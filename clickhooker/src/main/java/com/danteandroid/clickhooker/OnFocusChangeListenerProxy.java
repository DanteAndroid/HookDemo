package com.danteandroid.clickhooker;

import android.util.Log;
import android.view.View;

/**
 * Created by yons on 17/12/13.
 */

public class OnFocusChangeListenerProxy implements View.OnFocusChangeListener {
    private static final String TAG = "OnFocusChangeListenerProxy";
    private View.OnFocusChangeListener onFocusChangeListener;
    private HookListener.OnFocusChangeListener listener;

    public OnFocusChangeListenerProxy(View.OnFocusChangeListener onFocusChangeListener, HookListener.OnFocusChangeListener listener) {
        this.onFocusChangeListener = onFocusChangeListener;
        this.listener = listener;
    }

    @Override
    public void onFocusChange(View v, boolean f) {
        Log.d(TAG, "onLongClick: proxy");
        if (onFocusChangeListener != null) onFocusChangeListener.onFocusChange(v, f);
        if (listener != null) listener.onFocusChange(v, f);
    }
}
