package com.example.dontworry.p2p.utils;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import com.example.dontworry.p2p.MyApplcattion.AppManager;

/**
 * Created by Don't worry on 2017/6/21.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private CrashHandler() {
    }

    private static CrashHandler crashHandler = new CrashHandler();

    public static CrashHandler getInstance() {
        return crashHandler;
    }

    private Context context;

    //告诉系统 崩溃异常我来处理
    public void init(Context context) {
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.context = context;
    }


    @Override
    public void uncaughtException(Thread t, final Throwable e) {

        new Thread() {
            public void run() {
                Looper.prepare();
                Toast.makeText(context, "崩溃了哦~", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }

        }.start();
        collection(e);
        //销毁当前所有的Acticity
        AppManager.getInstance().removeAll();
        //杀死当前进程
        android.os.Process.killProcess(android.os.Process.myPid());
        //退出虚拟机  参数：除了0都是非正常退出
        System.exit(0);
    }

    //该方法将异常传给服务器
    private void collection(Throwable e) {
        String board = Build.BOARD;
        //发送给服务器
    }
}
