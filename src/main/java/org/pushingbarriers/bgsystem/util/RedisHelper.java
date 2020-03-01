package org.pushingbarriers.bgsystem.util;

import redis.clients.jedis.Jedis;

/**
 * Created by BaoDong on 2018/4/5.
 */
public class RedisHelper {
    public Jedis initializeJedis(){
        Jedis jedis = new Jedis("localhost",6379);
        //jedis.auth("123456");
        jedis.auth("WKOmKO09w0ko2ok3IJIYuiwdn9s9d");
        return jedis;
    }

    public void closeJedis(Jedis jedis){
        jedis.close();
        System.out.println("close jedis successfully!");
    }
}
