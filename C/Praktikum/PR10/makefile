CC      = gcc
CFLAGS  = -Wall -O2

TARGETS = server client

SRC_server = ring_server.c
SRC_client = ring_client.c

OBJ_server = $(SRC_server:.c=.o)
OBJ_client = $(SRC_client:.c=.o)

all: $(TARGETS)

server: $(OBJ_server)
	$(CC) $(CFLAGS) -o $@ $^

client: $(OBJ_client)
	$(CC) $(CFLAGS) -o $@ $^

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -f $(TARGETS) *.o

.PHONY: all clean
