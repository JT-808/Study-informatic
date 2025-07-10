TARGETS = aufgabe1 client server
all: $(TARGETS)

aufgabe1: aufgabe1.o
	gcc -o aufgabe1 aufgabe1.o

aufgabe1.o: aufgabe1.c
	gcc -o aufgabe1.o aufgabe1.c

server: server.o
	gcc -o server.o

server.o: server.c helper.o communication.o
	gcc -o server.o server.c helper.o communication.o

client: client.o helper.o communication.o
	gcc -o client client.o helper.o communication.o
	
client.o: client.c helper.o communication.o
	gcc -o client.c helper.o communication.o

helper.o: helper.c
	gcc -o helper.o helper.c

communication.o: communication.c helper.o
	gcc -o communication.o communication.c helper.o
