import java.util.Arrays;
import java.util.Scanner;


public class Div297B {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i=0;i<n;i++)a[i]=sc.nextInt();
        Arrays.sort(a);
        if (n<4){
            System.out.println(0);
            return;
        }
        long ans=0;
        long l=-1;
        long w=-1;
        for (int i=n-1;i>=0;){
            if (i>0){
                //System.out.println(a[i]+" "+a[i-1]);
                if (a[i]-a[i-1]<=1){
                    if (l==-1)l=a[i-1];
                    else if (w==-1)w=a[i-1];
                    if (l!=-1 && w!=-1) {
                        ans+=l*w;
                        l=-1;
                        w=-1;
                    }
                    i-=2;
                }
                else i--;
            }
            else i--;
        }
        System.out.println(ans);

    }

}