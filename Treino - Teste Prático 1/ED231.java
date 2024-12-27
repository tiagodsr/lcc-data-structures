import java.util.Scanner;

public class ED231{
    public static void main (String args[]){
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            int [] casos = new int[n];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;    

            for (int i=0; i<n; i++){
                casos[i] = input.nextInt();
            }
            int flag = input.nextInt();
            
            if (flag == 1){
                int aumento = 0;
                for(int i=0; i<n-1; i++){
                    aumento = casos[i+1] - casos [i];
                    if (aumento < min) min = aumento;
                    if (aumento > max) max = aumento;
                }
                System.out.print(min + " " + max);
                System.out.println();
            }
            else if (flag == 2) {
                int periodos = 0;   
                int counter = 0;
                boolean consec = false;
            
                for (int i = 0; i < n - 1; i++) {
                    double subPercentual = (double) (casos[i + 1] - casos[i]) / casos[i];
            
                    if (subPercentual <= 0.05) {
                        consec = true;
                        counter++;
                        if (counter > max) max = counter; 
                    }
                    else {
                        if (consec) periodos++;  
                        consec = false;         
                        counter = 0;          
                    }
                }
                if (consec) periodos++;
            
                System.out.print(periodos + " " + max); 
                System.out.println();
            }

            else{
                int maxAltura = 0; 
                int[] alturas = new int[n];
                for (int i = 0; i < n; i++) {
                    alturas[i] = casos[i] / 100;
                    if (alturas[i] > maxAltura) {
                        maxAltura = alturas[i];
                    }
                }
                for (int linha = maxAltura; linha > 0; linha--) {
                    for (int i = 0; i < n; i++) {
                        if (alturas[i] >= linha) System.out.print("#"); 
                        else System.out.print("."); 
                    }
                    System.out.println(); 
                }
            }
            input.close();
    }
}