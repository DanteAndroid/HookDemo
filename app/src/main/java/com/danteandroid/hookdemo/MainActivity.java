package com.danteandroid.hookdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.danteandroid.clickhooker.HookListener;
import com.danteandroid.clickhooker.Hooker;
import com.danteandroid.clickhooker.ListenerManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.a)
    Button a;
    @BindView(R.id.b)
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: main");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListenerManager.Builder builder = new ListenerManager.Builder();
        builder.add(new HookListener.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Hook success");
            }
        });
        Hooker.getInstance().start(this, builder.build());
    }
}
