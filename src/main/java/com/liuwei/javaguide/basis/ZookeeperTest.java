package com.liuwei.javaguide.basis;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author wee
 * @Description:
 * @date 2020/6/4 17:38
 */
public class ZookeeperTest implements Watcher {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zooKeeper = null;

    private static Stat stat = new Stat();

    public static void main(String[] args) throws InterruptedException, KeeperException, IOException {
        //zookeeper配置数据存放路径
//        String path = "/username";
        //连接zookeeper并且注册一个默认的监听器
        zooKeeper = new ZooKeeper("192.168.100.4:2181,192.168.100.5:2181,192.168.100.6:2181",
                5000,
                new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        System.out.println("========start=======");
                        List<String> children = null;
                        try {
                            children = zooKeeper.getChildren("/", true);
                            children.stream().forEach(v -> System.out.println(v));
                            System.out.println("========end=======");
                        } catch (KeeperException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                });
        //等待zk连接成功的通知
//        countDownLatch.await();
        //获取path目录节点的配置数据，并注册默认的监听器
//        System.out.println(new String(zooKeeper.getData(path, true, stat)));
        TimeUnit.SECONDS.sleep(10);
//        String path = zooKeeper.create("/sanguo", "kongming".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        List<String> children = zooKeeper.getChildren("/", true);
        children.stream().forEach(v -> System.out.println(v));

        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()) {  //zk连接成功通知事件
            Event.EventType type = event.getType();

            if (Event.EventType.None == event.getType() && null == event.getPath()) {
                countDownLatch.countDown();
            } else if (event.getType() == Event.EventType.NodeDataChanged) {  //zk目录节点数据变化通知事件
                try {
                    System.out.println("配置已修改，新值为：" + new String(zooKeeper.getData(event.getPath(), true, stat)));
                } catch (Exception e) {
                }
            } else if (event.getType() == Event.EventType.NodeCreated) {
                try {
                    System.out.println("新创建了一个" + new String(zooKeeper.getData(event.getPath(), true, stat)));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
