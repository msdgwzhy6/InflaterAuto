package com.yan.inflaterautotest;

import android.app.Application;
import android.content.Context;
import android.support.design.widget.AppBarLayout;

import com.yan.inflaterauto.AutoBaseOn;
import com.yan.inflaterauto.InflaterAuto;

public class InflaterAutoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /*
         * 以下可以写在任何地方，只有在设置布局之前
         */
        InflaterAuto.init(new InflaterAuto.Builder()
                .width(720)
                .height(1280)
                .baseOnDirection(AutoBaseOn.Both)// 宽度根据宽度比例缩放，长度根据长度比例缩放
                .addException(AppBarLayout.class)//add do not need adjust view type
                .build()
        );
    }

    /**
     * 如果你使用了LayoutInflater.from(getApplicationContext())或者LayoutInflater.from(getApplication())
     * 就需要一下操作，如果没有，一下方法可以不必重写
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(InflaterAuto.wrap(base));
    }
}
