/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
public class array1 {
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
System.out.println("tooper of the class is:"+topper+" and he scores "+big+" marks"); 
       }
    
}
