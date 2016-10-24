 CREATE TABLE  seckill(
	seckill_id int NOT NULL AUTO_INCREMENT COMMENT '商品库存表id',
	name varchar(120) NOT NULL COMMENT '商品名称',
	number int NOT NULL COMMENT '库存数量',
	start_time timestamp NOT NULL COMMENT '秒杀开始时间',
	end_time  timestamp  NOT NULL COMMENT '秒杀结束时间',
	create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	PRIMARY KEY (seckill_id),
	key idx_start_time(start_time),
	key idx_end_time(end_time),
	key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';


CREATE TABLE succeed_kill(
seckill_id bigint NOT NULL COMMENT '商品秒杀id',
user_phone bigint NOT NULL COMMENT '用户手机号',
state tinyint NOT NULL DEFAULT -1 COMMENT '状态标识： -1：无效 0：成功 1：付款 2：发货 3：已收货',
create_time timestamp NOT NULL  COMMENT '创建时间',
PRIMARY KEY(seckill_id,user_phone),
key idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';