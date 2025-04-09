main: main.o kreis.o
	gcc -g -o prog main.o kreis.o

struct: struct.o
	gcc -g -o struct struct.c

main.o: main.c
	gcc -g -Wall -c main.c

kreis.o: kreis.c kreis.h
	gcc -g -Wall -c kreis.c

struct.o: struct.c
	gcc -g -Wall -c struct.c

clean:
	rm -f *.o main
