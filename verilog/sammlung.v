module Main(
    input [15:0]HW_switch,

    output [15:0]HW_led,

    input btnC
);


    //    wire [15:0]Aufg1_LED;
    //    assign Aufg1_LED = {8{2'b01}};


    //    wire [15:0]Aufg2_LED;
    //    assign Aufg2_LED = {4{HW_switch[15:12]}};


    //    wire [15:0]pattern;
    //    assign pattern = {16{btnC}}; 

    //    assign HW_led = (pattern & Aufg1_LED) | ((~pattern) &  Aufg2_LED);


    //SchalterKopieren(HW_switch,HW_led);


    //geradeLED(HW_led);



    //bit_mem(HW_switch_0, HW_switch_1, HW_led_0);


    //multiplexer(
    /*A*/ // HW_switch[0], HW_switch[1], HW_switch[2],HW_switch[3],
    /*E */ // HW_switch[4],HW_switch[5],HW_switch[6],HW_switch[7],HW_switch[8],HW_switch[9],HW_switch[10],HW_switch[11],HW_switch[12],HW_switch[13],HW_switch[14],HW_switch[15],
    // HW_switch,
    //  /*Y*/     HW_led[0]
    // );  


endmodule

//module SchalterKopieren(

//    input [15:0]S,
//    output [15:0]L

//);


//assign L = {4{S[15:12]}};

//endmodule




//module geradeLED(

//    output [15:0]L

//    );

//    assign L = {8{2'b01}};

//    endmodule



//module multiplexer(

//    input A1,A2,A3,A4,
//          [0:11]E,
//    output Y

//);

//// alles Negieren????

//wire A1,A2,A3,A4,
//     E[0],E[1],E[2],E[3],E[4],E[5],E[6],E[7],E[8],E[9],E[10],E[11],
//     Y;


//    assign Y = 
//(A1 & A2 & A3 & A4 & E[0]) |
//(A1 & A2 & A3 & ~A4 & E[1]) |
//(A1 & ~A2 & ~A3 & A4 & E[2]) |
//(~A1 & A2 & A3 & A4 & E[3]) |
//(A1 & A2 & ~A3 & ~A4 & E[4]) |
//(A1 & ~A2 & ~A3 & A4 & E[5]) |
//(~A1 & A2 & A3 & A4 & E[6]) |
//(~A1 & A2 & A3 & ~A4 & E[7]) |
//(~A1 & A2 & ~A3 & A4 & E[8]) |
//(A1 & ~A2 & A3 & ~A4 & E[9]) |
//(A1 & ~A2 & ~A3 & ~A4 & E[10]) |
//(~A1 & ~A2 & ~A3 & A4 & E[11]);

//endmodule


/*

~A1 & (A2 &  (A3 & (A4 & ((E3) | (E6))) | (~A4 & E7)) | (~A3 & A4 & E8)) | (~A2 & (~A3 & A4 & E11)) |



A1 & (A2 & (A3 & ((A4 & E0) | (~A4 & E1))) | (~A3 & ~A4 & E4)) | (~A2 & (~A3 & ((A4 & E2) | (A4 & E5)) | (~A4 & E10)) | (A3 & ~A4 & E9)) ; 
-> 20 Logik
*/




module bit_mem(
    input D,
    input E,
    output Q
);

    wire h1, h2, nQ;

    assign Q = ~(h1|nQ);
    assign h1 = ~D&E;
    assign nQ = ~(Q|h2);
    assign h2 = D&E;

endmodule

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

