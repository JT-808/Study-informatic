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



assign blink =  Tick 

    
endmodule