
public class Random {
    public static void main(String[] args) {
        int amount = 100;
        int max=100;
        int line=1;
        int sum=0;
        
        while (amount>0){
            int x=(int)(Math.random()*max);
            sum+=x;
            System.out.print(x);
            System.out.print(", ");
            
            if(line>19){
                System.out.println();
                line=1;
            }
            amount-=1;
            line+=1;
        }
        
        System.out.println("\n\nTotal: "+sum);
        System.out.print("Average: "+(double)sum/100);
    }
}
