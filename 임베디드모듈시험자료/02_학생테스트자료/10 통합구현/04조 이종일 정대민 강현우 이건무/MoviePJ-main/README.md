# 영화 통합 예매 웹 프로젝트

DEVELOPMENT MOTIVATION
---
> 영화 통합 예매 사이트
> > 영화 예매를 하려면 CGV, 롯데시네마 등 각 사이트에 들어가서 예매를 해야하는 불편함이 있는데, 이를 하나의 플랫폼에서 조회하고 예매할 수 있는 서비스를 개발하고 싶었습니다.
> > 이런 서비스는 사용자가 다양한 영화관의 상영 시간표, 좌석 상태, 가격 등을 비교하고 선택하는데 도움을 줄 것입니다.
> > 또, 사용자들의 편의를 위해 영화 예매 과정을 간편하고 효율적으로 만들고, 다양한 옵션과 혜택을 제공하여 사용자들에게 더 나은 경험을 제공할 것입니다.<br> 

branch
---
[이종일](http://github.com/jong12mm/TESTREPO/tree/이종일) | [정대민](http://github.com/jong12mm/TESTREPO/tree/정대민) | [강현우](http://github.com/jong12mm/TESTREPO/tree/강현우) | [이건무](http://github.com/jong12mm/TESTREPO/tree/이건무) | 


PLANS
---
 |LANGUAGE|PLAN|IMPLEMENT|DESCRIPTION|
 |-|-|-|-|
 |JAVA|-|-|-|
 |JSP/SERVLET|2024/04/24 ~ 2024/04/28|-|-|
 |SPRING STS3|2024/04/29 ~ 2024/05/03|-|-|
 |SPRING BOOT|-|-|-|
 
 

MEMBERS
--- 
|NAME|ROLE|DETAILS|DESCRIPTION| 
|---|---|---|---|
|Together|---| FrontController / Document 관리 / Dependencies  관리 |---|
|이종일|조장| USER - 회원가입 / 회원탈퇴 / 영화 C.U.|---|
|정대민|조원| USER - 회원가입 / 회원탈퇴 / 영화 R.D.|---|
|강현우|조원| 유저공통 - 로그인 / 로그아웃|---|
|이건무|조원| MANAGER 회원가입 회원탈퇴|---|

SKILLS
---

#### FN
---
<img src="https://img.shields.io/badge/HTML5-3366CC?style=for-the-badge&logo=htmlacademy&logoColor=white"> <img src="https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/JAVASCRIPT-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white"> <img src="https://img.shields.io/badge/JQUERY-0769AD?style=for-the-badge&logo=jquery&logoColor=white"> 


#### BN
---
<img src="https://img.shields.io/badge/JAVA-005571?style=for-the-badge&logo=doubanread&logoColor=white"> <img src="https://img.shields.io/badge/JSP-1E8CBE?style=for-the-badge&logo=doubanread&logoColor=white"> <img src="https://img.shields.io/badge/SERVLET-4B4B77?style=for-the-badge&logo=doubanread&logoColor=white"> <img src="https://img.shields.io/badge/SPRING-STS3-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/SPRINGBOOT-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> 

#### DATABASE
---
<img src="https://img.shields.io/badge/MYSQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white">  


#### DEVOPS
---
<img src="https://img.shields.io/badge/GIT-F05032?style=for-the-badge&logo=git&logoColor=white"> <img src="https://img.shields.io/badge/GITHUB-181717?style=for-the-badge&logo=github2&logoColor=white"> <img src="https://img.shields.io/badge/AWS-EC2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white"> <img src="https://img.shields.io/badge/DOCKER-2496ED?style=for-the-badge&logo=docker&logoColor=white"> <img src="https://img.shields.io/badge/DOCKERHUB-2496ED?style=for-the-badge&logo=docker&logoColor=white"> <img src="https://img.shields.io/badge/JENKINS-D24939?style=for-the-badge&logo=jenkins&logoColor=white"> 


END POINT DOC
---
|URI|REQUEST METHOD|REQUEST PARAMETER TYPE|RESPONSE VALUE TYPE|DESCRIPTION|
|---|---|---|---|---|
|/movie/add|POST|movieId : String<br>movieTitle : String<br>moviegenre : String<br>reserv : String<br>cgv : String<br>Time : String|JSON|새로운 영화 추가|
|/movie/list|GET|type : String<br>keyword : String<br>pageNo : String|JSON|영화 목록 조회|
|/movie/read|GET|---|JSON|영화 상세 정보 조회|
|/movie/update|POST|updateIdStr : String<br>movieTitle : String<br>moviegenre : String<br>reserv : String<br>cgv : String<br>time : String|JSON|영화 정보 업데이트|
|/movie/delete|POST|type : String<br>keyword : String<br>pageNo : String<br>deleteIdStr : String|JSON|영화 삭제|
|/user/add|POST|username : String<br>password : String|JSON|새로운 사용자 추가|
|/user/read|GET|---|JSON|사용자 상세 정보 조회|
|/user/update|POST|---|JSON|사용자 정보 업데이트|
|/user/delete|POST|---|JSON|사용자 삭제|
|/login|POST|username : String<br>password : String|JSON|사용자 로그인|
|/logout|POST|None|JSON|사용자 로그아웃|

DEPENDENCIES LIST
---
|CAT|NAME|DESCRIPTION|LINK|
|-|-|-|-|
|BN|Commons Logging|로깅 추상화 레이어|[Commons Logging](https://commons.apache.org/proper/commons-logging/)|
|BN|HikariCP|고성능 자바 SQL 데이터베이스 커넥션 풀|[HikariCP](https://github.com/brettwooldridge/HikariCP)|
|BN|JSTL|JSP 태그 라이브러리|[JSTL](https://mvnrepository.com/artifact/javax.servlet/jstl)|
|BN|Logback Classic|로깅 프레임워크 (SLF4J의 구현체 중 하나)|[Logback](https://mvnrepository.com/artifact/ch.qos.logback/logback-classic)|
|BN|MySQL Connector/J|MySQL 데이터베이스 연결을 위한 자바 드라이버|[MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)|
|DB|SLF4J API|간단한 로깅 파사드 for Java (로깅 API 추상화 레이어)|[SLF4J](https://www.slf4j.org/)|
|SEC|Spring Security Crypto|스프링 시큐리티의 암호화 모듈|[Spring Security Crypto](https://mvnrepository.com/artifact/org.springframework.security/spring-security-crypto)|

ERD[MovieDb]
---
![image](https://github.com/jong12mm/TESTREPO/assets/155033238/12316ee5-4067-4798-b24a-7c3d0fddb801)


MVC[MovieDb]
---
![image](https://github.com/jong12mm/MoviePJ/assets/155033238/2c3fda5b-fd1e-47a7-b114-e2ec58a77ff6)




FILE TREES[JSP/SERVLET]
--- 
```
C:.
│  .classpath
│  .gitignore
│  .project
│  정리.txt
│
├─.settings
│  .jsdtscope
│  org.eclipse.core.resources.prefs
│  org.eclipse.jdt.core.prefs
│  org.eclipse.wst.common.component
│  org.eclipse.wst.common.project.facet.core.xml
│  org.eclipse.wst.jsdt.ui.superType.container
│  org.eclipse.wst.jsdt.ui.superType.name
│
└─src
    └─main
        ├─java
        │  └─com
        │      └─example
        │          └─app
        │              ├─controller
        │              │  │  FrontController.java
        │              │  │  HomeController.java
        │              │  │  SubController.java
        │              │  │
        │              │  └─user
        │              │  │  │  UserLoginController.java
        │              │  │  │  UserLogoutController.java
        │              │  │  │  UserAddController.java
        │              │  │  │  UserReadController.java
        │              │  │  │  UserUpdateController.java
        │              │  │  │  UserDeleteController.java
        │              │  │
        │              │  │
        │              │  └─movie
        │              │  │  │  MovieAddController.java
        │              │  │  │  MovieDeleteController.java
        │              │  │  │  MovieListController.java
        │              │  │  │  MovieReadController.java
        │              │  │  │  MovieUpdateController.java
        │              │
        │              ├─domain
        │              │  ├─common
        │              │  │  ├─dao
        │              │  │  │  ├─common
        │              │  │  │  │  CommonDao.java
        │              │  │  │  │  ConnectionPool_ByHikari.java
        │              │  │  │  │  ConnectionPool.java
        │              │  │  │  
        │              │  │  │  MovieDao.java
        │              │  │  │  MovieDaoImpl.java
        │              │  │  │  SessionDao.java
        │              │  │  │  SessionDaoImpl.java
        │              │  │  │  UserDao.java
        │              │  │  │  UserDaoImpl.java
        │              │  │  │  
        │              │  │  │
        │              │  │  ├─dto
        │              │  │  │  Criteria.java
        │              │  │  │  MovieDto.java
        │              │  │  │  PageDto.java
        │              │  │  │  SessionDto.java
        │              │  │  │  UserDto.java
        │              │  │  │
        │              │  │  └─service
        │              │  │     │    MovieService.java
        │              │  │     │    MopvieServiceImpl.java
        │              │  │     │    UserService.java
        │              │  │     │    UserServiceImpl.java
        │              │  │
        │              │
        │              └─filter
        │                 │  UTF_8_EncodingFilter.java
        │              
        │
        └─webapp
            ├─META-INF
            │      context.xml
            │      MANIFEST.MF
            │
            ├─resources
            │  └─static
            │      │
            │      ├─css
            │      │  │  common.css
            │      │  │  login.css
            │      │  │  
            │      │  ├─movie
            │      │  │  │  list.css
            │      │  │  │  read.css
            │      │  │  │  update.css
            │      │  │
            │      │  └─user
            │      │     │  add.css
            │      │     │  myinfo.css
            │      │     │
            │      │     ├─admin
            │      │     │  │  myinfo.css
            │      │     └─member
            │      │        │  myinfo.css
            │      │
            │      ├─js
            │      │  │  common.js
            │      │  │  index.js
            │      │  │
            │      │  └─movie
            │      │     │  list.js
            │      │
            │      └─jsp
            │         │    footer.jsp
            │         │    link.jsp
            │         │    nav.jsp
            │         │    topHeader.jsp
            │
            └─WEB-INF
                │  web.xml
                │
                ├─lib
                │  commons-logging-1.3.1.jar
                │  HikariCP-5.1.0.jar
                │  jstl-1.2.jar
                │  logback-classic-1.5.3.jar
                │  mysql-connector-j-8.3.0.jar
                │  slf4j-api-2.0.12.jar
                │  spring-security-crypto-3.2.10.RELEASE.jar
                │
                └─view
                    │  index.jsp
                    │  login.jsp
                    │  template.jsp
                    │  template_aside.jsp
                    │
                    ├─movie
                    │  │  add.jsp
                    │  │  delete.jsp
                    │  │  list.jsp
                    │  │  update.jsp
                    │
                    │
                    └─user
                       │  add.jsp
```

