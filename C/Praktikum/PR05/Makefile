CC = gcc
CFLAGS = -g -Wall -Wextra

# Ziel: copy
copy: copy.o
	${CC} ${CFLAGS} -o copy.out copy.o


# Kompilierungsregeln
copy.o: copy.c
	${CC} ${CFLAGS} -c copy.c

# Aufräumen
clean:
	rm -f *.o *.out
