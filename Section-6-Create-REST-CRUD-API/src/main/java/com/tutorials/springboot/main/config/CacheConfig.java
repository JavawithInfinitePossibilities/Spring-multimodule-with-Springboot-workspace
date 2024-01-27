/**
 * 
 */
package com.tutorials.springboot.main.config;

import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;

/**
 * @author Lenovo
 *
 */
@Configuration
public class CacheConfig {

	public Config cacheConfig() {
		return new Config().setInstanceName("hazal-instance")
				.addMapConfig(new MapConfig().setName("product-cache").setTimeToLiveSeconds(3000));

	}
}
