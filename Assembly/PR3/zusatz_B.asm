
ORG 100H
;---------------------------------------------------
Port_In equ 0
Port_Out equ 0
Bit2 equ 00000100b
Bit6 equ 00100000b
Aus equ 00000000b
;-----------------------------------------------

start:

    in al, Port_In         ; Alle Schalter einlesen (Port 0)
    cmp al, Bit2			; Vergleiche! Passt?->Zero-Flag=1	
	jz led					;ZF=1? -> Sprung Led
	jnz ledAus				;ZF=0? -> Sprung LedAus

led: 
	mov al, Bit6	
	out Port_Out, al
	jmp start
	
ledAus: 
	mov al, Aus
	out Port_Out, al
	jmp start
	


