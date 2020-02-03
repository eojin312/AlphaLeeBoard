# hachiboard-first
알파리 게시판


서블릿으로만 만드는 게시판 통해 기본기를 다지며 게시판을 CRUD (Create Read Update Delete) 형식으로 만들어봤습니다.
아쉽게도 커밋 메시지와 커밋 블로그 글 작성의 중요함을 나중에 알았습니다.
한창 게시판을 개발할 땐 커밋만 하고 메시지를 적지 않았던 게 후회가 됩니다.

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

# Create

배운점
 - 손에 익숙하지 않은 insert 문을 능숙하게 다루게 되었습니다.
 
아쉬운 부분
  - 당시 세션을 배우지 못해서 글을 작성하려고 하면 작성자를 따로 기입해야하는 형식이었던 것입니다.
  - 정규화가 제대로 되어있지 않았습니다
  
# Read

배운점
  
아쉬운 부분
  - where 절을 이용한 조건문이 상세하지않아서 아쉬웠습니다.
  - Ajax 를 이용해서 댓글 기능을 추가하고싶었습니다. 하지만 당시 Ajax 를 능숙하게 다를 줄 몰라서 추가하지 못한 것이 아쉬었습니다.
  - 위와 같이 조건을 좀 더 많이 걸어놔서 정교한 쿼리로 많은 기능을 하고싶었습니다. 정교하지 않은 부분이 아쉽습니다.
  
# Update

아쉬운 부분

  - 수정 후 submit 을 하면 한 번 더 물어보는 기능을 넣지 못한 것이 아쉽습니다.
  - 작성자 말고는 수정할 수 없게 코드를 짜야하는데 상세하게 하지 못한 점이 아쉽습니다.
  
# Delete

  - DELETE 쿼리가 아닌 UPDATE 문으로 글 타입을 Y 를 N 로 바꾸는 것을 배웠습니다.
