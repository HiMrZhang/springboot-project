#!/bin/bash

if [ -z "$JAVA_HOME" ]; then
    export JAVA_HOME=/app/programs/jdk1.8.0_121
    export PATH=$JAVA_HOME/bin:$PATH
fi

cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`

SERVER_NAME="${env.application.name}"
SERVER_PORT="${env.server.port}"
if [ -z "$SERVER_NAME" ]; then
    SERVER_NAME=`hostname`
fi

PIDS=`netstat -lptn | grep $SERVER_PORT | awk '{print $7}' | cut -d \/ -f 1`
if [ -n "$PIDS" ]; then
    echo "ERROR: The $SERVER_NAME already started!"
    echo "PID: $PIDS"
    exit 1
fi


echo -e "Starting the $SERVER_NAME ...\c"
nohup java -Djava.ext.dirs=./lib -classpath config: ${env.mainClass} > /dev/null 2>&1 &

COUNT=0
while [ $COUNT -lt 1 ]; do    
    echo -e ".\c"
    sleep 1 
    COUNT=`netstat -lptn | grep $SERVER_PORT | grep java | wc -l`
    if [ $COUNT -gt 0 ]; then
        break
    fi
done

echo "OK!"
PIDS=`netstat -lptn | grep $SERVER_PORT | awk '{print $7}' | cut -d \/ -f 1`
echo "PID: $PIDS"
echo $PIDS > pid
