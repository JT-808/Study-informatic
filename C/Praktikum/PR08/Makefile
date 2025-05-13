CC = gcc
CFLAGS = -g -Wall -Wextra -fsanitize=address

PROGS = fork fork2 starter

all: $(PROGS)

$(PROGS): %: %.o
	${CC} ${CFLAGS} -o $@ $^

# Kompilierungsregeln

%.o: %.c
	${CC} ${CFLAGS} -c $<

clean:
	rm -f *.o $(PROGS)
