# Compiler und Flags
CC = gcc
CFLAGS = -Wall -Wextra -g

# Zielprogrammname
TARGET = signal_handler

# Quellcode-Dateien
SRC = Aufgabe_1.c

# Build-Ziel
$(TARGET): $(SRC)
	$(CC) $(CFLAGS) -o $(TARGET) $(SRC)

# Clean-Ziel
clean:
	rm -f $(TARGET)
