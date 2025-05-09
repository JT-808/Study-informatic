CC = gcc
CFLAGS = -g -Wall -Wextra

# Ziel: status
status: status.o
	${CC} ${CFLAGS} -o status.out status.o

# Ziel: status2
status2: status2.o
	${CC} ${CFLAGS} -o status2.out status2.o


# Kompilierungsregeln
status.o: status.c
	${CC} ${CFLAGS} -c status.c

status2.o: status2.c
	${CC} ${CFLAGS} -c status2.c


# Aufräumen
clean:
	rm -f *.o *.out
