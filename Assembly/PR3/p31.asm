ORG 100H

start:
    in al, 0           ; Wert von Port 0 (Schalter S0) einlesen
    cmp al, 1          ; Prüfen, ob S0 eingeschaltet (al = 1)
    jz LEDan           ; Wenn S0 = 1, LEDs einschalten
    jmp LEDaus         ; Andernfalls LEDs ausschalten

LEDan:
    mov al, 11111111b  ; Alle LEDs an (al = 255)
    out 00h, al        ; Wert an Port 0 schreiben (LEDs an)
    jmp start          ; Zurück zum Anfang

LEDaus:
    xor al, al         ; al = 0 (alle LEDs aus)
    out 00h, al        ; Wert an Port 0 schreiben (LEDs aus)
    jmp start          ; Zurück zum Anfang
