/*
S = ~C & ~A & B | ~C &  A & ~B | C & ~A& ~B | C & A & B;
  = ~C & (~A & B | A & ~B) | C & (~A& ~B | A & B)
  = ~C & (A ^ B) | C & ~(A ^ B) 
C = ~C &  A & B |  C & ~A & B | C &  A& ~B | C & A & B;
  = (A & B) | C & (~A & B | A& ~B);
  = (A & B) | C & (A ^ B);  

  = ~C &  A & B | C & (A | B);

C A B | S C
-------------
0 0 0 | 0 0
0 0 1 | 1 0
0 1 0 | 1 0
0 1 1 | 0 1
1 0 0 | 1 0
1 0 1 | 0 1
1 1 0 | 0 1
1 1 1 | 1 1

*/

module full_adder(
    input A,
    input B,
    input C,
    output S,
    output carry
    );
    
    assign S = ~C & ~A & B | ~C &  A & ~B | C & ~A& ~B | C & A & B;
    assign carry = ~C &  A & B |  C & ~A &  B | C &  A& ~B | C & A & B;
    
endmodule

module add8Bit(
     input HW_switch_0,
     input HW_switch_1,
     input HW_switch_2,
     input HW_switch_3,
     input HW_switch_4,
     input HW_switch_5,
     input HW_switch_6,
     input HW_switch_7,
     input HW_switch_8,
     input HW_switch_9,
     input HW_switch_10,
     input HW_switch_11,
     input HW_switch_12,
     input HW_switch_13,
     input HW_switch_14,
     input HW_switch_15,

     output HW_led_0,
     output HW_led_1,
     output HW_led_2,
     output HW_led_3,
     output HW_led_4,
     output HW_led_5,
     output HW_led_6,
     output HW_led_7,
     output HW_led_8
     
     );
     
     wire c0, c1, c2, c3, c4, c5, c6, c7;
     
     full_adder(HW_switch_0, HW_switch_8, 0,
                HW_led_0, c0);
     full_adder(HW_switch_1, HW_switch_9, c0,
                HW_led_1, c1);
     full_adder(HW_switch_2, HW_switch_10, c1,
                HW_led_2, c2);
     full_adder(HW_switch_3, HW_switch_11, c2,
                HW_led_3, c3);
     full_adder(HW_switch_4, HW_switch_12, c3,
                HW_led_4, c4);
     full_adder(HW_switch_5, HW_switch_13, c4,
                HW_led_5, c5);
     full_adder(HW_switch_6, HW_switch_14, c5,
                HW_led_6, c6);
     full_adder(HW_switch_7, HW_switch_15, c6,
                HW_led_7, HW_led_8);
                 
    

endmodule