module disp4digits(
    input [3:0]digit0,
    input [3:0]digit1,
    input [3:0]digit2,
    input [3:0]digit3,
    input clk,
    output SSD_CA, SSD_CB, SSD_CC,SSD_CD, SSD_CE, SSD_CF, SSD_CG,
    output SSD_AN0, SSD_AN1, SSD_AN2, SSD_AN3
);

    assign SSD_AN0 = !(counter[19:18] == 0);
    assign SSD_AN1 = !(counter[19:18] == 1);
    assign SSD_AN2 = !(counter[19:18] == 2);
    assign SSD_AN3 = !(counter[19:18] == 3);

    wire [3:0]digit[3:0];

    assign digit[0] = digit0;
    assign digit[1] = digit1;
    assign digit[2] = digit2;
    assign digit[3] = digit3;

    seg7(digit[counter[19:18]], SSD_CA, SSD_CB, SSD_CC, SSD_CD, SSD_CE, SSD_CF, SSD_CG);

    reg [19:0] counter;

    always@(posedge clk)
    begin
        counter = counter + 1;
    end
endmodule

module dispInt(
    input [13:0] disp_int,
    input clk,
    output SSD_CA, SSD_CB, SSD_CC,SSD_CD, SSD_CE, SSD_CF, SSD_CG,
    output SSD_AN0, SSD_AN1, SSD_AN2, SSD_AN3
);

    wire [3:0]digit[3:0]; // [3:0] vor digit bedeutet wir wollen 4-Bit Bus

    assign digit[0] = disp_int % 10;
    assign digit[1] = (disp_int / 10) % 10;
    assign digit[2] = (disp_int / 100) % 10;
    assign digit[3] = (disp_int / 1000) % 10;

    disp4digits(digit[0], digit[1], digit[2], digit[3], clk,
        SSD_CA, SSD_CB, SSD_CC,SSD_CD, SSD_CE, SSD_CF, SSD_CG,
        SSD_AN0, SSD_AN1, SSD_AN2, SSD_AN3);

endmodule

