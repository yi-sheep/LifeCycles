package com.gaoxianglong.lifecycles;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * LifecycleObserver能观察Activity的生命周期,并完成一些自定义逻辑
 */
public class MyChronometer extends Chronometer implements LifecycleObserver {
    private static long elapsedTime; // 如果想让切换到横屏时数据不丢失，可以使用static,但是不推荐这样使用。

    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void pause() {
        elapsedTime = SystemClock.elapsedRealtime() - getBase();
        stop(); // 可以不写
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void resume() {
        setBase(SystemClock.elapsedRealtime() - elapsedTime); // 设置起始时间戳
        start();
    }
}
