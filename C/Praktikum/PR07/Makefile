CC = gcc
CFLAGS = -g -Wall -Wextra

MCOPY_TARGET = mcopy.out
PATH_TARGET  = path.out

# Standardziel
all: $(MCOPY_TARGET) $(PATH_TARGET)

# Build-Ziele
$(MCOPY_TARGET): mcopy.o
	$(CC) $(CFLAGS) -o $@ mcopy.o

$(PATH_TARGET): path.o getFullPathName.o
	$(CC) $(CFLAGS) -o $@ path.o getFullPathName.o

# Kompilierungsregeln
mcopy.o: mcopy.c
	$(CC) $(CFLAGS) -c $<

path.o: path.c
	$(CC) $(CFLAGS) -c $<

getFullPathName.o: getFullPathName.c
	$(CC) $(CFLAGS) -c $<

# Aufräumen
clean:
	rm -f *.o *.out
