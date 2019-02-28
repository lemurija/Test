
public class XYZ {
    public static void main(String[] args) {
        int x = -712;
        int line = 1;
        
        while (x<8){
            if(x%4==0){
                if(x%5==0)
                    System.out.print("Z");
                else
                    System.out.print("X");
            }else{
                if(x%5==0)
                    System.out.print("Y");
                else
                    System.out.print(x);
            }
            System.out.print(", ");
            if(line>20){
                System.out.println();
                line=1;
            }
            x+=1;
            line+=1;
        }
    }
}
