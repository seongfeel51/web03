create table board( no number(10) primary key,
title varchar(30) not null,
content varchar(500) not null,
name varchar(10) not null,
regdate date,
visited int);

insert into board values(1, '제목1', '내용1', 'admin', sysdate, 0);
insert into board values((select nvl(max(no), 0)+1 from board), '제목2', '내용2', 'admin', sysdate, 0);
insert into board values((select nvl(max(no), 0)+1 from board), '제목3', '내용3', 'admin', sysdate, 0);

select * from board where seq=?;
insert into board values((select nvl(max(seq), 0)+1 from board), ?, ?, ?, sysdate, 0);


create table member( id varchar(20) primary key,
pw varchar(20) not null,
m_name varchar(20) not null,
phone varchar(13),
email varchar(30));

insert into member values('admin', '1234', '관리자', '010-1111-1111', 'admin@naver.com');

commit;