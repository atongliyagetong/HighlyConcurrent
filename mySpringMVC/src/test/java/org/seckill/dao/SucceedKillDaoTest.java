package org.seckill.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SucceedKill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SucceedKillDaoTest {
	
	@Resource()
	private SucceedKillDao succeedKillDao;
	
	@Test
	public void testInsertSucceedKill() throws Exception {
		long id = 1001;
		long userPhone = 1211232142;
		int insertCount = succeedKillDao.insertSucceedKill(id, userPhone);
		System.out.println("insertCount : "+insertCount);
		
	}
	@Test
	public void testQueryByIdWithSeckill() throws Exception {
		long id = 1000;
		long userPhone = 1211232142;
		SucceedKill succeedKill = succeedKillDao.queryByIdWithSeckill(id, userPhone);
		System.out.println("succeedKill : " + succeedKill);
		System.out.println("seckill : " + succeedKill.getSeckill());
	}
}
