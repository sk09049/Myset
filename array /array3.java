import java.util.Scanner;
public class array3 {
 String overalltopper;
   int []  a=new int[3];
    String []b=new String[3];
    String topper;
    int big;
public void display(){
   Scanner ob=new Scanner(System.in);
for(int i=0;i<a.length;i++)
 {
   System.out.println("enter name of the student of class array3");
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
    
    public static void main(String args[]){
        array3 ob=new array3();
        array2 ob1=new array2();
        array1 ob2=new array1();
        ob.display();
        ob1.display();
        ob2.display();
        int bigg[]={ob2.big,ob1.big,ob.big};//three classes top marks
        String []top={ob2.topper,ob1.topper,ob.topper};//respective three class toppers to above marks
        int biggest=Math.max(bigg[0],Math.max(bigg[1],bigg[2]));
       
        for(int i=0;i<top.length;i++){
            if(biggest==bigg[i]){
            ob.overalltopper=top[i];
            }
        }
        System.out.println("over all topper is: "+ob.overalltopper+" and his mark is :"+biggest);
        
    }
    
}
