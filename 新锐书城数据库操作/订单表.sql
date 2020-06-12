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
    type varchar2(20) DEFAULT '������'  NOT NULL,
    PRIMARY KEY (id) 
);

drop table order_form;

insert into order_form(user_id,book_id,book_num,money,shipping_Address,create_date, shipping_PhoneNum,shipping_personName) values (1000002,1000111,10,100,'����ʡμ�����ѳ��ش��������ׯһ��',trunc(sysdate),15592237827,'�Ź�Ӣ');
insert into order_form(user_id,book_id,book_num,money,shipping_Address,create_date, shipping_PhoneNum,shipping_personName) values (1000001,1000112,10,100,'����ʡμ�����ѳ���',trunc(sysdate),15592237827,'�Ź�Ӣ');
insert into order_form(user_id,book_id,book_num,money,shipping_Address,create_date, shipping_PhoneNum,shipping_personName,type) values (1000001,1000112,10,100,'����ʡμ�����ѳ���',trunc(sysdate),15592237827,'�Ź�Ӣ','������');


delete ORDER_FORM where ID = 1000004;

--��������id������
CREATE SEQUENCE order_form_seq  --�����������ȡ
       START WITH    1000001     --��ʼ��ֵ
       INCREMENT  BY 1	   --ÿ�ε���������ֵ
       MINVALUE      1000001	   --��Сֵ
       MAXVALUE   9999999 --�����ֵ�����������
       NOCYCLE           --����maxvalues�󣬲���ѭ����������ѭ����
       CACHE 10  ;       --ÿ����ǰ����10�������Ч�ʣ������������
       
drop SEQUENCE order_form_seq;

--��������id�������ɵĴ�����
CREATE TRIGGER order_form_trigger
       BEFORE INSERT ON order_form
       FOR EACH ROW        --�м��������������ÿһ�����ݶ��ᴥ��
       BEGIN               --�������л�ȡ�µ���Ų����� ���� ��gid �ֶ�
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
