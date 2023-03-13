#!/usr/bin/env bash

cp ./build/libs/selenium-proj-0.0.1-SNAPSHOT.jar ./calc.jar

# jar 파일 실행
nohup java -jar ./calc.jar &

