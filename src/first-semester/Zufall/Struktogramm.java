public class Struktogramm {
    public void bestimme(int[] uebergabeArr, int linksI, int mittelI, int rechtsI){
        int[] hilfsArray = new int[rechtsI-linksI +1];
        
        for(int i = 0; i < rechtsI-linksI +1; i++){
            hilfsArray[i] = uebergabeArr[i];
        }

        int idxL = linksI;
        int idxR = mittelI + 1;
        int i = 1;

        while(idxL <= mittelI && idxR <= rechtsI){
            if(uebergabeArr[idxL] < uebergabeArr[idxR]){
                hilfsArray[i] = uebergabeArr[idxL];
                idxL += 1;
                i += 1; 
            }else{
                hilfsArray[i] = uebergabeArr[idxR];
                idxR += 1;
            }

            if(idxL > mittelI){
                for(int j = 0; j <= rechtsI-idxR; j++){
                    hilfsArray[i+j] = uebergabeArr[idxR+j];
                }
            }else{
                for(int j = 0; j <= mittelI-idxL; j++){
                    hilfsArray[i+j]= uebergabeArr[idxL+j];
                }
            }

            for(int j = 0; j <= rechtsI - linksI; j++){
                uebergabeArr[linksI+j] = hilfsArray[j];
            }
        }
    }
}
