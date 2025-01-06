ORG 100H                ; Setzt die Startadresse des Programms auf 100H

;------------------------
Port_In equ 0           ; Definition des Eingangsports für die Schalter
;------------------------

init:
    mov ah, 0           ; AH = 0, um das Display zu löschen
    int 6               ; Systemaufruf, um das Display zu löschen

start:
    mov bx, symbtab     ; Lädt die Basisadresse der Symboltabelle in BX
    in ax, Port_In      ; Liest den aktuellen Zustand der Schalter (8 Bit) in AX
    mov si, ax          ; Kopiert den Wert von AX in SI, der als Index dient
    mov ax, [bx+si]     ; Lädt das entsprechende Bitmuster aus der Symboltabelle
                        ; (basierend auf dem Schalterzustand) in AX
    out 092h, ax        ; Schreibt das Bitmuster von AX an Port 92h (Display-Ausgabe)

    jmp start           ; Springt zurück zu "start", um die Anzeige kontinuierlich
                        ; zu aktualisieren

; Symboltabelle
symbtab:
    db 00111111b        ; 0
    db 00000110b        ; 1
    db 01011011b        ; 2
    db 01001111b        ; 3
    db 01100110b        ; 4
    db 01101101b        ; 5
    db 01111101b        ; 6
    db 00000111b        ; 7
    db 01111111b        ; 8
    db 01101111b        ; 9
    db 01110111b        ; A
    db 01111100b        ; B
    db 00111001b        ; C
    db 01011110b        ; D
    db 01111001b        ; E
    db 01110001b        ; F


