--�������ﳵ��
CREATE TABLE shopping_cart (
    id NUMBER(10,0) NOT NULL,
    user_id NUMBER(10,0) NOT NULL,
    book_id NUMBER(10,0) NOT NULL,
    book_num NUMBER(10,0) DEFAULT 1 NOT NULL
);

drop TABLE shopping_cart;

--�������ﳵid������
CREATE SEQUENCE seq_shopping_cart  --�����������ȡ
       START WITH    1000001     --��ʼ��ֵ
       INCREMENT  BY 1	   --ÿ�ε���������ֵ
       MINVALUE      1000001	   --��Сֵ
       MAXVALUE   9999999 --�����ֵ�����������
       NOCYCLE           --����maxvalues�󣬲���ѭ����������ѭ����
       CACHE 10  ;       --ÿ����ǰ����10�������Ч�ʣ������������    
       
drop SEQUENCE seq_shopping_cart;       

--�������ﳵid�������ɵĴ�����
CREATE TRIGGER shopping_cart_trigger
       BEFORE INSERT ON shopping_cart
       FOR EACH ROW        --�м��������������ÿһ�����ݶ��ᴥ��
       BEGIN               --�������л�ȡ�µ���Ų����� ���� ��gid �ֶ�
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
