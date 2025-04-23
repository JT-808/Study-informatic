CC = gcc
CFLAGS = -g -Wall -Wextra

TARGET = main.out

# Standardziel
all: $(TARGET)

# Executable bauen
$(TARGET): copy_reg.o copy.o regular.o
	$(CC) $(CFLAGS) -o $(TARGET) copy_reg.o copy.o regular.o


# Kompilierungsregeln

copy_reg.o: copy_reg.c fileCopy.h
	$(CC) $(CFLAGS) -c copy_reg.c

copy.o: copy.c 
	${CC} ${CFLAGS} -c copy.c

regular.o: regular.c 
	$(CC) $(CFLAGS) -c regular.c

# Aufräumen
clean:
	rm -f *.o *.out
