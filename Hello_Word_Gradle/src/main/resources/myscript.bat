echo "Executing my shell script"

set JAVA_HOME=C:\Program Files\Java\jre7
set LIB_DIR=D:\gradle_projects\Hello_Word_Gradle\build\libs
set CLASSPATH=C:\Program Files\Java\jdk1.7.0_79\bin
set CLASSPATH=%CLASSPATH%;%LIB_DIR%\Hello_Word_Gradle.jar

"%JAVA_HOME%\bin\java" -Xms128m -Xmx384m -Xnoclassgc org.gradle.HelloWordGradle