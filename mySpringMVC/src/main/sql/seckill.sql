--定界符
DELIMITER $$
--定义存储过程
CREATE PROCEDURE seckill.execute_seckill
	(in v_seckill_id bigint,in v_phone bigint ,
	in v_kill_time timestamp,out r_result int)
BEGIN
	DECLARE insert_count int DEFAULT 0;
	START TRANSACTION;
	insert ignore into succeed_kill
	(seckill_id,user_phone,create_time)
	values(v_seckill_id,v_phone,v_kill_time);
	select row_count() into insert_count;
	IF (insert_count = 0)	THEN
		ROLLBACK;
		set r_result = -1;
	ELSEIF (insert_count < 0) THEN
		ROLLBACK;
		set r_result = -2;
	ELSE
		update seckill
		set number = number - 1
		where seckill_id = v_seckill_id
		and start_time < v_kill_time
		and end_time > v_kill_time
		and number > 0;
		select row_count() into insert_count ;
		IF (insert_count = 0) THEN
			ROLLBACK;
			set r_result = 0;
		ELSEIF (insert_count < 0) THEN
			ROLLBACK;
			set r_result = -2;
		ELSE
			commit;
			set r_result = 1;
		END IF;	
	END IF;
END;
$$


--存储过程定义结束
DELIMITER ;

set @r_result = -3;
--执行存储过程
call execute_seckill(1003,13886079767,now(),@r_result);
--获取结果
select @r_result;
