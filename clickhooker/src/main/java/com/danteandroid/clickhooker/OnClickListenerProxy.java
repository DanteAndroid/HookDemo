package com.danteandroid.clickhooker;

import android.util.Log;
import android.view.View;

/**
 * Created by yons on 17/12/13.
 */

public class OnClickListenerProxy implements View.OnClickListener {
    private static final String TAG = "OnClickListenerProxy";
    private View.OnClickListener onClickListener;
    private HookListener.OnClickListener listener;

    public OnClickListenerProxy(View.OnClickListener onClickListener, HookListener.OnClickListener listener) {
        this.onClickListener = onClickListener;
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: proxy");
        if (onClickListener!=null) onClickListener.onClick(v);
        if (listener!=null) listener.onClick(v);
    }
}
