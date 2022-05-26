create table board(seq number primary key,
title varchar2(100) not null,
content varchar2(800) not null,
nickname varchar2(20),
regdate date,
visited number
);

select * from board;
select * from board where seq=2;

insert into board values(1, '샘플 글 제목1입니다.', '여기는 샘플 글1에 대한 내용입니다.', 'admin', sysdate, 0);
insert into board values((select nvl(max(seq), 0)+1 from board), '샘플2 제목입니다.', '샘플글 2 여기는 샘플 글1에 대한 내용입니다.', 'admin', sysdate, 0);
insert into board values((select nvl(max(seq), 0)+1 from board), '샘플3 제목입니다.', '샘플글 3 여기는 샘플 글1에 대한 내용입니다.', 'admin', sysdate, 0);
insert into board values((select nvl(max(seq), 0)+1 from board), '샘플4 제목입니다.', '샘플글 4 여기는 샘플 글1에 대한 내용입니다.', 'admin', sysdate, 0);
insert into board values((select nvl(max(seq), 0)+1 from board), '샘플5 제목입니다.', '샘플글 5 여기는 샘플 글1에 대한 내용입니다.', 'admin', sysdate, 0);

update board set title=?, content=?, nickname=?, regdate=sysdate where seq=?;

delete from board where seq=?;

commit;

create table member(userid varchar2(20) primary key,
userpw varchar2(300) not null,
email varchar2(100) not null,
tel varchar2(20) not null,
addr1 varchar2(200),
addr2 varchar2(100),
postcode varchar2(10),
regdate date default sysdate,
birth date,
userpoint number default 100,
visited number default 0
);


insert into member values('admin', '1234', 'admin@naver.com', '010-1111-1111', '주소1', '주소2',
'', sysdate, '', '', '');

select to_char(regdate, 'yyyy-MM-dd HH24:mi:ss') as cdate from member;
-- alter table modify birth varchar2();

commit;
select * from member;



create table goods(gno number primary key,
gcategory varchar2(100),
gname varchar2(100),
gprice number,
gcolor varchar2(40),
amount number,
gcontent varchar2(1000),
gimage varchar2(1000),
regdate date);

delete from goods where gno=?

update goods set gcategory=?, gname=?, gprice=?, gcolor=?, amount=?, gcontent=?, gimage=?, regdate=sysdate where gno=?;

select * from goods where gno=?
 
select * from goods where gcategory=? and gno=?

