module myMultiplexer(
    input [15:0]HW_switch,
    output [0:0]HW_led
    );
 
   
   wire C00, C01, C02, C03, C04, C05, C06, C07, C08, C09, C10, C11;
   
   wire A3, A2, A1, A0;
   
   assign A0 = HW_switch[12];
   assign A1 = HW_switch[13];
   assign A2 = HW_switch[14];
   assign A3 = HW_switch[15];
   
   wire S1 = ~A3 & ~A2;
   
   wire B1; assign B1 = ~A1 & ~A0;
   wire B2; assign B2 = ~A1 &  A0;
   wire B3; assign B3 =  A1 & ~A0;
   wire B4; assign B4 =  A1 &  A0;
   
   assign C00 = S1 & B1;
   assign C01 = S1 & B2;
   assign C02 = S1 & B3;
   assign C03 = S1 & B4;

   wire S2 = ~A3 &  A2;

    // Hier kÃ¶nnen Sie noch mit B1-B4 weiter vereinfachen

   assign C04 = S2 & ~A1 & ~A0;
   assign C05 = S2 & ~A1 &  A0;
   assign C06 = S2 &  A1 & ~A0;
   assign C07 = S2 &  A1 &  A0;

   wire S3 =  A3 & ~A2;

   assign C08 =  S3 & ~A1 & ~A0;
   assign C09 =  S3 & ~A1 &  A0;
   assign C10 =  S3 &  A1 & ~A0;
   assign C11 =  S3 &  A1 &  A0;

   assign HW_led[0] = 
          C00 & HW_switch[0] | 
          C01 & HW_switch[1] | 
          C02 & HW_switch[2] | 
          C03 & HW_switch[3] |
          C04 & HW_switch[4] | 
          C05 & HW_switch[5] | 
          C06 & HW_switch[6] | 
          C07 & HW_switch[7] | 
          C08 & HW_switch[8] | 
          C09 & HW_switch[9] | 
          C10 & HW_switch[10] |
          C11 & HW_switch[11];     
 endmodule
