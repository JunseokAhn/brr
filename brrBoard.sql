--ȸ�� ���� ���̺�
create table brr_member(
    id                  varchar2(50)        primary key --ȸ��ID
    ,email              varchar2(100)       not null    --�ۼ���email    
    ,nickname           varchar2(50)                    --����
    ,gender             varchar2(10)        not null    --����    
    ,birthday           varchar2(10)        not null    --����
    ,age                varchar2(10)        not null    --����
    ,profile_image      varchar2(1000)                  --�������̹���
);

--�Խ��� ���� �� ���̺�
create table brr_board(
    boardnum        number              primary key         --�۹�ȣ
    ,id             varchar2(50)        not null            --�ۼ���ID
    ,email          varchar2(100)       not null            --�ۼ���email    
    ,title          varchar2(200)       not null            --����
    ,contents       varchar2(2000)      not null            --����
    ,inputdate      date                default sysdate     --�ۼ���
    ,originalfile   varchar2(200)                           --÷������ �����̸� // ���� rate / number
    ,savedfile      varchar2(100)                           --÷������ ����� �̸� // û�ᵵ cleanness / number
);

--�Խ��� �� ��ȣ�� ����� ������
create sequence brr_board_seq;
commit;

--��� ���̺�
create table brr_reply (
	replynum		number		            primary key	        --��۹�ȣ
	,boardnum	    number 		            not null		    --���� �۹�ȣ
	,id		        varchar2(50) 	        not null		    --�ۼ��� ID
    ,email          varchar2(100)           not null            --�ۼ���email
	,comments		varchar2(500) 	        not null		    --����
	,inputdate		date 		            default sysdate	    --�ۼ���
	,constraint replyBoard_fk foreign key(boardnum)
        references brr_board(boardnum) on delete cascade
);

--��� ��ȣ�� ������
create sequence brr_reply_seq;
commit;


--������ SQL�� ����
--naver Member SQL��
CREATE table naverMember 
(id     VARCHAR2(50) PRIMARY KEY, --ID
email   VARCHAR2(50) not null, -- email
nickname VARCHAR2(50), --����
gender  VARCHAR2(10) not NULL, -- ����
birthday VARCHAR2(10) not null, -- ����
age VARCHAR2(10) not NULL, -- ����
profile_image VARCHAR2(1000) -- ������ �̹���
);