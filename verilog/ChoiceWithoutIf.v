module seg7(
    input [3:0]digit,    
    output CA,
    output CB,
    output CC,
    output CD,   
    output CE,
    output CF,
    output CG     
    );
    wire W, X, Y, Z;

    assign W = digit[0];
    assign X = digit[1];
    assign Y = digit[2];
    assign Z = digit[3];

    assign CA = ~(Z|X)&(Y^W)|(Z&X&W);
    assign CB = (!Z&Y)&(X^W)|(Z&X)&(!Y|W);
    assign CC = X&((~Y & ~W)|(Z & W));
    assign CD = W&(!(Y|(Z^X))|(Y&X))|!(Z|!Y|X|W);
    assign CE = ((W|Z) | (Y&!X)) & ((~Z|Y) | (~X&W));
    assign CF = ~Z&(~Y&(X|W)|(X&W))|(Z&X&W);
    assign CG = ~Z&((~Y&!X)|(Y&X&W));
    
endmodule

module choiceWithoutIf(
    output[15:0] HW_led,
    input[15:0] HW_switch,
    input btnC,
    input clk,
    output SSD_CA, SSD_CB, SSD_CC,SSD_CD, SSD_CE, SSD_CF, SSD_CG,
    output SSD_AN0, SSD_AN1, SSD_AN2, SSD_AN3
    );
    // Stellen mit den counter-Bits 'durch-cyclen'
    assign SSD_AN0 = !(counter[20:19] == 0); // 1. 7-Segmentanzeige einschalten
    assign SSD_AN1 = !(counter[20:19] == 1); // ... andere aus
    assign SSD_AN2 = !(counter[20:19] == 2);
    assign SSD_AN3 = !(counter[20:19] == 3);   
    
    wire [3:0]digit[3:0]; // [3:0] vor digit bedeutet wir wollen 4-Bit Bus
                          // digit [3:0] (Klammer danach) bedeutet, wir wollen 4 StÃƒÂ¼ck davon
                                                    
    assign digit[0] = 9;
    assign digit[1] = 6;
    assign digit[2] = 4;
    assign digit[3] = 8;  
    
    wire [3:0]final;
    
    // Aufgabe Stellen mit den counter-Bits 'durch-cyclen'
    assign final = digit[counter[20:19]]; // alternativ
    
    /*
    // Aufgabe Stellen mit den Switches selbst durchschalten
    assign final = (HW_switch[1:0] == 0)*digit[0] + 
                   (HW_switch[1:0] == 1)*digit[1] + 
                   (HW_switch[1:0] == 2)*digit[2] + 
                   (HW_switch[1:0] == 3)*digit[3];
    */
    seg7(final, SSD_CA, SSD_CB, SSD_CC, SSD_CD, SSD_CE, SSD_CF, SSD_CG);

    reg [31:0]counter;
    
    initial
    begin
      counter = 0;  
    end
    
    // LEDs anzeigen die der Mensch noch beobachten kann
    assign HW_led[15:0] = counter[31:16];
    /*
    // Aufgabe: LED ca. 1 Hz blinken
    assign HW_led[0] = counter[25];
    assign HW_led[1] = counter[26];
    */
    always@(posedge clk)
    begin
      counter = counter + 1;
    end
    
endmodule
