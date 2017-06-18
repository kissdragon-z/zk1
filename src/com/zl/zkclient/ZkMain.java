package com.zl.zkclient;

import org.apache.zookeeper.ZooKeeper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zml on 2017/6/18.
 */
public class ZkMain {

    private String name = null;

    private static Map<String, String> keymap = new HashMap<String, String>();


    public static void main(String[] args) {


        try {

            ZooKeeper client = ZKCleintAbs.create();

            System.out.println("zkclient has started :" + client);

            Thread.sleep(1000000000l);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
