package common;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class FileSystemDB {
	
	public static long searchTime;
	public static boolean flag = false;

	public static void main(String[] args) {
		
		displayFileSystemDB();
		
		String userDetails[] = new String[7];
		userDetails[0] = "12345";
		userDetails[1] = "Samaasw";
		userDetails[2] = "Samaasc";
		userDetails[3] = "Samaass";
		userDetails[4] = "Samaasf";
		userDetails[5] = "Srinivasg";
		userDetails[6] = "Srinivasb";
	
		FileSystemDB.insertIntoFileSystemDB(userDetails);
		search(11);
		
		
	}
	
	public static long insertIntoFileSystemDB(String userDetails[]) {
		long startTime = System.nanoTime();
		try {
			
			FileWriter fileWriter = new FileWriter("/home/shashanksoni092/eclipse-workspace/IMDB/src/resources/test.csv", true);
			CSVWriter object = new CSVWriter(fileWriter);
			object.writeNext(userDetails);
					
			object.close();
			fileWriter.close();
			
			long endTime = System.nanoTime();
			System.out.println((endTime-startTime)/1000 + " µs");
			return (endTime-startTime);
		

		} catch (IOException e) {
			e.printStackTrace();
		}return 0L;
	}		
	
	public static String[] search(int userId) {
		long startTime = System.nanoTime();
		FileReader file;
		try {
			file = new FileReader(new File("/home/shashanksoni092/eclipse-workspace/IMDB/src/resources/test.csv"));
			CSVReader object = new CSVReader(file);
			
			String record[] = new String[7];
			record=object.readNext();
			while((record = object.readNext()) != null) {
			
				
				System.out.println("Hello "+record[0] + " " + record[1] + " " + record[2]);
				
				if((Integer.parseInt(record[0])) == userId) {
					flag = true;
					//record[8] = "found";
					long endTime = System.nanoTime();
					searchTime = (endTime-startTime)/1000;

					System.out.println("found");
					System.out.println(record[0] + " " + record[1] + " " + record[2]);
					System.out.println(endTime-startTime);
					break;
				}
				else {
					flag = true;
					long endTime = System.nanoTime();
					searchTime = (endTime-startTime)/1000;

					
					System.out.println("not found");
					System.out.println(endTime-startTime);
					
				}
				
					
			}
			
			object.close();
			return record;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public static long displayFileSystemDB() {
		long startTime = System.nanoTime();
		try {
				File file = new File("/home/shashanksoni092/eclipse-workspace/IMDB/src/resources/test.csv");

				FileReader fileReader = new FileReader(file);
				CSVReader object = new CSVReader(fileReader);
		
				String userDetails[] = new String[10];
				while((userDetails = object.readNext()) != null) {
					for(String count : userDetails) {
						System.out.print(count + " ");
					}
					System.out.println();
				}
				object.close();
		
				long endTime = System.nanoTime();
				System.out.println((endTime-startTime)/1000 + " µs");
				return (endTime-startTime);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return 0L;	
	}
}