#!/bin/bash

echo "> Build 파일 복사"

cp /home/ubuntu/app/step2/zip/*.jar /home/ubuntu/app/step2/

echo "> 현재 구동중인 애플리케이션 pid 확인"

echo "현재 구동중인 어플리케이션 pid: $(pgrep -fl deploy | grep jar | awk '{print $1}')"

if [ -z "$(pgrep -fl deploy | grep jar | awk '{print $1}')" ]; then
    echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
    echo "> kill -15 $(pgrep -fl deploy | grep jar | awk '{print $1}')"
    kill -15 $(pgrep -fl deploy | grep jar | awk '{print $1}')
    sleep 5
fi

echo "> 새 어플리케이션 배포"

echo "> JAR Name: $(ls -tr /home/ubuntu/app/step2/*.jar | tail -n 1)

echo "> $(ls -tr /home/ubuntu/app/step2/*.jar | tail -n 1) 에 실행권한 추가"

chmod +x $(ls -tr /home/ubuntu/app/step2/*.jar | tail -n 1) # Jar 파일은 실행 권한이 없는 상태이므로 권한 부여

echo "> $(ls -tr /home/ubuntu/app/step2/*.jar | tail -n 1) 실행"

nohup java -jar \
    -Dspring.config.location=classpath:/application.properties,classpath:/application-real.properties,/home/ubuntu/app/application-oauth.properties,/home/ubuntu/app/application-real-db.properties \
    -Dspring.profiles.active=real \
    $(ls -tr /home/ubuntu/app/step2/*.jar | tail -n 1) > /home/ubuntu/app/step2/nohup.out 2>&1 &