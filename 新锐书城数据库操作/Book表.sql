--�������
CREATE TABLE books (
    id NUMBER(10,0) NOT NULL,
    name VARCHAR2(30) NOT NULL,
    type VARCHAR2(30) NOT NULL,
    author VARCHAR2(30) NOT NULL,
    price FLOAT(10) NOT NULL,
    book_img VARCHAR2(30) not null,
    introduction VARCHAR2(255) not null,
    publishing_house VARCHAR2(50) NOT NULL,
    repertory_number NUMBER(10,0) NOT NULL,
    PRIMARY KEY (id) 
);

drop table books;

--�����鼮id������
CREATE SEQUENCE seq_books  --�����������ȡ
       START WITH    1000001     --��ʼ��ֵ
       INCREMENT  BY 1	   --ÿ�ε���������ֵ
       MINVALUE      1000001	   --��Сֵ
       MAXVALUE   9999999 --�����ֵ�����������
       NOCYCLE           --����maxvalues�󣬲���ѭ����������ѭ����
       CACHE 10  ;       --ÿ����ǰ����10�������Ч�ʣ������������    
       
drop SEQUENCE seq_books;       

--�����鼮id�������ɵĴ�����
CREATE TRIGGER books_trigger
       BEFORE INSERT ON books
       FOR EACH ROW        --�м��������������ÿһ�����ݶ��ᴥ��
       BEGIN               --�������л�ȡ�µ���Ų����� ���� ��gid �ֶ�
           SELECT seq_books.nextval INTO :new.id FROM dual;
       END;   
       
drop TRIGGER books_trigger;

