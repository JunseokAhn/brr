--sns�Խ��� ���� �� ���̺�
create table snsBoard(
    snsBoardnum         number              primary key         --�۹�ȣ
    ,id                 varchar2(50)        not null            --�ۼ���ID
    ,email              varchar2(100)       not null            --�ۼ���email    
    ,title              varchar2(200)       not null            --����
    ,contents           varchar2(2000)      not null            --����
    ,inputdate          date                default sysdate     --�ۼ���
    ,originalfile       varchar2(200)                           --÷������ �����̸� 
    ,savedfile          varchar2(100)                           --÷������ ����� �̸� 
);
--sns�Խ��� �� ��ȣ�� ����� ������
create sequence snsBoard_seq;
commit;

--��� ���̺�
create table snsReply(
	snsReplynum		    number		            primary key	        --��۹�ȣ
	,snsBoardnum	    number 		            not null		    --���� �۹�ȣ
	,id		            varchar2(50) 	        not null		    --�ۼ��� ID
    ,email              varchar2(100)           not null            --�ۼ���email        
	,comments		    varchar2(500) 	        not null		    --����
	,inputdate		    date 		            default sysdate	    --�ۼ���
	,constraint snsReply_fk foreign key(snsBoardnum)
        references snsBoard(snsBoardnum) on delete cascade
);

--��� ��ȣ�� ������
create sequence snsReply_seq;
commit;

insert into 
    snsBoard(
        snsBoardnum
        ,id
        ,title
        ,contents
        )values(
        snsBoard_seq.nextval
        ,'haha'
        ,'sns������'
        ,'sns�۳���'
        );
commit;

select
	snsBoardnum
	,id
	,title
	,contents
	,to_char(inputdate, 'YYYY/MM/DD HH24:MI:SS') as inputdate
	,originalfile
	,savedfile
from
	snsBoard
where
	snsBoardnum = 3;

        