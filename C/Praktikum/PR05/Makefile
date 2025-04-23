CC = gcc
CFLAGS = -g -Wall -Wextra

TARGET = copy.out

# Standardziel
all: $(TARGET)

# Executable bauen
$(TARGET): copy_reg.o copy.o regular.o
	$(CC) $(CFLAGS) -o $(TARGET) copy_reg.o copy.o regular.o


# Kompilierungsregeln

copy_reg.o: copy_reg.c copy.h
	$(CC) $(CFLAGS) -c copy_reg.c

copy.o: copy.c copy.h
	${CC} ${CFLAGS} -c copy.c

regular.o: regular.c copy.h
	$(CC) $(CFLAGS) -c regular.c

# Aufräumen
clean:
	rm -f *.o *.out
