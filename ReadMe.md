mkdir out

javac -cp "path\to\mysql-connector-java-8.0.44.jar" -d out \src\Database\*.java src\MySQL\*.java src\Oracle\*.java src\SQLServer\*.java src\*.java

java -cp "out;path\to\mysql-connector-java-8.0.44.jar" Main