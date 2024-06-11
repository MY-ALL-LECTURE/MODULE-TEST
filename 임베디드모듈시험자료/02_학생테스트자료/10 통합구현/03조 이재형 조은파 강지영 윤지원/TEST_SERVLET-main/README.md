# STAY CONNECT(숙박예약웹) 프로젝트

DEVELOPMENT MOTIVATION
---
> 숙박 예약 사이트 -
> > -- 개발동기 
> > -- <br> 
 

HISTORY
---
[강지영]() | [윤지원]() | [이재형]() | [조은파]() | 


PLANS
---
 |LANGUAGE|PLAN|IMPLEMENT|DESCRIPTION|
 |-|-|-|-|
 |JAVA|2024/03/05 ~ 2024/04/23|-|-|
 |JSP/SERVLET|2024/04/24 ~ 2024/05/03|-|-|
 |SPRING STS3|-|-|-|
 |SPRING BOOT|-|-|-|



MEMBERERS
--- 
|NAME|ROLE|DETAILS|DESCRIPTION| 
|---|---|---|---|
|강지영|BN| reservation - 예약삭제 / 예약수정 |---|
|윤지원|BN| reservation - 예약생성 / 예약목록 |---|
|이재형|BN| member - 로그인 / 로그아웃 / 회원탈퇴 |---|
|조은파|BN| member - 회원등록 / 회원목록 |---|


시작가이드
---
#### REQUIREMENTS
---
- 
#### INSTALLATION
---
```
```
##### BAEKEND
---
```
```
##### FRONTEND
---
```
```

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
|/member/delete|GET/POST|id|boolean|member 탈퇴|
|/member/register|GET/POST|MemberDto|boolean|member 등록|
|/member/update|GET/POST|username, password, email, phone|boolean|member 정보 수정|
|/member/select|GET/POST|username|MemberDto|(관리자)member 상세 조회|
|/member/selectAll|POST|---|List<MemberDto>|(관리자)member 목록 조회|
|/member/login|GET/POST|username, password, session|boolean|member 로그인|
|/member/logout|GET|---|boolean|member 로그아웃|
|---|---|---|---|---|
|/reservation/add|GET/POST|ReservDto|boolean|숙소 예약|
|/reservation/list|GET/POST|userId|ReservDto|member가 예약한 숙소 목록 조회|
|/reservation/update|GET/POST|reservationDto|boolean|member가 예약한 정보 수정|
|/reservation/delete|GET/POST|user_id|boolean|member가 예약한 숙소 취소|
|---|---|---|---|---|

DEPENDENCIES LIST
---
|CAT|NAME|DESCRIPTION|LINK|-|-|
|-|-|-|-|-|-|
|FN|-|-|-|-|-|
|FN|-|-|-|-|-|
|BN|-|-|-|-|-|
|BN|-|-|-|-|-|
|DB|-|-|-|-|-|
|DEVOPS|-|-|-|-|-|


주요기능
---
-
-
-