insert into books(name,type,author,price,book_img,introduction,publishing_house,repertory_number) values ('�峿���','��ѧ','[��]����ľ��һ',98.00,'img\004.png','������峿���ǡ�ɽ��Ƥ����������ﰲ��ɭ���ײ�����¼��������������׷�����Լ��ĳɳ��켣���������̡�','�������ϳ��湫˾',10000);
insert into books(name,type,author,price,book_img,introduction,publishing_house,repertory_number) values ('�Ļ�����','��ʷ','������',50.00,'img\005.png','���Ļ����á�һ����1992���״γ��棬������������1980����ں����⽲ѧ�Ϳ���;��д�µ���Ʒ�������ĵ�һ���Ļ�ɢ�ļ���','��������',10000);
insert into books(name,type,author,price,book_img,introduction,publishing_house,repertory_number) values ('�󽭴��','��ѧ','���� ',98.00,'img\006.PNG','���󽭴�ӡ��Ժ����Ļֺ��֣�ȫ�桢ϸ�¡������չ�����й��ĸ￪��������������ĸĸ�������ı仯�Լ����Ǿ�����ò�ĸı�ȷ������棬����Ϊ����д�й��ĸ￪�ŵ����顱��','�������ϳ��湫˾',10000);
insert into books(name,type,author,price,book_img,introduction,publishing_house,repertory_number) values ('�����ʷ','��ʷ','[��]����',9.00,'img\007.PNG','���鹲�˱���ʮ���£��������еĵ���д��һֱ������һ�������ս�������˹Ű�������ϣ����������Ӣ���������������ȳ����������˥���䡣','�������ϳ��湫˾',10000);
insert into books(name,type,author,price,book_img,introduction,publishing_house,repertory_number) values ('����ʫ','�̲�','������;�',98.00,'img\008.PNG',' ʫ������Ҫ��������������ǻ��棬�ͺá�ѧ�������죬2019�������������ִ������﷽ʽ����Ӱ���ӽǣ����Ũ�����������֣������Ŀ��56�׼�Ʒ��ʫ���ʫ�黭�⡣','�����Ļ���ý�ɷ����޹�˾',10000);
insert into books(name,type,author,price,book_img,introduction,publishing_house,repertory_number) values ('�й���ѧʷ','��ʷ','������',50.00,'img\009.PNG','���ǵ�һ�������ġ������ִ�������й���ѧʷ������������������ѧ����ʽ�������й���ѧ˼��֮ʵ��ʹ�й���ͳ��ѧ��Ϊ�ִ�ѧ��','�������ϳ��湫˾',10000);
insert into books(name,type,author,price,book_img,introduction,publishing_house,repertory_number) values ('��������','��ʷ','[��]������������',98.00,'img\010.PNG','������ʷ�ϵĶ���ʱ�������ϸ�����ͬ��������Ÿ��Ե�������򡪡�ŷ�޵ľ�������ۣ��ж�����˹���̹ۣ����޶������Ļ���Դ���γɵĲ�ͬ����ۣ��Լ�����������ȫ���ࡱ������ۡ�','���ų�����',10000);
insert into books(name,type,author,price,book_img,introduction,publishing_house,repertory_number) values ('�������ѧ','��ѧ','[��] ���ɵ¡�A��ŵ��',98.00,'img\011.PNG','������ù���Ū�������ô��ˮ��ͷ��������Բ���Ϥ��¯����ƿ���ʱ����ʹ�ٴ�������Ҳ�������޴롣','���ų�����',10000);
insert into books(name,type,author,price,book_img,introduction,publishing_house,repertory_number) values ('������Ͷ����','��ѧ','�����������׶�ķ',98.00,'img\012.PNG','�ɼ�ɭ����������ݽ�40������������֮��ȫ����еĴ󶯵���ʵ����һ���������֤�˼�ֵͶ�����ۡ����д�����ע�ͺ�ÿ��֮��ĵ����ǳ��м�ֵ��','�������ϳ��湫˾',10000);
insert into books(name,type,author,price,book_img,introduction,publishing_house,repertory_number) values ('������','��ѧ','���',98.00,'img\013.PNG','���齲����һ��������ܰ�ļ�ͥ��ʮ��ƽ�����桢���������������ʧ�ľ�������������Լ������ص����ԣ��������Ⱥ�������ȥ��Ů��Ǯ襡��ɷ�Ǯ���飬�Լ�һ��������Щ���ֶ����ѡ�����ʹ�����ӡ�','�������ϳ��湫˾',10000);
insert into books(name,type,author,price,book_img,introduction,publishing_house,repertory_number) values ('����','��ѧ','լլ��',98.00,'img\014.PNG','��Ҫ����������ͥ�����ֲ�ͬ�������Լ����Ǹ���Ϊ����׷���������ܶ���չ����һ�ι��¡��������Ծ����Ϊ�����д�ģ�ϣ����ҿ����ҵ���֮�󣬸��������','�������ϳ��湫˾',10000);
insert into books(name,type,author,price,book_img,introduction,publishing_house,repertory_number) values ('������','��ѧ','��ʯϪ',98.00,'img\015.PNG','����д����һƥ�����ǻ۵��ǣ���һ����ʱ��������Լ������롣�ɷ�û�ˣ����ж��ӣ�����û�ˣ�����Ů����Ϊ��������������������������˷��˴����ഺ�������������ð��飬�������˱���������','�������ϳ��湫˾',10000);


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('���','�����','����ˡ���ɪ˹','65.0','img\061.PNG','�����ʵ������','5000','����չʾ����ʵ�ʱ�����ԣ���C����ʵ�ֵ��㷨�������һ�����ѧ�����в�����');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('��ѧ֮��','�����','���','38.3','img\062.PNG','�����ʵ������','5000','ͨ������ʵ���̻�����ڽ������ʱ��λ���Ϊ���������ѧȥ����������⣬�����������˼ά����ȥ˼�����µȡ�');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('C++','�����','Stephen Prata','66.4','img\063.PNG','�����ʵ������','5000','C++����ӵ�м������Ч���е�ʵ����������ͬʱ����������ߴ��ģ����ı�����������������Ե���������������');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('Linux','�����','���','92.2','img\064.PNG','�����ʵ������','5000','Linux��Ҫ�ܵ�Minix��Unix˼�����������һ������POSIX��Unix�Ķ��û���������֧�ֶ��̺߳Ͷ�CPU�Ĳ���ϵͳ��');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('���ѧϰ','�����','Ian Goodfellow','112.6','img\065.PNG','�����ʵ������','5000','���ѧϰ(DL, Deep Learning)�ǻ���ѧϰ(ML, Machine Learning)������һ���µ��о����������������ѧϰʹ����ӽ��������Ŀ�ꡪ���˹�����(AI, Artificial Intelligence)��');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('�˳�֮�� ','�����','���','93.2','img\066.PNG','�����ʵ������','5000','���˳�֮�ۡ�ϵͳ�ؽ�������Щ��˾�ɹ��ı���ԭ�򼰿Ƽ���ҵһ�ٶ���ķ�չ');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('ʱ�����','�����','ʷ�ٷ�','18.6','img\067.PNG','�����ʵ������','5000','ʱ�������ָͨ�����ȹ滮������һ���ļ��ɡ������빤��ʵ�ֶ�ʱ�������Լ���Ч���ã��Ӷ�ʵ�ָ��˻���֯�ļȶ�Ŀ��Ĺ��̡�');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('Java','�����','Bruce Eckel','75.6','img\068.PNG','�����ʵ������','5000','Java��һ��������������ԣ�����������C++���Եĸ����ŵ㣬��������C++���������Ķ�̳С�ָ��ȸ���');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('�㷨���ۣ�','�����','�ƶ���','89.6','img\069.PNG','��е��ҵ������','5000','������һ��ʮ�־���ļ�����㷨�鼮����ߵ��ɣ�Donald E.Knuth���ġ���������������������The Art Of Computer Programming����������');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('MySQL��','�����','ʩ�ߴ�','89.6','img\070.PNG','���ӹ�ҵ������','5000','MySQL��һ�ֹ�ϵ�����ݿ����ϵͳ����ϵ���ݿ⽫���ݱ����ڲ�ͬ�ı��У������ǽ��������ݷ���һ����ֿ��ڣ��������������ٶȲ����������ԡ�');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('�����й�','����ѧ','��Тͨ','21.0','img\071.PNG','���������','5000','ȫ����14ƪ������ɣ��漰����������Ļ�������ͳ���ṹ��Ȩ�����䡢������ϵ������ѪԵ��Ե�ȸ����档');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('�Ķ�һ���� ','����ѧ','[��]Ī��Ĭ��  ','29.9','img\072.PNG','����ӡ���','5000','�����Ķ����ˣ���̽�Ķ����ˣ����Ȿ���������ԩ��·�����Ķ����������ˣ����Ȿ������и����ӡ֤������');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES(' ��������','����ѧ','��������','22.8','img\073.PNG','���ų�����','5000','��������������Amusing ourselves to death��������ý���Ļ��о��ߡ����м��������������1985�����Ĺ��ڵ���������ȡ����д���Թ��̵�����');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('�����ڸߴ�','����ѧ','������','24.4','img\074.PNG','���ǳ�����','5000','ּ�ڴӸ���ĽǶ�̽����ת���ڵ�������γ�Խ�澳���̻����ɣ���չ���죬�������');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('������ ','����ѧ','���¡�','44.1','img\075.PNG','�Ϻ����ĳ�����','5000','��������Ebola virus����������������������һ��ʮ�ֺ����Ĳ���');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('�ڶ��ԣ�','����ѧ','������','83.2','img\076.PNG','�Ϻ����ĳ�����','5000','���ڶ��ԡ��Ƿ���˼��������ȡ������޴��������ѧ������');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('����뻨��','����ѧ','������ ','47.0','img\077.PNG','�Ϻ����ĳ�����','5000','������뻨������һ����ʳ�μǡ���ϼ�������յ��������е˷�ϼ�������Լ����й���ʳ���Ȱ�д�����飬�ⲻ���ǹ����й��˵Ĺ��£�Ҳ�����Ӣ��Ů�����й����ռ�');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('�й����','����ѧ','��ǿ','40.7','img\078.PNG','����.����.��֪�������','5000','�����Ȱ����������ִ���������������£��ر��Ǿš�ʮ��Ⱥ�壬��Ϊ���Ǹ�ϣ�����ҹ�����ܹ������Ǵ�����ʵ�ʵ�����ϣ���������ʵ�ݡ�');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('������ ','����ѧ','½��','48.0','img\079.PNG','�Ϻ����������','5000','�������ǡ����Ϻ�������������Ĺ����й���ǰ���羭�÷�չ����ʵ���ڵ���ʵ������鼮�������Ǿ���ѧ��½�����ڡ�');
insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES('������ ','����ѧ','J.D. ��˹ ','36.4','img\080.PNG','���շ�����ճ�����','5000','������һ������ĸ������13��СŮ������˹ά��˹�������˵Ĺ���');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('�ҵ�����֢','ҽѧ','����ɯ��','25.00','img\041.PNG','���ǳ�����','50000','���ҵ�����֢���Զ��ظ��Ե����Ժͼ�����Ⱦ�������裬������һ������֢�����������������ļ����������ľ�����ȫ��������¶���ֲ�ʧ��Ĭ��Ȥ�����������������䶯������Ϊ��һ�����˰��������Ľ�������');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('��ʥ��Դ','ҽѧ','��Ԫ��','16.00','img\042.PNG','�й���ҽҩ������','50000','����ʥ��Դ�����塤��Ԫ��������Ԫ������Ԫ1705��1758�꣩������·����Ԫ����һ�����أ�����ũ���e������ӣ�ɽ�������ˣ��������ҽ�ҡ�');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('��������ѧ','ҽѧ','������','36.00','img\043.PNG','ɽ������������','50000','����������ѧ�������ǳ�����������ùŲ���ѧ���Ƚ��Ŀ�ѧ���������Ŵ������������ܵĳ������������ˡ������ء��޲��ĺͻ�˼������˹����λѧ�ߴ�����������ص��������ϡ�������Ʒ�͹Ŵ��˹��Ŵ���Ѱ��֤�ݡ�');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('��Ѩ�永','����','�˵á�����','23.00','img\044.PNG','������֪������','50000',' ������Ѩ̽��������ɽ����ˮ���������޷��ڶ����ڻ�ȡ�Ϊ��ά���Դ���Ԯ����Ҿ�����ǩ�Ե�һ�ˣ��������ԾȻ��������ˡ�');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('�����о�','����','��õ�','40.00','img\045.PNG','�й����񹫰���ѧ������','50000',' �����������о�������13�¡�Χ���š����������о��뷸����ء�����������������������ݣ��������Ϊ����չ��������о��������˵Ļ������ͣ���������Ĳ�ͬ���֣���صķ��ؽ��顣');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('������','����','����','28.00','img\046.PNG','������ѧ������','50000',' �������ܵġ��ִ�����Ӣ�ۡ�Ĭ�������ǵ���������Ӱ���˺��������¶�����꣬�����ǵ��������Լ����ҡ������Ĵ�����');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('����Ͷ����','����','������','58.00','img\047.PNG','�����ʵ������','50000',' ��������Ͷ���ߡ�������ȷ�ˡ�Ͷ�ʡ��롰Ͷ����������ָ��������Ͷ���ߵ����ȷ��Ԥ�����档�������ؽ��ܷ�����Ͷ�����������Ͷ���ߵ�Ͷ����ϲ��ԣ�������Ͷ�������Ӧ���г�������');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('����ѧԭ��','����','����','56.00','img\048.PNG','������ѧ������','50000',' ������ѧԭ����Ŀǰ�����г����ܻ�ӭ�������澭��ѧ�̲�֮һ����ϴ��ص������ġ�ѧ�����򡱣��������ǿ������ѧԭ���Ӧ�ú����߷��������Ǿ���ѧģ�͡�');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('����ս��','����','�κ��','39.00','img\049.PNG','���ų�����','50000',' ��ȫ�򾭼÷�չ�Ĺ����У��������˾������ص����á�ͨ�͡�ͨ������ĭԽ��ԽƵ����Ӱ�쵽���ǵ�������ǻ��ұ������صļ�������֮����ȴ�ںܳ�ʱ���ﲻΪ����֪��');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('��������','����','����������','59.00','img\050.PNG','������ѧ����������','50000',' ����һ�������������������飻����һ�������Խ���飬�漰�Ķ�����ϸС�����������ұ�����ʤ�������߽��Լ��ľ���ͨ����102��ϸ������Ĳ�����������������ȫ��λ�������Լ����ܴ��ڵ����⼰���Դ��');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('����̫��ȭ','����','�����','15.00','img\051.PNG','��������������','50000',' ��ʽ̫��ȭ��ʼ����ĩ���������ȭʦ����͢������͢�Ǻ������س¼ҹ��ˡ��ӳ���͢�𣬳���������ϰ̫��ȭ�����϶�ԭ�е�ȭ�׽��мӹ��������𲽿��ɽ�����������һ����·ȭ�ס�');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('��С������','����','��С��','68.00','img\052.PNG','�������ϳ��湫˾','50000',' ����С������������һ������֮����С���Ĵ����Ÿ壬����С�������մ�Ůʿ�͡��ڴ�����־��ʼ��ˮ����ԭ������ɣ���������С����������ѧ��Ҫ��');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('�ǵ�����','����','����','25.00','img\053.PNG','��������������','50000',' ��1984�굽1998�꣬���ڰ�����������ǵú����˵ģ���Ϊ��������������Ŀ���ǵ��ڴ�����ۣ���д���񻰡�');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('����ֱǱ','����','��Ңķ','68.00','img\054.PNG','���������','50000','��Ңķ�������Ǳˮ������ں����ͺ���֮�䡣��λ��������Ǳˮ����ھ���ÿһ����Ǳ����һ���������ߣ�һ�θ��õ��˽��Լ�������֮�ã�һ���Ժ��ɿ���������������ʧ��еĸ��');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('����','����','�����','25.00','img\055.PNG','�ɶ�ʱ��������','50000',' ���岻����һ���˶�������һ�����������̬�ȣ��滬��������ˣ�������ϡ�����Ҫ˵�𻬰����ʷ���ǿ�˵���������ˣ�20����50���ĩ�����˻��壬��˵�ɳ����˶��ݱ�����ġ�');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('�����ӻ���','С˵','��Ұ����','39.50','img\056.PNG','�Ϻ����湫˾','50000',' �ձ�֪�����Ҷ�Ұ����ġ������ӻ��꡷�����浱�꼴�����빫�����ս�����ƷԽ������С˵�ķ�Χ��ȴ������С˵���ӿ������ҡ�');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('����¶�','С˵','������','39.50','img\057.PNG','�Ϻ����湫˾','50000','������¶�����ħ����ʵ������ѧ�Ĵ���������д�˲������Ǽ����ߴ��˵Ĵ�����£��Լ����ձȺ��ذ�С����׶�İ�����˥����ӳ����������һ�������������Ʊ�õ���ʷ��');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('��ҹ��','С˵','��Ұ����','39.50','img\058.PNG','�Ϻ����湫˾','50000',' ������ǰ�������һ�����������з���һ�����������������ӡ�������˷���룬ʼ������δ�����˺�20��䣬�����������Ķ�����ѿ���������ų���֮����');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('�շƵ�����','С˵','��˹̹��','26.00','img\059.PNG','���ҳ�����','50000','���շƵ����硷һ����С˵����ʽ��ͨ��һ����ѧ��ʦ��һ�����շƵ�Ů��������ѧ֪ʶ�ľ�������ʾ��������ѧ��չ�����̡�');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('͵Ӱ�ӵ���','С˵','��ˡ���ά','29.80','img\060.PNG','�������ճ�����','50000','��͵Ӱ�ӵ��ˡ������˲�֪�����ϵĿ��ٶ��������������������Ľ�ɫ����ͯ��ʱ��СŮ���������ɱ����Ů�ˣ�һ����÷����Ļ��䣬һ��ʱ��֮��û��Ӧ�ʵ�Ը����');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('����������', 'ҽѧ', '��ѧ��', '32.0','img\000.JPG' ,'������ҵ������','50000','������ѳ������꣬�ܵ���רҵ���ߵĹ�ע�����Ρ������ٰ��޶��ڱ��ְ�������ɫ��ͬʱ��������ʮ���ֳ���������ȫ�����д�����������һ��飬�Ա�������ٴ��淶��������·������¼���');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('ͼ�Ȿ�ݸ�Ŀ', 'ҽѧ', '��֯��д', '29.8','img\081.JPG' ,'��ѧ��ҵ������','50000','���齫�ҹ�ҽҩ���������ݸ�Ŀ�������˾��������������ճ��ܹ�����ʹ�õı���500 ���ּ���ʵ���õĸ���3000 ���ף�����ר����һ��֤�󶨣������˾����ı���ͼ��');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('�ʵ��ھ�', 'ҽѧ', '����', '75.0','img\082.JPG' ,'�������ϳ��湫˾','50000','�Ƶ��ھ�ȫ������ԭ���׻�����ҽҽѧ����ҩ�鼮��ȫ���Ĵ󾭵�������ѧ���ţ��ʵ��ھ��ʵ��ھ�����ҩѧȫ��');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('��ͯ����ѧ', 'ҽѧ', '������', '78.0','img\003.JPG' ,'��������������','50000','�����棬��ͯ����ѧ�������ݣ�ʮ����滮ҽѧ�̲� ����ͯ�������ƶ�ͯ����ҽѧ��רҵ�飬��ͯ�������������鼮����ҽ������');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('ҽѧ����ѧ', 'ҽѧ', '������', '38.0','img\004.JPG' ,'������ѧ������','50000','��ҽѧ����ѧ���ڵ�����Ļ����Ͻ�����ȫ���޶����ص�������Ӧ����ҽ����ϵ����ʳ�ϰ���˯���ϰ���������ʹ����ɱԤ�����ٴ�������ҽѧ����ѧ����');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('��ҽ�ٴ�˼ά', 'ҽѧ', '����', '28.0','img\005.JPG' ,'��������������','50000','����ҽ�ٴ�˼ά����Ҫ��Ըս����ٴ����й淶����ѵ��סԺҽʦ����д��ͬʱ����ҽҩԺУʵϰҽʦ���ٴ�רҵ�о���Ҳ��һ����ָ������');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('ʷ��ȫ��', '��ʷ', '˾��Ǩ', '298.0','img\006.JPG' ,'��װ��ֳ�����','50000','��������ɾ����ʷ��ȫ������ ˾��Ǩԭ��ȫ��������������İ׻��ļ�����ԭ���й���ʷ���鼮ʷ����а�ѡ���л���ֹŴ�ʷ������');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('�й�ͨʷ', '��ʷ', '��˼��', '39.8','img\007.JPG' ,'�й�����������','50000','���齲���˻������й�������������й�ʷ�������');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('�л�Ұʷ', '��ʷ', '����', '66.8','img\008.JPG' ,'�й����ȳ�����','50000','����Ұʷ����¼���������л������ǧ���������㷺��ʷ�Ǵ�˵������ͨ���������¼������档');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('����ͨ��', '��ʷ', '˾��Ǩ', '42.0','img\009.JPG' ,'��װ��ֳ�����','50000','ȫ2������ ʷ�� ����ͨ�� ˾��Ǩ�鼮ԭ��ԭ�� ȫעȫ��ȫ������������ѧ�����й�ͨʷ�������ʮ��ʷ ����ͨ���鼮����');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('���', 'С˵', 'ī��ͭ��', '45.0','img\010.JPG' ,'�Ĵ����ճ�����','50000','��������κ���ۣ�ǰ����������������ǽ塣�ݺ�һ��������ȫʬ��ʮ������ػ����ϣ������������Я�ֹ����ʬ�հ�');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('�з�', 'С˵', 'prise', '145.0','img\011.JPG' ,'�������ճ�����','50000','����һ�죬���������������ϴī�����뿪Ⱥɽ�����ľ���Դ�������ޱ�������ҹ��֮�¡����Ŀ��������������֮ɽ����㸲����Ҫ�ǵã�����������ڵ����ϣ������������Զ��ǰ��');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('������', 'С˵', '���߹���', '55.0','img\012.JPG' ,'�������ճ�����','50000','���ִ���չ���ͽȻ��˭�Ὣ�����þ���ֻΪ�غ�һ�δ������õ�Ե���������ǧ�����ִ��ʹ˷��¡����ϣ��Ƿ����������������Ϊ���죿��Ȼ��Ϊ���𣬶���Ҳ���𻯶�����');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('ʮ���һ�', 'С˵', '���߹���', '55.0','img\013.JPG' ,'�������ճ�����','50000','��һ�������֮��һ����ɽ���ɾ��������ĳ������һ����ƣ�֦Ҷ���裬������ۡ�������Է�棬������ʱҲ�ᱳ�ѣ�������ǰ����Ե������������ʮ���������ʮ�����������µ����ꡣ');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('��ǧ��', 'С˵', '����', '65.0','img\014.JPG' ,'�������ճ�����','50000','���س��������Ǹ߸����ϵĳ������ɣ���������С��ſ�����ϣ�ȴ���紵�������ľ�յ֮�С���С�ĵ�������������Ц��Ȼ���ִȱ���ƴ��ȫ����ֻΪ����һ�죬�ܽ���һ��"ʦ��"��');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('֪��֪��', 'С˵', '��������', '118.0','img\015.JPG' ,'�������ճ�����','50000','֪��֪��Ӧ���̷ʺ���1-6��ȫ������ذ��������������������Ů������ ����ӱ���ܷ����ݵ��Ӿ�ͬ��С˵��װ�ഺ��ѧ �»�����');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('�˶�����', '����', 'Լ��.���', '49.0','img\016.JPG' ,'�㽭���������','50000','����������Ӫ���˶������������ ���Ƕ����Ƽ� �����뱣���鼮�����˶���Ӫ��ָ�� ���ʽͷ�Բ��� ʱ�������˶�Ӫ��ѧ�鼮');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('�˶�ѵ��ѧ', '����', '����', '32.0','img\017.JPG' ,'��������������','50000','�˶�ѵ��ѧ ����ã�����ԺУͨ�ý̲ģ������������˶�ѵ�����˶��ɼ��뾺���������˶�ѵ�������ֶ��鼮���˶�����ѧ����ѧ');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('�ܲ�ָ��', '����', '�ܲ�ָ��', '25.0','img\018.JPG' ,'��е��ҵ������','50000','����ѡȡ100?���������ߺ�Ϊ���յ����⣬�������������˽��ܲ�����Ҫ֪���������ܲ����ɡ��ܲ�Ӫ�����ܲ����ˡ��ܲ�װ�����ܲ��ƻ��ȷ������漰���ص�����');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('����ѵ��', '����', '������', '39.0','img\019.JPG' ,'��������������','50000','����ѵ��(����ԺУͨ�ý̲�) ������ �����鼮9787500943150');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES ('�ܲ��ʼ�', '����', '����', '48.0','img\020.JPG' ,'�����ʵ������','50000','����ѵ��(�ܲ��ʼ�  ������ �ܲ�ע������ �ܲ��м��ɷ��� �ܲ����ŵ������� �ܲ���������� �˶������鼮 �����ܲ�');




insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('��ʷ������', '��ʷ', 
'����˹�и�', '52.40','img\021.PNG' ,
'����ʱ������������޹�˾', '26',
'���ǽ�ͨ���Ķ��ⲿ��ʷ���о���Ʒ�����֤�ݡ���������������Щ������������û���������������ش�ıɱ�¼�������������Ϯ�������ﻹ������ɵĺ����������Ŀ��');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('��������', '��ʷ', 
'��������', '45.50','img\022.PNG' ,
'�㽭��ѧ������', '101',
'��ǧ������˿��֮·ʼ�����������������Ľ��̡���ͬ�������ˣ�������������·�ϣ����첢�����ŲƸ����ǻۡ��ڽ̡�������ս�������������ѡ�');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('ϣ���˵Ĺ���', '��ʷ', 
'��Ұ����', '148.00','img\023.PNG' ,
'���ų��漯�Źɷ����޹�˾', '17',
'��ϣ���˵Ĺ��¡�����Ұ�����ķ��֮�����̡������˵Ĺ��¡�֮���ܴ��ڻ�ӭ����ʷ��Ʒϵ�С�');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('�Ͼ�����ɱ', '��ʷ', 
'�Ŵ���', '33.00','img\024.PNG' ,
'���ų��漯��', '439',
'�����Ǵ��ձ�ѧУ�ͽ̿�������������ѧ��������й�����ĳ�޺����ӣ��Լ��߶Ⱦ��»��Ľ������Ƶȶ������������Ͼ�����ɱ�����ĸ�Դ��ԭ��');

insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('ʳ��̽����', '��ʷ', 
'�����˹ͨ', '101.30','img\025.PNG' ,
'����ʦ����ѧ������', '5',
'����׷���������ƽ�ʱ����һλ�������е�ֲ��ѧ�ң�����ũҵ���ָ������˵Ĳ��������˷��츲�صı仯��');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('����ĸ���', '��ʷ', 
'�˵�ϣɪ', '98.00','img\026.PNG' ,
'���ų��漯��', '50',
'476�꣬������ĩ���ʵ۱��ϣ�������ĵ۹���ͳ�����սᡣȻ�����۹����Ļ����ƶȡ��������д�������֮��������߶����ؽ��۹���Ұ�ġ�');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('�ϱ�ս��', '��ʷ', 
'��˶', '57.70','img\027.PNG' ,
'�Ϻ����������', '183',
'����Ը���ʷ�Ͻ��з�����������ɢ��ʷ�������ս��������Ѱ��������Ϊ����������κ���ϱ��������ش�ս��ϸ�ڣ�չ�ֳ��ḻ����������ʷԭò��');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('���Ң֮��', '��ʷ', 
'֣С��', '44.10','img\028.PNG' ,
'ɽ�����������', '10',
' ����Χ�������Ң��Ӻ��������ϵ���ݱ����̣�ȫ��ع������Ңһ���ӵ��⵽ʧ��Ļº�������');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('����ʮ����', '��ʷ', 
'������', '19.50','img\029.PNG' ,
' �л����', '3',
'����һ���У�����������Ϊ��ʷѧ�������ں��ӵ��¼�����Щ�¼������濴������ĩ��С�ڣ���ʵ����ȴ����ǰ�������µ�֢�ᣬҲ�ǽ����Ժ��������Ļ�Ե��');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('����', '��ʷ', 
'��ӹ', '53.00','img\030.PNG' ,
'��������', '840',
'���齲���ģ�����������ڹ�ֽ���е��������������¼������ߴ�������һϵ�к�����䵵��������ھ����Щ�����ѾõĹ��¡�');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('ɽ����', '��ʷ', 
'�����', '26.00','img\031.PNG' ,
' �Ž������', '8',
'�ⲿ�����У�������ϸ�������л����ص�ɽ�����أ��������˴����������ϣ����漰��ѧ������ĸ������档');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('����й�ʷ', '��ʷ', 
'�ź��', '43.50','img\032.PNG' ,
'��´����', '2462',
'�����й�ʷ����֪�й�֮ΰ�󣻲�������ʷ����֪�й�֮���ʣ�');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('�й�����ʷ', '��ʷ', 
'������', '31.50','img\033.PNG' ,
'������顤��֪�������', '490',
'�����Զ̶̵Ķ�ʮ�����ֵ�ƪ���������������й���ʷ������ǧ���ȫò��');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('�ݽ���ڲ�', '�ڿ�', 
'���콾', '24.64','img\034.PNG' ,
'�ݽ���ڲ�', '2',
'�ݽ���ڲ�(�ܵ�17��϶����ܵ�642-657��ѧ������)��');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('����ԭ����', '�ڿ�', 
'����', '26.40','img\035.PNG' ,
'���߳��洫ý', '1',
'����ԭ����(B��϶����ܵ�147-152��)����ʽ��ӱ�������б�������̸�����ۡ����ۡ���ʡ����¡�ɢ�ġ�ͼƬ�ȶ�����ʽ��');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('��¶��', '�ڿ�', 
'������', '10.56','img\036.PNG' ,
'��¶��༭��', '6',
'���ÿ���¶��(2017���7���ܵ�159��)��');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('��ժ����', '�ڿ�', 
'������', '19.36','img\037.PNG' ,
'������ҵ��ѧ', '3',
'��������ժ������������Ů����������ζ��������־����Ϊ�زģ��꾡�о���Ů���ڳɳ�������Ӧ�߱������ʣ�������Ů�����ǣ�����Ů�������Ҹ�������');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('���»�', '�ڿ�', 
'��һ��', '8.80','img\038.PNG' ,
'�Ϻ��Ļ�', '16',
'�����»�(2017�϶���95��630�� \\631�ڴ�������)���ֱ�������Ƽ������ܸ�����¾�Ʒ��');



insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('����ʿ', '�ڿ�', 
'H.K.���ﰲ', '19.18','img\039.PNG' ,
'������Ӱ', '45',
'����ʿ(2������)/������־�ݡ�');


insert into books(name,type,author,price,book_img,publishing_house,repertory_number,introduction) VALUES 
('��ֽ����', '�ڿ�', 
'Ѧӡʤ', '158.40','img\040.PNG' ,
'�й��鼮', '1',
'����ֽ���䣺�ڿ����������͡����߽��Լ��ղض���Ĵ�����������档');









update BOOKS set name='�����Ч',type='רҵ��',author='��ڱ�',price=99.00,book_img='img\005.png',publishing_house='���ӹ�ҵ������',introduction='����һ�����д���÷�չ�Ĵ��룬дδ����ᷢչ��ÿһ�д��룬�����Ч�����δ��',repertory_number=999 where id = 1000011;

delete books where id = 1000001;

select * from books where id = 1000011;
select * from books where type = '�����';

select * from books where name like '%��¶��%' or AUTHOR like '%��%';

select * from books;

--分页查询
SELECT *  FROM   books
WHERE id IN (
  SELECT id  FROM (
        SELECT ROWNUM  rn , id FROM books memp WHERE  ROWNUM  <=10)  nemp
        WHERE  nemp.rn > 5
);

commit;