#!/bin/sh
#---------------
#2016-5-6 15:21:18
#created by caoxiaoming 

JAVA_OPTS="-Xms56m -Xmx128m"

APP_HOME_BIN=$(cd "$(dirname "$0")"; pwd)

APP_NAME="simple-task"

APP_HOME=$APP_HOME_BIN/..

APP_MAIN=com.lngtop.app.App

APP_HISTORY_MAIN=com.lngtop.app.History

CLASSPATH="$APP_HOME_BIN/simple-task-1.0-SNAPSHOT.jar"

cd $APP_HOME

for taskJar in "$APP_HOME"/lib/*.jar;  
do  
   CLASSPATH="$CLASSPATH":"$taskJar"  
done


taskPID=0


getTaskPID(){  
    javaps=`$JAVA_HOME/bin/jps -l | grep $APP_MAIN`  
    if [ -n "$javaps" ]; then  
        taskPID=`echo $javaps | awk '{print $1}'`  
    else  
        taskPID=0  
    fi  
}

start(){  
    getTaskPID  
    if [ $taskPID -ne 0 ]; then  
        echo "$APP_NAME already started(PID=$taskPID)"  
    else  
        echo -n "Starting $APP_NAME "  
        nohup $JAVA_HOME/bin/java $JAVA_OPTS -classpath $CLASSPATH $APP_MAIN &  
        getTaskPID  
        if [ $taskPID -ne 0 ]; then  
            echo "(PID=$taskPID)...[Success]"  
        else  
            echo "[Failed]"  
        fi  
    fi  
}

historyTask(){
    $JAVA_HOME/bin/java -classpath $CLASSPATH $APP_HISTORY_MAIN
}

stop(){  
    getTaskPID  
    if [ $taskPID -ne 0 ]; then  
        echo -n "Stopping $APP_NAME(PID=$taskPID)..."  
        kill -9 $taskPID  
        if [ $? -eq 0 ]; then  
            echo "[Success]"  
        else  
            echo "[Failed]"  
        fi  
        getTaskPID  
        if [ $taskPID -ne 0 ]; then  
           stop 
        fi  
    else  
        echo "$APP_NAME is not running"  
    fi  
}



case "$1" in
   'start')
     start
     ;;
   'stop')
     stop
     ;;
    'history')
     historyTask
     ;;   
  *)
     echo "Usage: $0 {start|stop|history}"
     exit 1
     ;;
esac

exit 0
