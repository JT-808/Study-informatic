ORG 100H

leer equ 00h          ; Alle LEDs aus
eins equ 00000110b    ; Darstellung der Zahl 1 (Segmente B und C an)
null equ 10111111b    ; Darstellung der Zahl 0

; Initialisierung: Alle Anzeigen leeren
init:
    mov al, leer
    out 90h, al
    out 92h, al
    out 94h, al
    out 96h, al
    out 98h, al
    out 9Ah, al
    out 9Ch, al
    out 9Eh, al

start:

    in al, 00h         ; Alle Schalter einlesen (Port 0)
    mov bl, al
    in al, 00h
    mov cl, al
    
vergleicheS3:    
    
    test bl, 00000100b
    jnz setzeEinsS3
    jz setzeNullS3
 
vergleicheS4:
    
    test cl, 00001000b
    jnz setzeEinsS4
    jz setzeNullS4
    
    jmp start
    
    
    
setzeNullS3:
    mov al, null       
    out 94h, al
    jmp vergleicheS4
    
setzeEinsS3:
    mov al, eins       
    out 94h, al
    jmp vergleicheS4
    
setzeNullS4:
    mov al, null       
    out 96h, al
    jmp start

setzeEinsS4:
    mov al, eins     
    out 96h, al
	jmp start
