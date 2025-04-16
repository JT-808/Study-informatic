CC = gcc
CFLAGS = -g -Wall -Wextra

prog1: prog1.o
	${CC} ${CFLAGS} -o prog1 prog1.o

prog2: prog2.o
	${CC} ${CFLAGS} -o prog2 prog2.o

prak4: prak4.o
	${CC} ${CFLAGS} -o prak4 prak4.o

prog1.o: prog1.c
	${CC} ${CFLAGS} -c prog1.c

prog2.o: prog2.c
	${CC} ${CFLAGS} -c prog2.c

prak4.o: prak4.c
	${CC} ${CFLAGS} -c prak4.c

clean:
	rm -f *.o prog1 prog2
