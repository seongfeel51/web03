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

alter table member add username varchar2(50);

select to_char(regdate, 'yyyy-MM-dd HH24:mi:ss') as cdate from member;
-- alter table modify birth varchar2();

commit;
select * from member;

-- 상품 테이블
create table goods(gno number primary key,  -- 상품코드
gcategory varchar2(100),    -- 카테고리
gname varchar2(100),    -- 상품명
gprice number,  -- 가격
gcolor varchar2(40),    -- 색상
amount number,  -- 수량
gcontent varchar2(1000),    -- 설명
gimage varchar2(1000),  -- 이미지
regdate date);  -- 등록일

-- 더미 데이터 추가
insert into goods values ();

-- 해당 상품 제거
delete from goods where gno=?

-- 해당 상품 정보 수정
update goods set gcategory=?, gname=?, gprice=?, gcolor=?, amount=?, gsize=?, gcontent=?, gimage=?, best=?, regdate=sysdate where gno=?   

-- 해당 상품 검색
select * from goods where gno=?;
select * from goods where gcategory=? and gno=?;


-- 장바구니
create table basket(bno number primary key, -- 장바구니번호
userid varchar2(20),    -- 사용자아이디
gno number,             -- 상품코드
gcolor varchar2(40),    -- 색상
amount number,          -- 수량
gsize varchar2(40),     -- 크기
bdate Date);            -- 장바구니 담긴 날짜

-- 장바구니 담기
insert into basket values ();

-- 장바구니 정보 변경
update basket set gno=?, gcolor=?, amount=?, gsize=?, bdate=sysdate where bno=?;

-- 장바구니 삭제
delete from basket where bno=?;



-- 주문
create table payment(ono number primary key, -- 결제번호
    paytype varchar2(20),   -- 결제방식
    payno varchar2(30),     -- 결제카드번호
    money number,           -- 결제금액
    sdate date,             -- 결제일
    gno number,             -- 상품코드
    amount number,          -- 수량
    userid varchar2(20),    -- 사용자아이디
	rname varchar2(30),     -- 수신자명
    tel varchar2(20),       -- 수신자전화번호
    addr1 varchar2(200),    -- 수신자 기본주소
    addr2 varchar2(100),    -- 수신자 상세주소
    postcode varchar2(10),  -- 수신자 우편번호
    transno varchar2(50),   -- 배송코드
    transco varchar2(50),   -- 배송회사
    rstatus varchar2(20),   -- 수신상태
    rdate date,             -- 도착일
	memo varchar2(100)     -- 메모
);

select * from payment;










