# 1. Amazon Corretto 21 기반 이미지 사용
FROM amazoncorretto:21.0.6-alpine

# 2. JAR 파일을 컨테이너 내부로 복사 (빌드된 JAR 파일명 확인 필요)
COPY build/libs/core-0.0.1-SNAPSHOT.jar /app/core.jar

# 3. 작업 디렉토리 설정
WORKDIR /app

# 4. 실행 명령
ENTRYPOINT ["java", "-jar", "core.jar"]
