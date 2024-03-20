public class Formel {
    

    public static double berechne(double x, double n, double xo){
        
        if(n<0){System.out.println("n muss größer 0 sein");return (Double) null;}
        
        double loesung = 0;
        
        for (double k = 0; k <= n; k++){double fakk=k;
            if (k == 0){loesung += ((xo * xo) / (1)) * 1;}
            else{for (double i = n-1; i > 0; i--){fakk = fakk * i;}}
            loesung += ((xo * xo) / (k)) * Math.pow((x - (xo * xo)), k); 
        }
        return loesung;
    }

    public static void main(String[] args) {
        System.out.println(berechne(3.0,4.0,5.0));
    }
}
