package com.gaoxianglong.lifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private MyChronometer mChronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChronometer = findViewById(R.id.chronometer);
        getLifecycle().addObserver(mChronometer); // 给lifecycle添加观察者
    }
}

/**
 * 这样写就会在生命周期回调方法中堆积很多代码
 */
//public class MainActivity extends AppCompatActivity {
//
//    private static final String TAG = "MainActivity";
//    private long elapsedTime;
//    private Chronometer mChronometer;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mChronometer = findViewById(R.id.chronometer);
//        mChronometer.setBase(SystemClock.elapsedRealtime()); // 给计时控件设置初始值，也可以不设置，通过SystemClock.elapsedRealtime()获取到系统启动到现在的毫秒
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        elapsedTime = SystemClock.elapsedRealtime() - mChronometer.getBase();
//        Log.d(TAG, String.format("onPause: SystemClock->%s\ngetBase->%s",SystemClock.elapsedRealtime(),mChronometer.getBase()));
//        mChronometer.stop(); // 这个只能停止刷新，不能停止毫秒增加
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mChronometer.setBase(SystemClock.elapsedRealtime() - elapsedTime);
//        Log.d(TAG, String.format("onResume: SystemClock->%s\nelapsed->%s",SystemClock.elapsedRealtime(),elapsedTime));
//        mChronometer.start(); // 启动刷新时间
//    }
//}
