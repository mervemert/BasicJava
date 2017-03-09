package calculating.and.sorting.example;

import java.util.Scanner;

public class CalculatingAndSortingExample {
	
	public static void main(String[] args) {
		int select;
		screen();
		
			
		do {
			select = getValue();
			
			switch(select) {
			case 1:
			fibonacci();
			System.out.println("\n::END OF FIBONACCI");
			break;
			
			case 2:
			findingE();
			System.out.println("::END OF FINDING " + "\"E\"");
			break;
			
			case 3:
			arctanx();
			System.out.println("\n::END OF ARCTAN(X)");
			break;
			
			case 4:
			sorting();
			System.out.println("\n::END OF SORTING");
			break;
			
			case 5:
			exit();
			break;
			
			default:
			getValue();
			break;
			}	
		} while(select!=5);
			
	}		
	
	public static void screen() {
		System.out.println("-------------------------------");
		System.out.println("1. Fibonacci\n" +
						   "2. Finding" + " " + "\"e\"\n" +
				           "3. Arctan(x)\n" +
						   "4. Sorting\n" +
				           "5. Exit" );
		System.out.println("-------------------------------");
		
	  }
		
	
	public static int getValue() {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("New Selection?:_");
		int s = scn.nextInt();
		return s;		
		}		
	
	
	
	public static void fibonacci() {
		Scanner scn = new Scanner(System.in);
		System.out.print("Selection?:1 ");
		int n = scn.nextInt();
		fib(n);
	}	
			
		//The method for the finding the Fibonacci number	
		 	public static void fib(int n) {
		 		
		 	//Create an array to hold Fibonacci numbers that is called "f"//
		 	int[] f = new int [n]; 
		 			
		 	int tempFib = 0; 
		 	int f0 = 0, f1 = 1;
		 			
		 	if(n == 0) System.out.print("::Fibonacci::" + " " +f0);
		 	
		 	else {
		 	
		 		for (int i = 0; i < n; i++) {
		 			f[i] = f0;
		 			tempFib = f0+f1;
		 			f0 = f1;
		 			f1 = tempFib; 
		 		}
				      
		 	// Display the Fibonacci numbers	   
		 	System.out.print("::Fibonacci::" + " ");
				
		 	for (int i = 0; i < n; i++) {
		 		System.out.print(f[i] + " ");
				}
		 	}		
		 }			  
	
	public static void findingE() {
		int runs = 0; //number of runs
	    double temp;
	    double value; //average run length
	 
		
	    Scanner scn = new Scanner(System.in);
		System.out.print("::Selection?:2" + " " );
		int n = scn.nextInt();
		
		//Exiting only when a negative integer is entered
		if(n < 0) exit();
		
		//Create an array to hold random numbers that is called "array"
		double array [] = new double [n];
		
		System.out.print("::Finding " +  "\"e\":: "); 
		for(int i = 0; i < n; i++) {
		  array [i] = Math.random(); // Generate n random numbers in [0,1) 
		  System.out.format(" %.2f"+ " ",array[i]);
		}   
		        
		int i=0;
		while(i < array.length-1) {
			temp = array[i] + array[i+1] ;
	    	array[i+1] = temp;
	    	i++;
	    	 
	    	if (temp >= 1.0){
	    	  runs++;
	    	  i++;
	    	}
	     }	 
		
		System.out.println("\n::Number of runs: " +runs);
		value = (array.length)/(double)runs;
	    System.out.format("::Average run length: " + "%.5f\n",+value); 
	
	}
	
	
	public static void arctanx() {
		Scanner scn = new Scanner(System.in);
		System.out.print("::Selection?:3 ");
		
		try {
			double x = scn.nextDouble();
			int y = 1; // For the powers and denominators 
			int n = 0;
			double result = 0; //For the compute approximated value
			
			 
		 	
			//Compute for the first six terms
			for (int i = 1; i <= 3 ; i++) { 
				n++;
				y = (2*n-1);
			
				if(n % 2 == 0)   
					result -= computePower(x,y)/y;
				else
					result += computePower(x,y)/y;	
				}	
				
			System.out.format("::Arctan(x) :: " + "%.6f" + " " ,+result);
			System.out.format("\n::Real value: " + "%.7f", +Math.atan(x));
		
			} catch (RuntimeException e) { // Handle the condition when s is not a string.
				System.out.print("Incorrect input : a double is required" );
				
	      }
	}
	
			public static double computePower (double x,int y) {
				double num = 1;
		
				for (int i = 1; i <= y; i++)
				  num *= x;
		        return  num;
		    }
	
	
	public static void sorting() {
		Scanner scn = new Scanner(System.in);

		
		int array[]; // Keep n random numbers
		int temp;
		
		System.out.print("Selection?:4" + " ");
		int n = scn.nextInt(); // For creating n random numbers
		array = new int[n];
		int m = scn.nextInt(); // For limiting the maximum number
			
		for (int i = 0; i < n; i++) {
			array[i] = (int)(Math.random()*m); 
		}
		
		//Display the entering numbers
		System.out.print("::Original number array: ");
		
		for(int i = 0; i < n; i++) {
			System.out.print(array[i] + ",");
		}
		
		for (int j = 1; j < n; j++) 
		{
			for (int i = 0; i < n-j; i++) 
			{
				if (array[i] > array[i+1])
				{
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
		}
		
		//Display the sorted numbers
		System.out.print("\n::Sorting number array: ");
		
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + ",");
		}
	 }	
	
	public static void exit(){
		System.out.println("EXIT!");
		System.exit(0); // 
	}

}
