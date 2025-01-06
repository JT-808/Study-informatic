org 100h ;Assembler Direktive ("Origin")
; ------------------------------------------------------------------------------------

start:
	mov al, 01010101b  ; Setze die drei Bits auf 1
	mov bl, 10101010b  ; Setze die anderen 3 bits auf 1
	out 0,al            ; und auf die LED-Zeile ausgeben

mov cx,-1 ; setze Counter auf -6535 -> zähle bis null
mov al,bl ; Schiebe Inhalt von bl nach al


; Zaehler für Zeitschleife laden

; loop: zwei Befehle in einem
; Schritt1: Dekrementiere <CX>
; Schritt2: Sprung, wenn <CX> ungleich 0
out 00,al
; alle LED „ausschalten“
mov cx,-1
schl2: loop schl2
jmp start
; Endlosschleife
; ------------------------------------------------------------------------------------
