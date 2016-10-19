import java.util.Scanner;
public class array2 {
 int []  a=new int[3];
    String []b=new String[3];
    String topper;
    int big;
public void display(){
   Scanner ob=new Scanner(System.in);

for(int i=0;i<a.length;i++)
 {
   System.out.println("enter name of the student of class array2");
   b[i]=ob.nextLine();
   System.out.println("enter "+b[i]+"'s marks");
   a[i]=ob.nextInt();
       ob.nextLine();
 
}	
   big=Math.max(a[0],Math.max(a[1],a[2]));
for(int i=0;i<b.length;i++)
{
 if(big==a[i]){
             topper=b[i];
             }
}
    
}
}
