package org.seckill.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * 配置spring与junit4整合，junit启动时加载springIOC容器
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
	
	//注入Dao实现依赖
	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testReduceNumber() throws Exception {
		long id = 1000;
		Date killTime = new Date();
		int updateCount = seckillDao.reduceNumber(id, killTime);
		System.out.println("updateCount : " + updateCount);
	}
	
	@Test
	public void testQueryById() throws Exception{
		long id = 1000;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println("seckill : "+seckill);
	}
	
	@Test
	//java没有保持形参的记录
	public void testQueryAll() throws Exception{
		List<Seckill> list = seckillDao.queryAll(0, 100);
		for (Seckill seckill : list) {
			System.out.println("seckill : " + seckill);
		}
	}
}
