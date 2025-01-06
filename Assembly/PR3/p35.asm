ORG 100H

rechts equ 00000111b    ; 3 rechten LEDś
links equ 11110000b    ; 4 linken LEDś
beide equ 11111111b		; Allle

;-----------------------------------------------

start:

    in al, 0         ; Alle Schalter einlesen (Port 0)
    and al, 10000001b 	; S0 und S7 Filtern
     
vergleiche:    
    
    cmp al, 00000001b
    jz setzeBlinkerRechts
    cmp al, 10000000b
    jz setzeBlinkerLinks
    cmp al,10000001b
    jz setzeBeide
    
    jmp start
    
setzeBlinkerRechts:
    mov al, rechts
    call LEDan     
    
setzeBlinkerLinks:
    mov al, links
    call LEDan   
    
setzeBeide:
		mov al, beide
		
LEDan:
	call delay
    out 00h, al        ; Wert an Port 0 schreiben (LEDs an)
  
    call delay        
    mov al, 00000000b
    out 0, al        ; Wert 0 schreiben (LEDs aus)
         ; Zurück zum Anfang
    jmp start
	
delay:
	loop delay		; delay
	ret		;ret => geht wieder zurück
   					
