#!/bin/bash
cd `dirname $0`
BIN_DIR=`pwd`
cd ..
PID=`cat pid`
SERVER_NAME="${env.application.name}"
echo "Stopping the $SERVER_NAME ..."
kill $PID > /dev/null 2>&1
echo -e "  Waiting PIDS to quit ...\c"
COUNT=0
while [ $COUNT -lt 1 ]; do
    echo -e ".\c"
    sleep 1
    COUNT=1
    PID_EXIST=`ps -f -p $PID | grep java`
    if [ -n "$PID_EXIST" ]; then
        COUNT=0
        break
    fi
done

echo "OK!"