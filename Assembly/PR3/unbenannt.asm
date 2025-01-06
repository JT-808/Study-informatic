
	  ORG 100H
;----------------------------------------

; PRAKTIKUM 3:
; Flags und bedingte Spruenge

start:
; Sagen Sie voraus, welche Flags (CF-ZF-PF-SF) und wie durch die
; entsprechenden Befehle beeinflusst werden, Ueberpruefen Sie

          mov  ax,0281h
          cmp  al,0c0h
          test al,7eh
          or   al,18h
          and  al,0fh
          rol  ah,1
          rol  ah,1

eingc:    in   al,0    ; Schalter abfragen
          cmp  al,9
          jc  eingc    ; bei welchen Eingabewerten wird gesprungen ?
          
          ; wenn al < 9

eingt:    in   al,0    ; Schalter abfragen
          test al,81h
          jnz  eingt   ; bei welchen Eingabewerten wird gesprungen ?
          
; 81h = 10000001 => Wenn Bit 7 oder Bit 0 = 1, dann wird ZF = 0.
; Weil TEST eine bitweise AND-Operation durchführt: 1 AND 1 = 1 => ZF = 0.
; Wenn ZF = 0, wird mit JNZ gesprungen.


          nop
          jmp start

;----------------------------------------
