module seg7(
    output CA,
    output CB,
    output CC,
    output CD,
    output CE,
    output CF,
    output CG,
    
    input Z,
    input Y,
    input X,
    input W
     );
     
    assign CA = (Z & X & W) | (~Z & ~X & (Y ^ W));
    assign CB = (~Z & Y & (X ^ W)) | (Z & X & (~Y | W));
    assign CC = X&((~Y & ~W)|(Z & W));
    assign CD = W&(~(Y|(Z^X))|(Y&X))|~(Z|~Y|X|W);
    assign CE = ((W|Z) | (Y&~X)) & ((~Z|Y) | (~X&W));
    assign CF = ~Z&(~Y&(X|W)|(X&W))|(Z&X&W);
    assign CG = ~Z&((~Y&!X)|(Y&X&W));
endmodule

module test_seg7(
    output SSD_CA,
    output SSD_CB,
    output SSD_CC,
    output SSD_CD,
    output SSD_CE,
    output SSD_CF,
    output SSD_CG,
    output SSD_AN0,
    output SSD_AN1,
    output SSD_AN2,
    output SSD_AN3,
    
    input [3:0]HW_switch
     );

     assign SSD_AN0 = 0; // 1. Ziffer einschalten
     assign SSD_AN1 = 1; // Rest ausschalten
     assign SSD_AN2 = 1;
     assign SSD_AN3 = 1;

    seg7(SSD_CA, SSD_CB, SSD_CC, SSD_CD, SSD_CE, SSD_CF, SSD_CG, 
         HW_switch[3], HW_switch[2], HW_switch[1], HW_switch[0]);
endmodule
