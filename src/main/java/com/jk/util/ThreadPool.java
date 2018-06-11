package com.jk.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/4/28 0028.
 */
public class ThreadPool {
    static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    public static void executeCachedThreadPool(Runnable runnable) {
        cachedThreadPool.execute(runnable);
    }
}
