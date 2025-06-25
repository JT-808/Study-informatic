# Compiler und Flags
CC = gcc
CFLAGS = -Wall -Wextra -g

# Programme
TARGETS = para Aufgabe1a

# Quellcode-Zuordnung (jede .c-Datei zu ihrem Target)
para: parallel.c
	$(CC) $(CFLAGS) -o para parallel.c

1a: 1a.c
	$(CC) $(CFLAGS) -o Aufgabe1a Aufgabe1a.c

# All-Build-Ziel
all: $(TARGETS)

# Clean-Ziel
clean:
	rm -f $(TARGETS)
