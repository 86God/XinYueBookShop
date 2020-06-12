--创建购物车表
CREATE TABLE shopping_cart (
    id NUMBER(10,0) NOT NULL,
    user_id NUMBER(10,0) NOT NULL,
    book_id NUMBER(10,0) NOT NULL,
    book_num NUMBER(10,0) DEFAULT 1 NOT NULL
);

drop TABLE shopping_cart;

--创建购物车id的序列
CREATE SEQUENCE seq_shopping_cart  --序列名字随便取
       START WITH    1000001     --开始的值
       INCREMENT  BY 1	   --每次递增的序列值
       MINVALUE      1000001	   --最小值
       MAXVALUE   9999999 --最大数值可以随便设置
       NOCYCLE           --用完maxvalues后，不再循环！（不再循环）
       CACHE 10  ;       --每次提前缓存10数字提高效率，可以随便设置    
       
drop SEQUENCE seq_shopping_cart;       

--创建购物车id序列生成的触发器
CREATE TRIGGER shopping_cart_trigger
       BEFORE INSERT ON shopping_cart
       FOR EACH ROW        --行级触发器：插入的每一行数据都会触发
       BEGIN               --从序列中获取新的序号并赋给 新行 的gid 字段
           SELECT seq_shopping_cart.nextval INTO :new.id FROM dual;
       END;   
       
drop TRIGGER shopping_cart_trigger;


insert into SHOPPING_CART(user_id,book_id) values(1000011,1000039);
insert into SHOPPING_CART(user_id,book_id) values(1000011,1000028);
insert into SHOPPING_CART(user_id,book_id) values(1000011,1000029);
insert into SHOPPING_CART(user_id,book_id) values(1000011,1000030);
insert into SHOPPING_CART(user_id,book_id) values(1000011,1000031);
insert into SHOPPING_CART(user_id,book_id) values(1000011,1000032);



insert into SHOPPING_CART(user_id,book_id) values(1000002,1000033);
insert into SHOPPING_CART(user_id,book_id) values(1000002,1000034);
insert into SHOPPING_CART(user_id,book_id) values(1000002,1000035);
insert into SHOPPING_CART(user_id,book_id) values(1000003,1000036);
insert into SHOPPING_CART(user_id,book_id) values(1000003,1000037);
insert into SHOPPING_CART(user_id,book_id) values(1000003,1000038);

update SHOPPING_CART set user_id = 1000005,book_id = 1000123,book_num = 10 where id = 1000005;

select * from shopping_cart;

delete shopping_cart where ID = 1000011;
select * from SHOPPING_CART where id = 1000001;

select * from SHOPPING_CART where user_id = 1000001;

select * from SHOPPING_CART where user_id = 1000001 and BOOK_ID = 1000111;

commit;
