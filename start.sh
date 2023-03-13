#!/usr/bin/env bash

cp ./build/libs/selenium*.jar ./calc.jar

# jar 파일 실행
nohup java -jar ./calc.jar &

