ORG 100H
;------------------------
Port_In equ 0         ; Eingangsport für die Schalter
Start_Adresse equ 200h ; Startadresse für Speicher
End_Adresse equ 2FFh   ; Endadresse für Speicher
;------------------------

start:
    in al, Port_In           ; Wert von Port 0 einlesen
    mov bx, Start_Adresse    ; BX als Adresszeiger initialisieren

setze:
    mov [bx], al             ; Wert von AL an Adresse BX speichern
    inc bx                   ; Adresse um 1 erhöhen
    cmp bx, End_Adresse + 1  ; Prüfen, ob wir über das Ende hinaus sind
    jne setze          		 ; Wenn nicht, weiter in der Schleife

jmp start


;jne = Jump not equal
