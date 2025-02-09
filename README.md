# CURD-Project

### 패키지 구조
```
Ver_Demo/
├── src/                
│   ├── main/                                 # 애플리케이션 코드
│   │   ├── fronend/                          # 프론트엔드 관련 파일들
│   │   │   ├── public/                       # 공개 디렉토리 (index.html 등)
│   │   │   ├── src/                          # 소스 코드
│   │   │   │   ├── App.js                    # 메인 애플리케이션 파일
│   │   │   │   └── index.js                  # 엔트리 포인트
│   │   │   └── package.json                  # 프론트엔드 의존성 및 스크립트
│   │   │
│   │   ├── java/                             # 백엔드 관련 파일들
│   │   │   └──MyCRUD
│   │   │   │   └──Ver_Demo
│   │   │   │   │   │   ├── controller/       # 컨트롤러
│   │   │   │   │   │   ├── service/          # 서비스
│   │   │   │   │   │   ├── repository/       # 리포지토리
│   │   │   │   │   │   └── model/            # 모델
│   │   │   
│   │   └── resources/                        # 리소스 파일들
│   │   │   └── application.yml               
└── build.gradle                              # 백엔드 빌드 설정 파일
```

### 프로젝트 세팅
`application.yml`
```
spring:
  datasource:
    driver-class-name: [DB Class Name]
    url: [본인의 mysql-rds-endpoint]
    password: [DB password]

  jpa:
    hibernate:
      ddl-auto: update
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
    show-sql: true
```
