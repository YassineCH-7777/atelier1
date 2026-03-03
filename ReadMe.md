
mkdir out

javac -cp "lib/*" -d out src\Database\*.java src\MySQL\*.java src\Oracle\*.java src\SQLServer\*.java src\*.java

java -cp "out;lib/*" Main