ERD[stayconnect]
---
![image](https://github.com/CATERPILLAR-TEAM/TEST_SERVLET/assets/155939946/fbf64d7c-94e0-4700-b3b9-79e5172d0a4d)


FILE TREES[JSP/SERVLET]
--- 
```
TEST_SERVLET
├── build
│   └── classes
│       └── com
│           └── example
│               └── app
│                   ├── controller
│                   │   ├── FrontController.class
│                   │   ├── HomeController.class
│                   │   ├── SubController.class
│                   │   ├── member
│                   │   │   ├── MemberDeleteController.class
│                   │   │   ├── MemberLoginController.class
│                   │   │   ├── MemberLogoutController.class
│                   │   │   ├── MemberRegisterController.class
│                   │   │   ├── MemberSelectAllController.class
│                   │   │   ├── MemberSelectController.class
│                   │   │   └── MemberUpdateController.class
│                   │   └── reservation
│                   │       ├── ReservAddController.class
│                   │       ├── ReservDeleteController.class
│                   │       ├── ReservListController.class
│                   │       └── ReservUpdateController.class
│                   ├── domain
│                   │   └── common
│                   │       ├── dao
│                   │       │   ├── CommonDao.class
│                   │       │   ├── ConnectionPool.class
│                   │       │   ├── MemberDao.class
│                   │       │   ├── MemberDaoImpl.class
│                   │       │   ├── ReservDao.class
│                   │       │   ├── ReservDaoImpl.class
│                   │       │   ├── ReservationDao.class
│                   │       │   ├── ReservationDaoImpl.class
│                   │       │   ├── SessionDao.class
│                   │       │   ├── SessionDaoImpl.class
│                   │       │   └── common
│                   │       │       ├── CommonDao.class
│                   │       │       └── ConnectionPool.class
│                   │       ├── dto
│                   │       │   ├── Criteria.class
│                   │       │   ├── MemberDto.class
│                   │       │   ├── ReservDto.class
│                   │       │   ├── ReservationDto.class
│                   │       │   └── SessionDto.class
│                   │       └── service
│                   │           ├── MemberService.class
│                   │           ├── MemberServiceImpl.class
│                   │           ├── ReservService.class
│                   │           ├── ReservServiceImpl.class
│                   │           ├── ReservationService.class
│                   │           └── ReservationServiceImpl.class
│                   └── filter
│                       └── UTF_8_EncodingFilter.class
└── src
    └── main
        ├── java
        │   └── com
        │       └── example
        │           └── app
        │               ├── controller
        │               │   ├── FrontController.java
        │               │   ├── HomeController.java
        │               │   ├── SubController.java
        │               │   ├── member
        │               │   │   ├── MemberDeleteController.java
        │               │   │   ├── MemberLoginController.java
        │               │   │   ├── MemberLogoutController.java
        │               │   │   ├── MemberRegisterController.java
        │               │   │   ├── MemberSelectAllController.java
        │               │   │   ├── MemberSelectController.java
        │               │   │   └── MemberUpdateController.java
        │               │   └── reservation
        │               │       ├── ReservAddController.java
        │               │       ├── ReservDeleteController.java
        │               │       ├── ReservListController.java
        │               │       └── ReservUpdateController.java
        │               ├── domain
        │               │   └── common
        │               │       ├── dao
        │               │       │   ├── CommonDao.java
        │               │       │   ├── ConnectionPool.java
        │               │       │   ├── MemberDao.java
        │               │       │   ├── MemberDaoImpl.java
        │               │       │   ├── ReservDao.java
        │               │       │   ├── ReservDaoImpl.java
        │               │       │   ├── ReservationDao.java
        │               │       │   ├── ReservationDaoImpl.java
        │               │       │   ├── SessionDao.java
        │               │       │   ├── SessionDaoImpl.java
        │               │       │   └── common
        │               │       │       ├── CommonDao.java
        │               │       │       └── ConnectionPool.java
        │               │       ├── dto
        │               │       │   ├── Criteria.java
        │               │       │   ├── MemberDto.java
        │               │       │   ├── ReservDto.java
        │               │       │   ├── ReservationDto.java
        │               │       │   └── SessionDto.java
        │               │       └── service
        │               │           ├── MemberService.java
        │               │           ├── MemberServiceImpl.java
        │               │           ├── ReservService.java
        │               │           ├── ReservServiceImpl.java
        │               │           ├── ReservationService.java
        │               │           └── ReservationServiceImpl.java
        │               └── filter
        │                   └── UTF_8_EncodingFilter.java
        └── webapp
            ├── META-INF
            │   ├── MANIFEST.MF
            │   └── context.xml
            ├── WEB-INF
            │   ├── lib
            │   │   ├── HikariCP-5.1.0.jar
            │   │   ├── commons-logging-1.3.1.jar
            │   │   ├── jstl-1.2.jar
            │   │   ├── logback-classic-1.5.3.jar
            │   │   ├── mysql-connector-j-8.3.0.jar
            │   │   └── slf4j-api-2.0.12.jar
            │   ├── view
            │   │   ├── index.jsp
            │   │   ├── member
            │   │   │   ├── delete.jsp
            │   │   │   ├── list.jsp
            │   │   │   ├── login.jsp
            │   │   │   ├── read.jsp
            │   │   │   └── register.jsp
            │   │   └── reservation
            │   │       ├── add.jsp
            │   │       ├── delete.jsp
            │   │       ├── list.jsp
            │   │       └── update.jsp
            │   └── web.xml
            └── resources
                └── static
                    ├── css
                    │   ├── common.css
                    │   └── list.css
                    └── jsp
                        └── link.jsp
```
