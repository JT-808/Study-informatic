ORG 100H

start:

  in al, 00h           ; Alle Schalterzustände einlesen
    test al, 00000001b   ; Prüfen, ob S0 (Bit 0) an ist
    jz start             ; Falls nicht, zurück zum Start
    
LEDan:
	call delay
    mov al, 11111111b  ; Alle LEDs an (al = 255)
    out 00h, al        ; Wert an Port 0 schreiben (LEDs an)
         
         ; -> zu aus
LEDaus:
	call delay
    mov al, 00000000b  ; Alle LEDs aus (al = 0)
    out 00h, al        ; Wert an Port 0 schreiben (LEDs an)
    jmp start          ; Überprüfe ob Schalter noch angeschaltet ist
    

delay:
loop delay
test al, 10000000b			; überprüfe ob schalter 7 eingeschaltet
jnz delayLang
ret

delayLang:
loop delayLang
ret