module clock(
    input clock,
    output [1:0]led
);

    reg [31:0]counter;

    initial
    begin
        counter = 0;
    end

    always @(posedge clock)
    begin
        counter = counter + 1;
    end

    assign led[0]= (counter=={32{'b1}}) ;
    assign led[1]= (counter=={12{'b10}});

endmodule

module choiceWithoutIf(
    output[15:0] HW_led,
    input[15:0] HW_switch,
    input btnC,
    input clk,
    output SSD_CA, SSD_CB, SSD_CC,SSD_CD, SSD_CE, SSD_CF, SSD_CG,
    output SSD_AN0, SSD_AN1, SSD_AN2, SSD_AN3
);


    reg [31:0]counter;


    initial
    begin
        counter = 0;
    end

    always @(posedge clk)
    begin
        counter = counter + 1;
    end





    assign SSD_AN0 = ~(HW_switch[15:14] == 0); // 1. 7-Segmentanzeige einschalten
    assign SSD_AN1 = ~(HW_switch[15:14] == 1); // ... andere aus
    assign SSD_AN2 = ~(HW_switch[15:14] == 2);
    assign SSD_AN3 = ~(HW_switch[15:14] == 3);

    wire [3:0]digit[3:0]; // [3:0] vor digit bedeutet wir wollen 4-Bit Bus
    // digit [3:0] (Klammer danach) bedeutet, wir wollen 4 Stueck davon


    wire [13:0] my_Int;
    assign my_Int = 9648;


    assign digit[0] = my_Int %10;
    assign digit[1] = my_Int/10%10;
    assign digit[2] = my_Int/100%10;
    assign digit[3] = my_Int/1000%10;

    wire [3:0]final;

    assign final = digit[counter[15:14]] ; // = das selbe wie die zeilen darunter


    seg7(final, SSD_CA, SSD_CB, SSD_CC, SSD_CD, SSD_CE, SSD_CF, SSD_CG);


endmodule

module PseudoRandom(
    output[15:0] HW_led,
    input[15:0] HW_switch,
    input clk

);

    reg [6:0]bs;
    reg [31:0]counter;


    initial
    begin
        counter = 0;
    end

    always @(posedge clk)
    begin
        counter = counter + 1;
    end


    initial
    begin
        bs = 0101010;
    end

    disp4digits(bs);

    always@(posedge counter[22])
    begin
        bs = (bs<<1) | (bs[6] ^ bs[5]);
    end


    assign HW_led[6:0] = bs[6:0];


endmodule

module halbe(

    output[15:0] HW_led,
    input clk

);
    reg [16:0] ticks;
    reg [31:0] counter;
    reg richtung;

    initial
    begin
        counter = 0;
        richtung= 0;
        ticks =0;
    end



    always @(posedge clk)
    begin
        ticks = ticks + 1;

        if(richtung) counter = counter -1;
        else counter = counter+1;

    end

    always @(posedge ticks == 5'b10011)
    begin
        richtung = richtung + 1;
    end

    assign HW_led[0] = counter[0];

endmodule

//module Ledatme(
//    output [15:0]HW_led,
//    input [15:0]HW_switch,
//    input clk

//    );
//reg [16:0]counter;
//reg [15:0]Z=0;
//reg [15:0]S=0;
//reg[31:0]ticks;
//reg light = 0;

//initial
//begin
//counter=0;
//end

//assign HW_led[0] = light;
//always@(posedge clk)
//begin
//counter = counter+1;
//end

//always@(posedge counter[16])
//begin

//S[10]=1;
//Z=Z+1;

//assign light = Z > S;


//end


//reg [15:0]helligkeit;
//reg [15:0]counter;
//reg richtung;


//initial
//begin
//    counter = 0;
//    helligkeit = 0;
//    richtung = 0;
//end


//always@(posedge clk)
//begin
//    counter = counter + 1;
//    if(richtung == 0)begin
//        helligkeit = helligkeit + 1;
//        if(helligkeit == {16{'b1}}) richtung = 1;
//        end
//    else begin
//        helligkeit = helligkeit - 1;
//        if(helligkeit == 0) richtung = 0;
//        end

//    HW_led <= (counter < helligkeit);
//end

//assign HW_led = (counter < helligkeit);


//weiß = 3,3V
//Schwarz = Ground
//Braun = Signal
//rot = power


module DCF77_tester(
    input clk,
    output sig_edge
    );

    reg [16:0] ticks;
    reg ms_clk;
    reg [59:0]bitstring;
    reg [5:0]index;
    reg [10:0]msec;
    reg sig_edge, parity;
   
    initial
    begin
        index = 0;
        msec = 0;
        bitstring[0] = 0; // konstante 0 am Anfang
        bitstring[17:15] = 0; // keine Sommerzeit oder Umstellung
        bitstring[18] = 1; // MEZ
        bitstring[19] = 0; // keine Schalsekunde
        bitstring[20] = 1; // 1 fÃ¼r Start Zeitinfo
        
        // Zeit: 16:35 / Datum: Dienstag, der 24.12.'24
        
        bitstring[24:21] = 5; // Min-1er
        bitstring[27:25] = 3; // Min-10er

        bitstring[32:29] = 6; // Stunde-1er
        bitstring[34:33] = 1; // Stunde-10er
        
        bitstring[39:36] = 4; // Tag-1er
        bitstring[41:40] = 2; // Tag-10er

        bitstring[44:42] = 2; // Wochentag (Dienstag)
        
        bitstring[48:45] = 2; // Monat 1er
        bitstring[49]    = 1; // Monat 10er

        bitstring[53:50] = 4; // Jahr 1er
        bitstring[57:54] = 2; // Jahr 10er        
    end
    
    
    always @(posedge clk)
    begin
        ticks = ticks + 1;
        if(ticks >= 50_000)
        begin
            ticks = 0;
            ms_clk = ms_clk + 1;
        end
    end
    
    always @(posedge ms_clk) // 1-millisek. Takt
    begin
        if(index < 59)
        begin            
            if(bitstring[index] == 1)
                if(msec < 200) sig_edge = 1;
                else sig_edge = 0;
            else
            if(msec < 100) sig_edge = 1;
            else sig_edge = 0;
        end
        else sig_edge = 0;

        msec = msec + 1;
        if(msec == 1000)
        begin
            index = index + 1;
            if(index == 61) index = 0;
            msec = 0;
            
            case(index)
            21,29,36 : parity = bitstring[index];
            22,23,24,25,26,27,
            30,31,32,33,34,
            37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57 : parity = parity  ^ bitstring[index];
            28,35,58 : bitstring[index] = parity;
            endcase
        end
    end    
endmodule






module Zeitsignal(

    input [7:0]JA,
    input clk,
    output [15:0]HW_led,
    output SSD_CA, SSD_CB, SSD_CC,SSD_CD, SSD_CE, SSD_CF, SSD_CG,
    output SSD_AN0, SSD_AN1, SSD_AN2, SSD_AN3
);

wire simu_sig;
DCF77_tester(clk, simu_sig);

    reg [15:0]ausgabe;
    reg signal;
    reg [8:0]aktivzaehler;
    reg [12:0] signal_state, last_state, current_state;
    reg [16:0] ticks;
    reg ms_clk;

    reg [59:0]bitstring;
    reg [6:0]index;

    reg start;
    reg [14:0]pausenzaehler;
    reg neuesSignal;
    
    

dispInt(ausgabe[13:0],clk,SSD_CA,SSD_CB,SSD_CC,SSD_CD,SSD_CE,SSD_CF,SSD_CG,SSD_AN0, SSD_AN1, SSD_AN2, SSD_AN3);
//dispInt(pausenzaehler,clk,SSD_CA,SSD_CB,SSD_CC,SSD_CD,SSD_CE,SSD_CF,SSD_CG,SSD_AN0, SSD_AN1, SSD_AN2, SSD_AN3);


    initial
    begin
        signal=0;
        aktivzaehler=0;
        index =0;
        start = 0;
    end


    always @(posedge clk)
    begin
        ticks = ticks + 1;
        if(ticks >= 50_000)
        begin
            ticks = 0;
            ms_clk = ms_clk + 1;
        end
    end


    always @(posedge ms_clk) // 1-millisek. Takt
    begin
        signal_state = (signal_state*31)/32 + simu_sig*(256/32);
        last_state = current_state;
        current_state = (signal_state > 128);

        if(current_state==1)
        begin
            pausenzaehler = 0;
            aktivzaehler = aktivzaehler+1;
        end


        if(current_state==0)
        begin

            pausenzaehler = pausenzaehler +1;

            if(aktivzaehler <= 150 && aktivzaehler != 0)
            begin

                signal = 0;
               
            end
            
            if(aktivzaehler > 150 && aktivzaehler != 0)
            begin

                signal = 1;
                
            end
            aktivzaehler = 0;
        end

        if(pausenzaehler > 1000)
        begin
            start = 1;

            if(index==59)
                begin
                start = 0;
                end
        end

    end
    



            always@(negedge current_state)
            begin

            if(start==1)
            begin
            
//            if(index==0)
//            begin
//        bitstring[0] = 0; // konstante 0 am Anfang
//        bitstring[17:15] = 0; // keine Sommerzeit oder Umstellung
//        bitstring[18] = 1; // MEZ
//        bitstring[19] = 0; // keine Schalsekunde
//        bitstring[20] = 1; // 1 fÃ¼r Start Zeitinfo
        
//        // Zeit: 16:35 / Datum: Dienstag, der 24.12.'24
        
//        bitstring[24:21] = 5; // Min-1er
//        bitstring[27:25] = 3; // Min-10er

//        bitstring[32:29] = 6; // Stunde-1er
//        bitstring[34:33] = 1; // Stunde-10er
        
//        bitstring[39:36] = 4; // Tag-1er
//        bitstring[41:40] = 2; // Tag-10er

//        bitstring[44:42] = 2; // Wochentag (Dienstag)
        
//        bitstring[48:45] = 2; // Monat 1er
//        bitstring[49]    = 1; // Monat 10er

//        bitstring[53:50] = 4; // Jahr 1er
//      bitstring[57:54] = 2; // Jahr 10er 
//            end
            
            
            
            
                bitstring[index] = signal;
                index = index+1;
                
//                //Einer Minute
//                if(index >= 21 && index <= 24) ausgabe[3:0] = bitstring[24:21];
                
//                //Zehner Minute
//                if(index >= 25 && index <= 27)
//                begin

//                ausgabe[5:4] = bitstring[27:25];
//                ausgabe[7:6] = 2'b00;
//                end
                
//                //Einer Stunde
//                if(index >= 29 && index <= 32)
//                begin
//                ausgabe[11:8] = bitstring[32:29];
//                end
                
//                //Zehner Stunde
//                if(index >= 33 && index <= 34)
//                begin
//                ausgabe[13:12] = bitstring[34:33];
//                ausgabe[15:14] = 2'b00;
//                end

                
                if(index<49)
                begin
                ausgabe = bitstring[24:21] + bitstring[27:25]*10 + bitstring[32:29]*100 + bitstring[34:33]*1000;
                //ausgabe = bitstring[34:33]*1000;
                end
                
                
                if(index > 49)
                begin
                ausgabe = bitstring[39:36] + bitstring[41:40]*10 + bitstring[48:45]*100 + bitstring[49]*1000;
                //ausgabe = bitstring[34:33]*1000;
                end
                
                
                
                if(index==59)
                begin
                    index =0;
//                //Einer Minute
//                ausgabe[3:0] = bitstring[24:21];
//                //Zehner Minute
//                ausgabe[5:4] = bitstring[27:25];
//                ausgabe[7:6] = 2'b00;
//                //Einer Stunde
//                ausgabe[11:8] = bitstring[32:29];
//                //Zehner Stunde
//                ausgabe[13:12] = bitstring[34:33];
//                ausgabe[15:14] = 2'b00;                
                
                
                end
            end
            end





    assign HW_led[15:2] = bitstring[34:21];
    assign HW_led[0]=signal;
    assign HW_led[1]=~signal;


endmodule







module vga(
input clk,
input [15:0]HW_switch,

output [3:0]vgaRed,
output [3:0]vgaGreen,
output [3:0]vgaBlue,
output Vsync,
output Hsync
);


reg [10:0] counter ;
reg [10:0] shiftgrenze;
reg [9:0] zeilencounter;
reg [4:0] tick;
reg [3:0] gruenwert;
reg [3:0] blauwert;
reg [3:0] rotwert;
reg [15:0] random_num1;  // Zufallszahl-Register
reg [15:0] schluesselmuster1;
reg [15:0] random_num2;  // Zufallszahl-Register
reg [15:0] schluesselmuster2;
reg [15:0] random_num3;  // Zufallszahl-Register
reg [15:0] schluesselmuster3;
reg [9:0] i;
reg [9:0] yshift;
reg [10:0] xshift;
reg xrichtung;
reg yrichtung;
reg [3:0] redshift;
reg [3:0] greenshift;
reg [3:0] blueshift;


wire hbereich;
wire vbereich;

initial
begin
i = 1;
random_num1 = 16'b1101010010100111;
schluesselmuster1 = 16'b1101010010100111;

random_num2 = 16'b1111011110100111;
schluesselmuster2 = 16'b1111011110100111;

random_num3 = 16'b1111011110000000;
schluesselmuster3 = 16'b1111011110000000;
end



always@(posedge clk)
begin
tick = tick + 1;
end


always@(posedge tick[1])
begin
counter = counter + 1;




if (counter == 800)
begin
zeilencounter = zeilencounter + 1;
counter = 0;

end



if(i == zeilencounter)
begin
random_num1 = schluesselmuster1;
random_num2 = schluesselmuster2;
random_num3 = schluesselmuster3;
end

if(zeilencounter == 525)
begin
zeilencounter = 0;
i = i + 1;

if(xrichtung)
begin
xshift = xshift - 1;
end
else
begin
xshift = xshift + 1;
end

if(yrichtung)
begin
yshift = yshift - (5*random_num1[5]);
end
else
begin
yshift = yshift + (10*random_num1[2]);
end

end


if(i == 525)
begin
i = 0;
end

// Richtungsänderung (bevor verlassen des Bildschirms)
if(yshift == 10)
begin
yrichtung = 0;
end

if(yshift == 500)
begin
yrichtung = 1;
end

if(xshift == 30)
begin
xrichtung = 0;
end

if(xshift == 500)
begin
xrichtung = 1;
end



// Zufallszahlen generieren----------
random_num1 = {random_num1[14:0], random_num1[15] ^ random_num1[13] ^ random_num1[12] ^ random_num1[10]};  // XOR-Shift

random_num2 = {random_num2[14:0], random_num2[15] ^ random_num2[13] ^ random_num2[12] ^ random_num2[10]};

random_num3 = {random_num3[14:0], random_num3[15] ^ random_num3[13] ^ random_num3[12] ^ random_num3[10]};
//-----------------------------------


// Erstellung der  8 Sektionen/Farbläufe ---------
if( counter<shiftgrenze+(xshift+200) & counter>=shiftgrenze+xshift)
begin
    if (random_num1[15] == 1) begin
    if (zeilencounter[1]^zeilencounter[3])
    begin
      gruenwert = 4'b0000  * hbereich * vbereich ; 
      rotwert = 4'b0000 * hbereich * vbereich;    
      blauwert = ~blueshift * hbereich * vbereich;
    end 
    else begin
      gruenwert = 4'b1111  * hbereich * vbereich ; 
      rotwert = 4'b0000 * hbereich * vbereich;    
      blauwert = 4'b0000 * hbereich * vbereich;
     end 
    end else begin
      gruenwert = 4'b0000 * hbereich * vbereich;  // Schwarz
      rotwert = 4'b0000 * hbereich * vbereich;    // Schwarz
      blauwert = 4'b0000 * hbereich * vbereich;   // Schwarz
    end

end


else if(zeilencounter<yshift+100 & zeilencounter>=yshift)
begin
    if (random_num1[15] == 1) begin
    if (zeilencounter[1]^zeilencounter[3])
    begin
      gruenwert = 4'b0000  * hbereich * vbereich ; 
      rotwert = 4'b0000 * hbereich * vbereich;    
      blauwert = ~blueshift * hbereich * vbereich;
    end 
    else begin
      gruenwert = 4'b1111  * hbereich * vbereich ; 
      rotwert = 4'b0000 * hbereich * vbereich;    
      blauwert = 4'b0000 * hbereich * vbereich;
     end 
    end else begin
      gruenwert = 4'b0000 * hbereich * vbereich;  // Schwarz
      rotwert = 4'b0000 * hbereich * vbereich;    // Schwarz
      blauwert = 4'b0000 * hbereich * vbereich;   // Schwarz
    end
end

else if(counter<190 & counter>=140 & (zeilencounter[5] ^ zeilencounter[4]))
begin
    if (random_num2[14] == 1) begin
      gruenwert = 4'b0000  * hbereich * vbereich ; 
      rotwert = 4'b0000 * hbereich * vbereich;    
      blauwert = 4'b0000 * hbereich * vbereich; 
      
      
    end else begin
      gruenwert = 4'b1111 * hbereich * vbereich; 
      rotwert = 4'b1111 * hbereich * vbereich;
      blauwert = 4'b1111 * hbereich * vbereich; 
    end

end

else if(counter<295 & counter>=195)
begin
    if (random_num2[14] == 1) begin
      gruenwert = greenshift  * hbereich * vbereich ; 
      rotwert = redshift * hbereich * vbereich;    
      blauwert = blueshift * hbereich * vbereich; 
      
      
    end else begin
      gruenwert = 4'b0000 * hbereich * vbereich; 
      rotwert = 4'b0000 * hbereich * vbereich;
      blauwert = 4'b0000 * hbereich * vbereich; 
    end

end

else if((zeilencounter[0]^counter[5])&counter<400 & counter>=300)
begin
    if (random_num2[14] == 1) begin
      gruenwert = 4'b0000  * hbereich * vbereich ; 
      rotwert = 4'b0110 * hbereich * vbereich;    
      blauwert = blueshift * hbereich * vbereich; 
      
      
    end else begin
      gruenwert = 4'b0000 * hbereich * vbereich; 
      rotwert = 4'b0000 * hbereich * vbereich;
      blauwert = 4'b0000 * hbereich * vbereich; 
    end

end

else if(counter<550 & counter>=405)
begin
    if (random_num2[14] == 1) begin
      gruenwert = 4'b0110  * hbereich * vbereich ; 
      rotwert = 4'b0000 * hbereich * vbereich;    
      blauwert = blueshift * hbereich * vbereich; 
      
      
    end else begin
      gruenwert = 4'b0000 * hbereich * vbereich; 
      rotwert = 4'b0000 * hbereich * vbereich;
      blauwert = 4'b0000 * hbereich * vbereich; 
    end

end
else if( (zeilencounter[2]^zeilencounter[3]) &counter<750&counter>=600)
begin
    if (random_num2[15] == 1) begin
      gruenwert = 4'b0110  * hbereich * vbereich ; 
      rotwert = redshift * hbereich * vbereich;    
      blauwert = 4'b0000 * hbereich * vbereich; 
      
      
    end else begin
      gruenwert = 4'b0000 * hbereich * vbereich;  // Schwarz
      rotwert = 4'b0000 * hbereich * vbereich;    // Schwarz
      blauwert = 4'b0000 * hbereich * vbereich;   // Schwarz
    end

end
else if( (zeilencounter[4]^zeilencounter[1]) &counter<595&counter>=555)
begin
    if (random_num3[15] == 1) begin
      gruenwert = 4'b0000 * hbereich * vbereich ; 
      rotwert = redshift * hbereich * vbereich;    
      blauwert = 4'b0110 * hbereich * vbereich; 
    end else begin
      gruenwert = 4'b0000 * hbereich * vbereich;  // Schwarz
      rotwert = 4'b0000 * hbereich * vbereich;    // Schwarz
      blauwert = 4'b0000 * hbereich * vbereich;   // Schwarz
    end

end
 else
 begin
      gruenwert = 4'b0000 * hbereich * vbereich;  // Schwarz
      rotwert = 4'b0000 * hbereich * vbereich;    // Schwarz
      blauwert = 4'b0000 * hbereich * vbereich;   // Schwarz
 end
//---------------------------------------------------------------------

end


// Schräger Verlauf-----------
always@(posedge zeilencounter[0])
begin

shiftgrenze = shiftgrenze +2;

if(zeilencounter == 0)
begin
shiftgrenze = 0;
end
end
//---------------------------------


//Farbverläufe---------------------

always@(posedge zeilencounter[3])
begin
redshift = redshift + 1;
if(zeilencounter == 0)
begin
redshift = 0;
end
end

always@(posedge zeilencounter[1])
begin
greenshift = greenshift + 1;
if(zeilencounter == 0)
begin
greenshift = 0;
end
end

always@(posedge zeilencounter[2])
begin 
blueshift = blueshift + 1;
if(zeilencounter == 0)
begin 
blueshift = 0;
end
end
//-----------------------------------------------

// Festlegung der Grenzen des Bildschirms ------------

assign hbereich = (counter >= 161 && counter < 800);  // Sichtbarer Bereich für horizontal
assign vbereich = (zeilencounter >= 46 && zeilencounter < 525);  // Sichtbarer Bereich für vertikal


assign Hsync = (counter < (96+16)) && (counter >= 16);  // Ein Beispiel für einen einfachen horizontalen Sync
assign Vsync = (zeilencounter < 12) && (zeilencounter >= 10);  // Ein Beispiel für einen vertikalen Sync

//----------------------------------------------------

assign vgaGreen = gruenwert;
assign vgaBlue = blauwert;
assign vgaRed = rotwert;


endmodule




