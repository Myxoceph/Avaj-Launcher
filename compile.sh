#!/bin/bash

SRC_DIR="src"
BIN_DIR="bin"

echo "Cleaning up old binaries."
rm -rf "$BIN_DIR"
mkdir "$BIN_DIR"

echo "Compiling Java source files."

find "$SRC_DIR" -name "*.java" > sources.txt
javac -d "$BIN_DIR" @sources.txt

rm sources.txt

if [ $? -eq 0 ]; then
	echo "Compilation successful."
	echo "Run the program using: java -cp $BIN_DIR Main <input_file>"
else
	echo "Compilation failed. Check the errors above."
	exit 1
fi
