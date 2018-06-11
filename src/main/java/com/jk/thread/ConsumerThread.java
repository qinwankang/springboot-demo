package com.jk.thread;

/**
 * Created by Administrator on 2018/4/26 0026.
 */
public class ConsumerThread implements Runnable{
    //定义仓库
    Repertory repertory=null;
    //构造方法初始化repertory(仓库)
    public ConsumerThread(Repertory repertory) {
        this.repertory=repertory;
    }
    //实现run()方法,并将当前的线程名称传入.
    @Override
    public  void run() {
        while(true){
            repertory.pop(Thread.currentThread().getName());
        }
    }
}
