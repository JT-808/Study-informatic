CC = gcc
CFLAGS = -g -Wall -Wextra

# Ziel: pr4
pr4: pr4.o sort.o
	${CC} ${CFLAGS} -o pr4.out pr4.o sort.o

# Ziel: pr4a3
pr4a3: pr4a3.o sort.o
	${CC} ${CFLAGS} -o pr4a3.out pr4a3.o sort.o

# Kompilierungsregeln
pr4.o: pr4.c
	${CC} ${CFLAGS} -c pr4.c

pr4a3.o: pr4a3.c
	${CC} ${CFLAGS} -c pr4a3.c

sort.o: sort.c sort.h
	${CC} ${CFLAGS} -c sort.c

# Aufräumen
clean:
	rm -f *.o *.out
