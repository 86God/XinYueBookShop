--创建用户表
CREATE TABLE "USER" (
    id NUMBER(10,0) NOT NULL,
    user_name VARCHAR2(20) UNIQUE NOT NULL,
    phone_num NUMBER(11,0) UNIQUE NOT NULL,
    password VARCHAR2(16) NOT NULL,
    name VARCHAR2(16) ,
    sex VARCHAR2(3) DEFAULT '男' NOT NULL,
    shipping_address VARCHAR2(200),
    PRIMARY KEY (id) 
);

--创建用户id的序列
CREATE SEQUENCE user_seq  --序列名字随便取
       START WITH    1000001     --开始的值
       INCREMENT  BY 1	   --每次递增的序列值
       MINVALUE      1000001	   --最小值
       MAXVALUE   9999999 --最大数值可以随便设置
       NOCYCLE           --用完maxvalues后，不再循环！（不再循环）
       CACHE 10  ;       --每次提前缓存10数字提高效率，可以随便设置
       
drop SEQUENCE user_seq;       

--创建用户id序列生成的触发器
CREATE TRIGGER user_id_trigger
       BEFORE INSERT ON "USER"
       FOR EACH ROW        --行级触发器：插入的每一行数据都会触发
       BEGIN               --从序列中获取新的序号并赋给 新行 的gid 字段
           SELECT user_seq.CURRVAL INTO :new.id  FROM dual;
       END;   
       
drop TRIGGER user_id_trigger;         
       
--创建用户名序列生成的触发器
CREATE OR REPLACE TRIGGER user_id_name_trigger
       BEFORE INSERT ON "USER"
       FOR EACH ROW        --行级触发器：插入的每一行数据都会触发
       DECLARE
       NEXT_ID number;
       BEGIN               --从序列中获取新的序号并赋给 新行 的gid 字段
           select user_seq.nextval into NEXT_ID from dual;
           :new.id := NEXT_ID;
           :new.user_name := CONCAT('用户',TO_CHAR(NEXT_ID));
       END;  
       

drop TRIGGER user_id_name_trigger;  

select to_char(user_seq.nextval) from dual;


drop table "USER";

insert into "USER" (phone_num,password) values (18888866611,'123456');

update "USER" set user_name = '86_god',phone_num = 12345678910,name = '张三',sex = '女',shipping_address = '陕西理工大学' where id = 1000001;

update "USER" set password = '896222' where id = 1000001;

insert into "USER" (user_name,phone_num,password,name,sex,shipping_address) values ('85_god',18888866611,'123456','唐三','男','陕西省汉中市陕西理工大学');
delete "USER" where id = 1000002;

select * from "USER";

select * from "USER" where phone_num = 12345678910;
 
select * from "USER" where id = 1000001;

select * from "USER" where user_name = '86_god';


commit;