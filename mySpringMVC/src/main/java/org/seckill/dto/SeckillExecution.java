package org.seckill.dto;

import org.seckill.entity.SucceedKill;
import org.seckill.enums.SeckillStatEnum;

/*
 * 封装秒杀执行后的结果
 */
public class SeckillExecution {

	private long seckillId;
	
	//秒杀执行结果状态
	private int state;
	
	//状态标识	
	private String stateInfo;
	
	//秒杀成功对象
	private SucceedKill succeedKill;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	
	
	public SucceedKill getSucceedKill() {
		return succeedKill;
	}


	public void setSucceedKill(SucceedKill succeedKill) {
		this.succeedKill = succeedKill;
	}

	public SeckillExecution(long seckillId, SeckillStatEnum seckillStatEnum, SucceedKill succeedKill) {
		super();
		this.seckillId = seckillId;
		this.state = seckillStatEnum.getState();
		this.stateInfo = seckillStatEnum.getStateInfo();
		this.succeedKill = succeedKill;
	}

	public SeckillExecution(long seckillId, SeckillStatEnum seckillStatEnum) {
		super();
		this.seckillId = seckillId;
		this.state = seckillStatEnum.getState();
		this.stateInfo = seckillStatEnum.getStateInfo();
	}

	@Override
	public String toString() {
		return "SeckillExecution [seckillId=" + seckillId + ", state=" + state + ", stateInfo=" + stateInfo
				+ ", succeedKill=" + succeedKill + "]";
	}
	
	
}
