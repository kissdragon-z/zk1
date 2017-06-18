package com.zl.zkclient;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/**
 * zk客户端
 * Created by zml on 2017/6/18.
 */
public class ZKCleintAbs {


    private static final String connectStr = "127.0.0.1:2181";
    private static final int timeout = 1000;

    private static ZooKeeper client = null;

    static {

    }


    public static ZooKeeper create() throws Exception {

//        ZooKeeper zooKeeper = new ZooKeeper();

        //此处的Watcher 只能监听create和delete
        client = new ZooKeeper(connectStr, timeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {


                System.out.println("zkclient watcher has opened: current watchevent is " + watchedEvent);

                try {


                    List<String> list = client.getChildren("/", true);
                    int length = list.size();
                    for (int i = 0; i < length; i++) {
                        System.out.println("data " + i + " is :" + list.get(i));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
        return client;

    }


    //监听zk的变化
    public static void testListener() {

        client.register(new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });


    }


}
