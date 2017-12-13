package com.danteandroid.clickhooker;

import android.view.View;

/**
 * Created by yons on 17/12/13.
 */


public class HookListener {

    public interface OnClickListener {
        void onClick(View view);
    }

    public interface OnLongClickListener {
        void onLongClick(View view);
    }

    public interface OnFocusChangeListener {
        void onFocusChange(View view, boolean hasFocus);
    }

}
