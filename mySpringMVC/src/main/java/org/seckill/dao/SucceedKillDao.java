package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SucceedKill;

public interface SucceedKillDao {
	
	/*
	 * 插入购买明细,可过滤重复
	 * @param seckillId 秒杀商品Id
	 * @param userPhone 用户手机号
	 * @return 插入的行数
	 */
	int insertSucceedKill(@Param("seckillId")long seckillId , @Param("userPhone")long userPhone);
	
	/*
	 * 根据id查询SucceedKill并携带秒杀产品对象Seckill
	 * @param seckillId 
	 * @return SucceedKill
	 */
	SucceedKill queryByIdWithSeckill(@Param("seckillId")long seckillId , @Param("userPhone")long userPhone);
}
