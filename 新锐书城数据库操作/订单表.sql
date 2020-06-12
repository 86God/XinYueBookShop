CREATE TABLE order_form (
    id NUMBER(10,0) NOT NULL,
    user_id NUMBER(10,0) NOT NULL,
    book_id NUMBER(10,0) NOT NULL,
    book_num NUMBER(10,0) DEFAULT 1 NOT NULL ,
    money NUMBER(10,0) DEFAULT 0 NOT NULL,
    shipping_Address varchar2(200) NOT NULL,
    shipping_PhoneNum NUMBER(11,0) NOT NULL ,
    shipping_personName varchar2(200) NOT NULL,
    create_date DATE DEFAULT SYSDATE NOT NULL, 
    type varchar2(20) DEFAULT '待付款'  NOT NULL,
    PRIMARY KEY (id) 
);

drop table order_form;

insert into order_form(user_id,book_id,book_num,money,shipping_Address,create_date, shipping_PhoneNum,shipping_personName) values (1000002,1000111,10,100,'陕西省渭南市蒲城县椿林乡贾王庄一组',trunc(sysdate),15592237827,'张耿英');
insert into order_form(user_id,book_id,book_num,money,shipping_Address,create_date, shipping_PhoneNum,shipping_personName) values (1000001,1000112,10,100,'陕西省渭南市蒲城县',trunc(sysdate),15592237827,'张耿英');
insert into order_form(user_id,book_id,book_num,money,shipping_Address,create_date, shipping_PhoneNum,shipping_personName,type) values (1000001,1000112,10,100,'陕西省渭南市蒲城县',trunc(sysdate),15592237827,'张耿英','待发货');


delete ORDER_FORM where ID = 1000004;

--创建订单id的序列
CREATE SEQUENCE order_form_seq  --序列名字随便取
       START WITH    1000001     --开始的值
       INCREMENT  BY 1	   --每次递增的序列值
       MINVALUE      1000001	   --最小值
       MAXVALUE   9999999 --最大数值可以随便设置
       NOCYCLE           --用完maxvalues后，不再循环！（不再循环）
       CACHE 10  ;       --每次提前缓存10数字提高效率，可以随便设置
       
drop SEQUENCE order_form_seq;

--创建订单id序列生成的触发器
CREATE TRIGGER order_form_trigger
       BEFORE INSERT ON order_form
       FOR EACH ROW        --行级触发器：插入的每一行数据都会触发
       BEGIN               --从序列中获取新的序号并赋给 新行 的gid 字段
           SELECT order_form_seq.nextval INTO :new.id FROM dual;
       END;   
       
drop TRIGGER order_form_trigger;
       
       
select * from order_form;
select * from order_form where user_id = 1000011 order by id DESC;
commit;

update order_form set user_id = 1000003 , book_id = 1000222 ,DATA = trunc(sysdate) where id = 1000005;
delete from order_form where id = 1000005;

select order_form.id as order_from_id,order_form.book_id,
books.name as book_name,books.author as book_author,
books.publishing_house,books.price as book_price,order_form.book_num as buy_num,
order_form.money as total_price,
order_form.create_date,"USER".user_name,"USER".phone_num,
"USER".name as consignee,"USER".shipping_address 
from order_form,"USER",books 
where user_id = "USER".id and order_form.book_id = books.id  and order_form.id = 1000001;
