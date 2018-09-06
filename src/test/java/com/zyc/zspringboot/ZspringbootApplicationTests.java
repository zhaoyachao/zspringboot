package com.zyc.zspringboot;

import com.zyc.zspringboot.entity.Role;
import com.zyc.zspringboot.service.RoleService;
import net.sf.ehcache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Clock;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ZspringbootApplication.class})
@ActiveProfiles(profiles = {"pro"})
public class ZspringbootApplicationTests {

	@Autowired
	RedisTemplate redisTemplate;
	@Autowired
	RoleService roleService;
	@Autowired
	EhCacheCacheManager ehCacheCacheManager;

	@Test
	public void contextLoads() {

		CacheManager ec = CacheManager.getCacheManager("ec");
		ec.clearAll();

		Role r=roleService.getRole("1");
		System.out.println(r.getId()+"===="+r.getRoleName());
		Role r1=roleService.getRole("1");
		System.out.println(r1.getId()+"===="+r1.getRoleName());

		ec.clearAll();

	}


}