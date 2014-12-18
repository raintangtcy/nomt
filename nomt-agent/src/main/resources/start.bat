@echo off
set cp=.;../lib;../bin;../config

echo cpcp is %cp%
SETLOCAL ENABLEDELAYEDEXPANSION
for %%i in (..\lib\*.jar) do (
   set cp=!cp!;%%i
)
echo cp is %cp%

java  -Xms128m -Xmx512m -Xss128k  -XX:+PerfBypassFileSystemCheck -XX:+AggressiveOpts -XX:+UseParallelGC -XX:+UseBiasedLocking -XX:NewSize=64m -classpath %cp% com.ericsson.cdr.main.Starter -p ../config
