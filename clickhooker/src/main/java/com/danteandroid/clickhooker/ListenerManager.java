package com.danteandroid.clickhooker;

/**
 * Created by yons on 17/12/13.
 */

public class ListenerManager {
    public HookListener.OnFocusChangeListener onFocusChangeListener;
    public HookListener.OnClickListener onClickListener;
    public HookListener.OnLongClickListener onLongClickListener;

    public static class Builder{
        private final ListenerManager manager;
        public Builder() {
            manager = new ListenerManager();
        }

        public Builder add(HookListener.OnClickListener listener){
            manager.onClickListener = listener;
            return this;
        }
        public Builder add(HookListener.OnLongClickListener listener){
            manager.onLongClickListener =listener;
            return this;
        }
        public Builder add(HookListener.OnFocusChangeListener listener){
            manager.onFocusChangeListener = listener;
            return this;
        }
        public ListenerManager build(){
            return manager;
        }

    }
}
