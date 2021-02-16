# SpringBoot_2
계층형 게시판, 댓글과 OAuth2를 이용한 소셜 로그인 기능 구현해보기

## 소개
SpringBoot로 계층형 게시판과 계층형 댓글 기능을 구현합니다.
Security를 이용하여 인증, 인가 구현 및 OAuth2를 이용하여 소셜 로그인 기능까지 구현해봅니다.

## 목적
1. Spring, SpringBoot로 만들었던 게시판 복습
2. 기존의 게시판에서 더 깊게 들어가 계층형 게시판을 구현
3. 게시판, 댓글 좋아요 기능도 추가하여 테이블 구조 및 쿼리문 공부
4. OAuth2를 이용한 소셜 로그인 기능을 공부

## 작업일
day01
- 날짜 : 2021.02.09
- 내용 : DB 테이블 생성, 게시판 CURD 기능 구현

day02
- 날짜 : 2021.02.15
- 내용 : 
1. 계층형 게시판 구현(DB 설계, 로직 수정)

day03
- 날짜 : 2021.02.16
- 내용 : 
1. 계층형 댓글 구현(DB 설계, 로직 수정)
신규 댓글은 기존의 Form 태그 사용, 대댓글은 동적으로 Form태그 생성
2. 게시글 좋아요 기능 구현
테이블을 따로 생성, 중복 클릭을 방지하기 위해 sessionId를 저장하여 검사
view 페이지는 css만 이용하여 디자인 변경, DB에서 merge into문을 사용하여
데이터가 있으면 delete, 없으면 insert 되도록 toggle 식으로 기능 구현
