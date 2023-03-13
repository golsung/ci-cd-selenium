#!/usr/bin/env bash

# 현재 구동 중인 애플리케이션 pid 확인
CURRENT_PID=$(pgrep -f ./calc.jar)

# 프로세스가 켜져 있으면 종료
if [ -z $CURRENT_PID ]; then
   echo "현재 실행중인 애플리케이션이 없습니다"
else
  kill -15 $CURRENT_PID
fi