package com.test.zooKeeper;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
	
public class LockTest {
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		// 创建一个与服务器的连接
		ZooKeeper zk = new ZooKeeper("localhost:2181", 10000, new Watcher() {
			// 监控所有被触发的事件
			public void process(WatchedEvent event) {
				System.out.println(event.getPath());
				System.out.println(event.getState());
				System.out.println("已经触发了" + event.getType() + "事件！");
			}
		});
		
		
		zk.getChildren("/abc", new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				// TODO Auto-generated method stub
				System.out.println("已经触发了" + event.getType() + "事件！");
			}
		});
		
		Thread.sleep(1000000000);
		//System.err.println(zk.exists("/abc", null).getPzxid());
		
		//zk.create("/abc", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//		zk.close();
	}
}
