create table pc_mybatis_mvc2 (
        pnum number primary key,
        cpu varchar2(200) not null,
        mainboard varchar2(200) not null,
        ram varchar2(200) not null,
        vga varchar2(200)
        );

insert into board values(1, 'ȫ�浿', '�ƹ�����', '�ƹ�����', '1234', default, sysdate, null);
insert into board values(2, '������', '���� �Գ׿�', '���� �Ǿ�� �־��', '5678', DEFAULT, SYSDATE, NULL);
insert into board values(3, '��ö��', '������ ����', 'ȸ�ǰ� �ֽ��ϴ�', 'abcd', DEFAULT, SYSDATE, NULL);
insert into board values(4, '�ڿ���', '���� ��ȹ', '���� �ֿ� ������ �����ϴ�', 'efgh', DEFAULT, SYSDATE, NULL);
insert into board values(5, '�̵���', '������Ʈ ����', '������ �ٰ����� �ֽ��ϴ�', 'ijkl', DEFAULT, SYSDATE, NULL);
insert into board values(6, '�念��', '���� ���� ���', '���ο� �߰��� �߽��ϴ�', 'mnop', DEFAULT, SYSDATE, NULL);
insert into board values(7, '������', '���� ����', '��� �̻��� ������ �޾ҽ��ϴ�', 'qrst', DEFAULT, SYSDATE, NULL);
insert into board values(8, '���缺', '�߱� ���', '�츮 ���� �¸��߽��ϴ�', 'uvwx', DEFAULT, SYSDATE, NULL);
insert into board values(9, '�̹�ȣ', '���� �ܼ�Ʈ', '���� �ܼ�Ʈ�� �ֽ��ϴ�', 'yz12', DEFAULT, SYSDATE, NULL);
insert into board values(10, '������', 'å �б�', '���ο� å�� �а� �ֽ��ϴ�', '3456', DEFAULT, SYSDATE, NULL);

create table zzacher2 (
        file_name varchar2(200) not null,
        file_path varchar2(200) not null,
        file_number number
        );

ALTER TABLE zzacher2 RENAME COLUMN file_number TO pnum;
        
