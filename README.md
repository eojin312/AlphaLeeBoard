# hachiboard-first

서블릿으로만 만드는 게시판 프로젝트. 기본기를 다지려 게시판을 간단한 CRUD 형식으로 만들어봤습니다.


# 게시판 테이블
```sql
CREATE TABLE `article` (
  `at_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `writer` varchar(30) NOT NULL,
  `title` varchar(30) NOT NULL,
  `at_tag` varchar(30) DEFAULT NULL,
  `contents` mediumtext ,
  `create_time` datetime NOT NULL,
  `read_count` bigint(20) unsigned DEFAULT '0',
  `recommend_count` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`at_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
```
# 첫 게시판만들기 과제
intellij같은 도구없이 javac로 컴파일
.java -> .class
JVM
OS에 상관없이 byte코드를 실행할 수 있다.

**servlet**
- javac로 컴파일된 class파일들을
- tomcat에 카피해넣고
- 웹페이지에서 호출해봄
- war로 묶어서 돌려보기도

**DB도 알아야한다!!**

SQL
-> Standard Query Language

RDB
->관계형 데이터베이스

1. mysql 설치
2. 쿼리 연습

**게시판 DB설계**

게시글 CRUD
회원 CRUD
  
# 회고
- 서블릿 맵핑이 번거롭고 , 실수가 많았다.
- JDBC 관련 코드 중 중복되는 코드가 많다.
- 프로그램이 복잡해지면 관리가 어려울 것 같다.
- 개발자로서 길을 걷고 첫 프로젝트이다.
- 아쉽게도 커밋 메시지와 커밋 블로그 글 작성의 중요함을 나중에 알았습니다. 한창 게시판을 개발할 땐 커밋만 하고 메시지를 적지 않았던 게 후회가 됩니다.



  
