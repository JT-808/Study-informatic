CC = gcc
CFLAGS = -g -Wall -Wextra -fsanitize=address

PROGS = 1_error 2_fork 3_exec

all: $(PROGS)

$(PROGS): %: %.o
	${CC} ${CFLAGS} -o $@ $^

%.o: %.c
	${CC} ${CFLAGS} -c $<

clean:
	rm -f *.o $(PROGS)
