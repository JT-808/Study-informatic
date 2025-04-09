
main: kreis.o flaeche.o
	gcc -g -o prog kreis.o flaeche.o
	
# löschen der .o dateien
	rm -f *.o


kreis.o: kreis.c
	gcc -g -Wall -c kreis.c

flaeche.o: flaeche.c flaeche.h
	gcc -g -Wall -c flaeche.c


# mit make clean aufrufbar
clean:
	rm -f *.o kreis