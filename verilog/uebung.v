module Aufgabe3 ();


assign HW_led[0] = blink;
wire blink;

reg[1:0] counter

 initial
    begin
      counter = 0;  
    end

always @(posedge clk )
begin
counter = counter+1;
end
assign blink = counter[1] // teile durch 2

endmodule


module Aufgabe 4();

assign HW_led[0] = blink;
wire blink = tick;

reg[2:0] counter;
reg tick;

always @(posedge clk )
begin
if (counter =4) 
begin
    counter =0;
    Tick = !tick;
end
counter =counter+1
end
    
endmodule



//Gatteruebungen

module bitwise;

reg [3:0] a = 4'b0110;
reg [3:0] b = 4'b1110;
reg [3:0] result_and, result_or, result_xor, result_not;

initial begin
  result_and = a & b;   // 4'b0110
  result_or  = a | b;   // 4'b1110
  result_xor = a ^ b;   // 4'b1000
  result_not = ~a;      // 4'b1001
end

endmodule


//shift-uebung

module shifting ();
reg clk ;
reg [2:0] counter
reg [7:0] zahl = 8'b10110110;
reg [7:0] result; 

initial begin
  clk =0;
  counter = 0;
result = zahl >>2; //8'b00101101
end

// nach 4 Zyklen aufhören
always @(posedge clk ) begin
  if(counter < 4)begin
      result = result << 1;        // Ergebnis nach links verschieben
      counter = counter + 1;       // Zähler erhöhen
  end
end
  
endmodule


