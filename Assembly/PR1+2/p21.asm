org 100h
; ------------------------------------------------------------------------------------

start mov al, 00000111b  ; Setze die drei unteren Bits auf 1, um drei LEDs einzuschalten
out 0,al
; und auf die LED-Zeile ausgeben
mov cx,-1
; Zaehler für Zeitschleife laden
schl1: loop schl1
; loop: zwei Befehle in einem
; Schritt1: Dekrementiere <CX>
; Schritt2: Sprung, wenn <CX> ungleich 0
mov al,0
out 00,al
; alle LED „ausschalten“
mov cx,-1
schl2: loop schl2
jmp start
; Endlosschleife
; ------------------------------------------------------------------------------------
