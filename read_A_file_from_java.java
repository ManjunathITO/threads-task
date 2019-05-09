import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestOccurances {

public static void main(String[] args) {
Scanner sc1 = new Scanner(System.in);
String path, word;
System.out.println("Enter a path");
path = sc1.nextLine();
System.out.println("Enter the word");
word = sc1.nextLine();
sc1.close();
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
    System.out.println("Single text file, Frequency = "+Collections.frequency(list, word));
    }
//Checking to see if its a folder
if(f.exists() && f.isDirectory()) {
    File[] allfiles = f.listFiles();
    List<File>  files= new ArrayList<File>();
    for(File f1 : allfiles) {
        if(f1.getName().endsWith(".txt"))
            files.add(f1);
    }
    //Loop through each text file and do the same as above
    for(File file : files) {
        List<String> occurances = new ArrayList<String>();
        br = new BufferedReader(new FileReader(file.getPath()));
        String line;
        while((line=br.readLine())!=null) {
            String[] arr = line.split(" ");
            for(String str : arr)
            occurances.add(str);
            }
        System.out.println("File path :"+file.getName()+" , Frequency = "+Collections.frequency(occurances, word));
        }
    }
}catch(IOException e) {
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