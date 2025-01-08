ORG 100H                ; Setzt die Startadresse des Programms auf 100H

;------------------------
Port_In equ 0           ; Definition des Eingangsports für die Schalter
Start_Adresse equ 0C000h ; Startadresse für Speicher
End_Adresse equ 0CFFFh   ; Endadresse für Speicher
enter_key equ 10h			; Enter-Taste
go_key equ 11h				; G-Taste
plus_key equ 16h			; +-taste
strich: equ 01000000b
;------------------------

init:
   int 6               ; Systemaufruf, um das Display zu löschen
   mov di, Start_Adresse	; Lade die StartAdresse  in Di

los:
 
    mov ah, 1            ; 1 = warten auf Tastenbestätigung
    int 5                ; Systemaufruf, warten auf Tastenbestätigung
    cmp al, enter_key          ; Enter "E" Taste gedrückt?
    je start             ; Wenn ja, dann zu Start
    cmp al, go_key         ; Go "G" Taste gedrückt?
    je start             ; Wenn ja, dann zu Start
    jne los            ; Ansonsten zurück zu init
    

start:
    mov bx, symbtab      ; Lädt die Basisadresse der Symboltabelle in BX
    in ax, Port_In       ; Liest den aktuellen Zustand der Schalter (8 Bit) in AX
    mov si, ax           ; Kopiert den Wert von AX in SI, der als Index dient
    push ax
    mov ax, [bx + si]    ; Lädt das entsprechende Bitmuster aus der Symboltabelle
                          ; (basierend auf dem Schalterzustand) in AX
    out 09Eh, ax         ; Schreibt das Bitmuster von AX an Port 9Eh (Display-Ausgabe)
    pop ax
    mov bp,ax			; speicher den Wert von ax in bp
    
suche:

	inc di
    mov cx, [di]          ; Lade den Wert an dieser Adresse in CX
    cmp cx, bp           ; Vergleiche den Wert mit dem Wert aus der Symboltabelle (ax)
    je setze              ; Wenn der Wert übereinstimmt, springe zu "setze"
    
    cmp di, End_Adresse		; Prüfe, ob das Ende des Speicherbereichs erreicht ist
    je ende               ; Wenn Ende erreicht, gehe zu "ende"
    
    jmp suche             ; Wiederhole die Suche
    
setze:
    ; Adresse als Hexadezimalwert anzeigen
    mov bx,di            ; Lade die Adresse in BX
    mov dl, 3             ; Displayposition 4 (rechte Seite)
    mov ah, 3             ; Ausgabe einer 16-Bit-Hexadezimalzahl
    int 6                 ; Systemaufruf, um die Adresse anzuzeigen
    
weiter:
    mov ah, 1            ; 1 = warten auf Tastenbestätigung
    int 5                ; Systemaufruf, warten auf Tastenbestätigung
    cmp al, plus_key          ; + Taste gedrückt?
   je suche              ; Wenn + gedrückt, weitermachen
    jne weiter
    
ende:
    ; Wenn keine weiteren Adressen gefunden wurden, zeige "----" an
	mov al, strich
	out 96h, al
	out 94h, al
	out 92h, al
	out 90h, al
    jmp los          ; Zurück zum Start





; Symboltabelle für Bitmuster der Ziffern 0-F
symbtab:
    db 00111111b         ; 0
    db 00000110b         ; 1
    db 01011011b         ; 2
    db 01001111b         ; 3
    db 01100110b         ; 4
    db 01101101b         ; 5
    db 01111101b         ; 6
    db 00000111b         ; 7
    db 01111111b         ; 8
    db 01101111b         ; 9
    db 01110111b         ; A
    db 01111100b         ; B
    db 00111001b         ; C
    db 01011110b         ; D
    db 01111001b         ; E
    db 01110001b         ; F
