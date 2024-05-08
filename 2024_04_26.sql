create table pc_mybatis_mvc2 (
        pnum number primary key,
        cpu varchar2(200) not null,
        mainboard varchar2(200) not null,
        ram varchar2(200) not null,
        vga varchar2(200)
        );

insert into board values(1, '홍길동', '아무제목', '아무내용', '1234', default, sysdate, null);
insert into board values(2, '아이유', '봄이 왔네요', '꽃이 피어나고 있어요', '5678', DEFAULT, SYSDATE, NULL);
insert into board values(3, '김철수', '오늘의 일정', '회의가 있습니다', 'abcd', DEFAULT, SYSDATE, NULL);
insert into board values(4, '박영희', '여행 계획', '다음 주에 여행을 떠납니다', 'efgh', DEFAULT, SYSDATE, NULL);
insert into board values(5, '이동민', '프로젝트 업무', '기한이 다가오고 있습니다', 'ijkl', DEFAULT, SYSDATE, NULL);
insert into board values(6, '장영실', '과학 실험 결과', '새로운 발견을 했습니다', 'mnop', DEFAULT, SYSDATE, NULL);
insert into board values(7, '윤서영', '수학 시험', '평균 이상의 점수를 받았습니다', 'qrst', DEFAULT, SYSDATE, NULL);
insert into board values(8, '최재성', '야구 경기', '우리 팀이 승리했습니다', 'uvwx', DEFAULT, SYSDATE, NULL);
insert into board values(9, '이민호', '음악 콘서트', '내일 콘서트가 있습니다', 'yz12', DEFAULT, SYSDATE, NULL);
insert into board values(10, '정지훈', '책 읽기', '새로운 책을 읽고 있습니다', '3456', DEFAULT, SYSDATE, NULL);

create table zzacher2 (
        file_name varchar2(200) not null,
        file_path varchar2(200) not null,
        file_number number
        );

ALTER TABLE zzacher2 RENAME COLUMN file_number TO pnum;
        
