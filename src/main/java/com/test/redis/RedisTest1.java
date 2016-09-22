package com.test.redis;

import java.util.Iterator;

import redis.clients.jedis.Jedis;

public class RedisTest1 {
	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("localhost");
		System.out.println("Connection to server sucessfully");
		// 查看服务是否运行
		System.out.println("Server is running: " + jedis.ping());

		System.out.println(jedis.setnx("abc", "aa"));

		Iterator<String> iterator = jedis.keys("*").iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
