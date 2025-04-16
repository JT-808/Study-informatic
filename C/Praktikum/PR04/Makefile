CC = gcc
CFLAGS = -g -Wall -Wextra 


pr4: pr4.o
	${CC} ${CFLAGS} -o pr4.out pr4.o

# löschen der .o dateien
	rm -f *.o


pr4.o: pr4.c
	${CC} ${CFLAGS} -c pr4.c


clean:
	rm -f *.o prog1 prog2
