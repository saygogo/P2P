package com.example.dontworry.p2p.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Don't worry on 2017/6/21.
 */

public class ThradManager {
    private ThradManager() {
    }

    private ThradManager thradManager = new ThradManager();

    private ThradManager getInstance() {
        return thradManager;
    }

    //创建缓存线程池
    private ExecutorService service = Executors.newCachedThreadPool();

    private ExecutorService getThread() {
        return service;
    }
}
