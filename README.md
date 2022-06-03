# week4_spring
주특기 숙련 주차 과제

| 내용 | method | API | request | response
| :-----------: | :------------: | :------------: | :------------: | :------------: |
| 로그인   |  POST   |  /user/login  | username <br> password | UserDetailsImpl userDetails <br> boolean loginStatus <br> HttpStatus 및 메시지 |
| 회원가입 |  POST   |  /user/signup  | username <br> password <br> email <br> admin <br> adminToken | HttpStatus 및 메시지 |
| 전체게시글 조회 |  GET   |  /api/posts/{id}  | id | List`<Post>` |
| 상세게시글 조회 |  GET   |  /api/detail/{id}  | id | UserDetailsImpl userDetails <br> Post post <br> boolean loginStatus |
| 게시글 작성 |  POST   |  /api/posts  | username <br> title <br> content <br> password | Post post |
| 게시글 수정 |  PUT   |  /api/posts/{id}  | id <br> title <br> content | Long id |
| 게시글 삭제 |  DELETE   |  /api/posts/{id}  | id  | Long id |
| 게시글 수정 삭제 시 <br> 비밀번호 확인 |  GET   |  /api/posts/check  | id <br> password | boolean check |
| 댓글 조회 |  GET   |  /api/comments/{postNum}  | postNum <br> userDetails | List`<Comment>` |
| 댓글 작성 |  POST   |  /api/comments  | username <br> content <br> postNum | Comment comment |
| 댓글 수정 |  PUT   |  /api/comments/{id}  | id <br> content | Long id |
| 댓글 삭제 |  DELETE   |  /api/comments/{id}  | id  | Long id |
| 좋아요 갯수 업데이트 |  POST   |  /api/heart/update | username <br> commentId <br> action  | Long count |
