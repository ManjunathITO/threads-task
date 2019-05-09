package training_Collection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class noOccurencesInFile_task 
{
   public static void main(String[] args)
   {
	   
	   Scanner sc1 = new Scanner(System.in);
	   String path, word;
	   System.out.println("Enter a path");
	   path = sc1.nextLine();
	  // System.out.println("Enter the word");
	   //word = sc1.nextLine();
	   //sc1.close();
	   File f = new File(path);
	   BufferedReader br = null;
	   List<String> list = new ArrayList<String>();
	   try {
	   //Checking to see if its a .txt file
	   if(f.exists() && f.isFile() && f.getName().endsWith(".txt")){
	       br  = new BufferedReader(new FileReader(path));
	       String line;
	       while((line=br.readLine())!=null) {
	           String[] arr = line.split(" ");
	           for(String str : arr)
	           list.add(str);
	           }
	       System.out.println(list);
	       Iterator itr = list.iterator();
			while(itr.hasNext())
			{
				String s = (String) itr.next();
		System.out.println("Single text file, Frequency = "+ s +" "+Collections.frequency(list, s)+ " times");			
				
				
			}
	       
	       }
	   }
	   
	   catch(IOException e) {
	    	    e.printStackTrace();
	       }
	   finally {
	       if(br!=null) {
	           try {
	               br.close();
	           } catch (IOException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	           }
	           }
	       }
	   
   }
   }
   

output
Enter a path
C:\Users\Manjunath Venkatesh\Documents\JAVA TRINING\task\test\file.txt
[I, am, java, I, am, a, programming, language., I, run, in, millions, of, computers]
Single text file, Frequency = I 3 times
Single text file, Frequency = am 2 times
Single text file, Frequency = java 1 times
Single text file, Frequency = I 3 times
Single text file, Frequency = am 2 times
Single text file, Frequency = a 1 times
Single text file, Frequency = programming 1 times
Single text file, Frequency = language. 1 times
Single text file, Frequency = I 3 times
Single text file, Frequency = run 1 times
Single text file, Frequency = in 1 times
Single text file, Frequency = millions 1 times
Single text file, Frequency = of 1 times
Single text file, Frequency = computers 1 times


