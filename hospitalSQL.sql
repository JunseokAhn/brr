create table brr_toilet
(
    toiletNm varchar2(100), -- ȭ��� �̸�
    toiletType varchar2(15), -- ȭ��� Ÿ�� ( ���� or ����)
    lnmadr varchar2(150), -- ȭ��� �ּ�
    unisexToiletYn varchar(2), --�������ȭ��� ����
    menToiletBowlNumber number, --������ �뺯�� ��
    menUrineNumber number, -- ������-�Һ����
    menHandicapToiletBowlNumber number, --������-����ο�뺯���
    menHandicapUrinalNumber number, --������-����ο�Һ����
    menChildrenToiletBowlNumber number, --������-��̿�뺯���
    menChildrenUrinalNumber number, --������-��̿�Һ����
    ladiesToiletBowlNumber number, --������-�뺯���
    ladiesHandicapToiletBowlNumber number, --������-����ο�뺯���
    ladiesChildrenToiletBowlNumber number, --������-��̿�뺯���
    institutionNm varchar2(100),--���������
    phoneNumber varchar2(50),--��ȭ��ȣ
    openTime varchar2(200), --����ð�
    lat number, --x��ǥ(����)
    lng number --y��ǥ(�浵)   
);
drop table brr_toilet;

select count(*)
from brr_toilet;

select *
from brr_toilet;

delete from brr_toilet;

rollback;



select * from (
select toiletNm, toiletType, lat, lng
    , trunc(DISTANCE_WGS84(34.969373,127.578384, lat, lng),3)*1000 as DISTANCE
from brr_toilet
where (lat between 34.969373-0.019 and 34.969373+0.019)
    and (lng between 127.578384-0.022 and 127.578384+0.022)
order by DISTANCE) TMP where rownum < (select count(*)from brr_toilet);




-- radians = degrees / (180 / pi)
-- RETURN nDegrees / (180 / ACOS(-1));  -- but 180/pi is a constant, so...
CREATE OR REPLACE FUNCTION RADIANS(nDegrees IN NUMBER) RETURN NUMBER DETERMINISTIC IS
BEGIN  
  RETURN nDegrees / 57.29577951308232087679815481410517033235;
END RADIANS;


CREATE OR REPLACE FUNCTION DISTANCE_WGS84( H_LAT in number, H_LNG in number, T_LAT in number, T_LNG in number)
RETURN NUMBER DETERMINISTIC
IS
BEGIN
  RETURN ( 6371.0 * acos( 
          cos( radians( H_LAT ) )*cos( radians( T_LAT /* ���� */ ) )
          *cos( radians( T_LNG /* �浵 */ )-radians( H_LNG ) )
          +
          sin( radians( H_LAT ) )*sin( radians( T_LAT /* ���� */ ) )       
         ));
end DISTANCE_WGS84;




