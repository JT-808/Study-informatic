org 100h
; ------------------------------------------------------------------------------------

leer equ 00h
eins equ 00000110b
null equ 10111111b

mov al, leer

out 90h, al
out 92h, al
out 94h, al
out 96h, al ;leere alle Segment-Anzeigen
out 98h, al
out 9Ah, al
out 9Ch, al
out 9Eh, al



start:
mov al, eins ; schreibe eins in al (00000110b) 
out 90h, al ;schreibe 000_0110 (Segement1+2 von Anzeige 90h) 


schl1: 			; Zeitschleife
	loop schl1
	
mov al, null
out 90h, al

schl2: 			; Zeitschleife
	loop schl2


jmp start           ; Zurück zum Start der Schleife
; Endlosschleife
; ------------------------------------- -----------------------------------------------
 
