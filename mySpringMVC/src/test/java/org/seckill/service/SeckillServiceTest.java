package org.seckill.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring/spring-dao.xml",
	"classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void testGetSeckillList(){
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list={}",list);
	}
	
	@Test
	public void testGetSeckillById(){
		long seckillId = 1000;
		Seckill seckill = seckillService.getSeckillById(seckillId);
		logger.info("{seckill={}",seckill);
		
	}
	
	@Test
	public void testSeckillLogic(){
		long seckillId = 1001;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if(exposer.isExposed())	{
			logger.info("exposer={}",exposer);
			long userPhone = 1267832932L;
			String md5 = exposer.getMd5();
			try {
				SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
				logger.info("seckillExecution={}",seckillExecution);
			} catch(RepeatKillException e){
				logger.error(e.getMessage());
			} catch (SeckillCloseException e) {
				logger.error(e.getMessage());
			} 
		}else{
			//秒杀未开启
			logger.warn("exposer={}",exposer);
		}
	}
	
	@Test
	public void testExecuteSeckillByProcedure(){
		long seckillId = 1003;
		long userPhone = 15827139852L;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if(exposer.isExposed()){
			String md5 = exposer.getMd5();
			SeckillExecution seckillExecution = seckillService.executeSeckillByProcedure(seckillId, userPhone, md5);
			logger.info(seckillExecution.getStateInfo());
		}
	}

}
