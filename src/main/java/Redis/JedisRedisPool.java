package Redis;


import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
/**
 * 
 * 作者: tangjie
 * 
 * 日期: 2017
 * 
 * 版权说明：北京神州泰岳软件股份有限公司
 * 
 * redis cluster初始化
 */
public class JedisRedisPool {
	public static JedisCluster jedisCluster;

	public static synchronized void initRedis() {
		JedisPoolConfig config = new JedisPoolConfig();
		String ipAndPorts = System.getProperty("com.ultrapower.redis.hostPort");
//		String[] arrs=ipAndPorts.split(":");
		/** 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。 */
		config.setMaxTotal(500);
		/**控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。 */
		config.setMaxIdle(100);
		/** 等待可用连接的最大时间，单位毫秒，默认值为-1，*/
		config.setMaxWaitMillis(2000);
		/** 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的； */
		config.setTestOnBorrow(true);
	    Set<HostAndPort> nodes = new HashSet<HostAndPort>(); 
	    nodes.add(new HostAndPort("192.168.95.64", 7000));  
//	  	nodes.add(new HostAndPort(arrs[0], Integer.parseInt(arrs[1])));
	    jedisCluster = new JedisCluster(nodes, config);
	}
	
	public static synchronized JedisCluster getClient() {
	        try {  
	            if (jedisCluster == null) {
	            	initRedis();
	            }
	        } catch (Exception e) {  
	        	e.printStackTrace();
	        }
	        return jedisCluster;
	}

	public static void main(String[] args) {
//		long time = System.currentTimeMillis();
//		JedisClusterPipeline jcp = JedisClusterPipeline.pipelined(getClient());
//		for (int i = 0; i < 1000000; i++) {
//			jcp.del("a" + i);
//		}
//		System.out.println(System.currentTimeMillis()-time);
//		Set<String>  classTitles=getClient().smembers("DIMCLASS");
//		System.out.println(classTitles);
	}
}
