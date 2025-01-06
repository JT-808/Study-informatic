ORG 100H

start:
    mov al, 00000001b    ; Start mit der ersten LED (LSB)
    
NachLinks:
    call delay           ; Verzögerung aufrufen
    out 00h, al          ; Schreibe den aktuellen LED-Status
    rol al, 1            ; Zyklisch nach links rotieren
    cmp al, 10000000b    ; Prüfen, ob die letzte LED erreicht ist (Bit 7 gesetzt)
    je NachRechts        ; Wenn ja, wechsle zur Bewegung nach rechts
    jmp NachLinks        ; Andernfalls weiterhin nach links rotieren

NachRechts:
    call delay           ; Verzögerung aufrufen
    out 00h, al          ; Schreibe den aktuellen LED-Status
    ror al, 1            ; Zyklisch nach rechts rotieren
    cmp al, 00000001b    ; Prüfen, ob die erste LED erreicht ist (Bit 0 gesetzt)
    je NachLinks         ; Wenn ja, wechsle zur Bewegung nach links
    jmp NachRechts       ; Andernfalls weiterhin nach rechts rotieren
    
   delay: loop delay		; delays
   ret						;ret => geht wieder zurück
  
