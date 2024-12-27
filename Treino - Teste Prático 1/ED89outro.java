import java.util.*;


public class ED89outro {

    public static void main (String[] args){

        int cont =0;

        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int flag = stdin.nextInt();

        int [] list = new int [101];

        for(int i=0; i<n;i++){

            stdin.nextInt();
            
            stdin.nextLine();
            stdin.nextLine();
            stdin.nextLine();
            
            int area = stdin.nextInt();
            
            int rendimentos = stdin.nextInt();
        

            //contagem dos diferentes
            if(list[area]==0){
                    cont++;
            }

            list[area]+=rendimentos;
        }


        if(flag==0){
            System.out.println(cont);
        }

        if(flag==1){
            for(int i=0; i<=100;i++){
                if(list[i]!=0){
                    System.out.println(i + " " + list[i]);
                }
            }
        }

    }


}