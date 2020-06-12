--�����û���
CREATE TABLE "USER" (
    id NUMBER(10,0) NOT NULL,
    user_name VARCHAR2(20) UNIQUE NOT NULL,
    phone_num NUMBER(11,0) UNIQUE NOT NULL,
    password VARCHAR2(16) NOT NULL,
    name VARCHAR2(16) ,
    sex VARCHAR2(3) DEFAULT '��' NOT NULL,
    shipping_address VARCHAR2(200),
    PRIMARY KEY (id) 
);

--�����û�id������
CREATE SEQUENCE user_seq  --�����������ȡ
       START WITH    1000001     --��ʼ��ֵ
       INCREMENT  BY 1	   --ÿ�ε���������ֵ
       MINVALUE      1000001	   --��Сֵ
       MAXVALUE   9999999 --�����ֵ�����������
       NOCYCLE           --����maxvalues�󣬲���ѭ����������ѭ����
       CACHE 10  ;       --ÿ����ǰ����10�������Ч�ʣ������������
       
drop SEQUENCE user_seq;       

--�����û�id�������ɵĴ�����
CREATE TRIGGER user_id_trigger
       BEFORE INSERT ON "USER"
       FOR EACH ROW        --�м��������������ÿһ�����ݶ��ᴥ��
       BEGIN               --�������л�ȡ�µ���Ų����� ���� ��gid �ֶ�
           SELECT user_seq.CURRVAL INTO :new.id  FROM dual;
       END;   
       
drop TRIGGER user_id_trigger;         
       
--�����û����������ɵĴ�����
CREATE OR REPLACE TRIGGER user_id_name_trigger
       BEFORE INSERT ON "USER"
       FOR EACH ROW        --�м��������������ÿһ�����ݶ��ᴥ��
       DECLARE
       NEXT_ID number;
       BEGIN               --�������л�ȡ�µ���Ų����� ���� ��gid �ֶ�
           select user_seq.nextval into NEXT_ID from dual;
           :new.id := NEXT_ID;
           :new.user_name := CONCAT('�û�',TO_CHAR(NEXT_ID));
       END;  
       

drop TRIGGER user_id_name_trigger;  

select to_char(user_seq.nextval) from dual;


drop table "USER";

insert into "USER" (phone_num,password) values (18888866611,'123456');

update "USER" set user_name = '86_god',phone_num = 12345678910,name = '����',sex = 'Ů',shipping_address = '��������ѧ' where id = 1000001;

update "USER" set password = '896222' where id = 1000001;

insert into "USER" (user_name,phone_num,password,name,sex,shipping_address) values ('85_god',18888866611,'123456','����','��','����ʡ��������������ѧ');
delete "USER" where id = 1000002;

select * from "USER";

select * from "USER" where phone_num = 12345678910;
 
select * from "USER" where id = 1000001;

select * from "USER" where user_name = '86_god';


commit;