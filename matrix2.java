package Data_Structures;

import java.util.Scanner;

public class matrix2 {
	public static void main(String[] args) {
		int a[][]=new int[3][3];
		int b[][]=new int[3][3];
		int c[][]=new int[3][3];
		int sum = 0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter data of two matrix of 3 x 3");
		System.out.println("Enter first Matrix Data");
		for(int i=0;i<3;i++) // row loop
		{
			for(int j=0;j<3;j++) 
			{
				a[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter second Matrix Data");
		for(int i=0;i<3;i++) // row loop
		{
			for(int j=0;j<3;j++) 
			{
				b[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<3;i++) // row loop
		{
			for(int j=0;j<3;j++) 
			{
				for(int k=0;k<3;k++) 
				{
					sum=sum+(a[i][k])*(b[k][j]);	
				}
				c[i][j]=sum;
				sum=0;
				
			}
		}
		System.out.println("Multiplication of two matrices in  java");
		for(int i=0;i<3;i++) // row loop
		{
			for(int j=0;j<3;j++) 
			{
				System.out.println(c[i][j]+" ");
			}
			System.out.println("\n");
		}
}
}