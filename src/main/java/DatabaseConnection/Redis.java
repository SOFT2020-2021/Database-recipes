package DatabaseConnection;

import redis.clients.jedis.Jedis;

public class Redis {
    Jedis jedis = new Jedis("192.168.1.142", 6379);

    public void startup(){
        jedis.auth("password");
    }

    public void stop(){
        jedis.close();
    }

    public String getKey ( String keyval){
        jedis.expire(keyval,600);
        return jedis.get(keyval);
    }

    public void putKey (String key, String value){
        jedis.set(key,value);
        jedis.expire(key,600);
    }
}
