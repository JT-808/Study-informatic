org 100h
; ------------------------------------------------------------------------------------
mov al, 10000000b  ; Setze die äußerste linke LED auf 1
start: 


mov cx, -1

schl1: 			; Zeitschleife
	loop schl1
	
out 0, al       ; Ausgabe an den Port 0
ror al, 1  		; rotiere einmal durch die LEDś
    
     




jmp start           ; Zurück zum Start der Schleife
; Endlosschleife
; ------------------------------------- -----------------------------------------------
 
