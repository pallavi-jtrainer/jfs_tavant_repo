package filesPkg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FilesDemoClass {
	
	public void objectReadAndWrite() {
		String path ="E:\\trainings\\iExcel\\Tavant\\10thfeb25\\dogs.txt";
		
		File file = new File(path);
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			
			os.writeObject(new Dog("Boxer", "Labrador"));
			os.close();
			fos.close();
			
			System.out.println("Reading an object");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream is = new ObjectInputStream(fis);
			Dog dog = (Dog )is.readObject();
			
			System.out.println(dog.toString());
			
			is.close();
			fis.close();
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public void readAndWriteToFiles() {
		String path ="E:\\trainings\\iExcel\\Tavant\\10thfeb25\\file2.txt";
		
		File file = new File(path);
		
		try {
			FileWriter writer = new FileWriter(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String data = br.readLine();
			
			writer.write(data);
			
			br.close();
			writer.close();
			
			
			FileReader reader = new FileReader(file);
			char[] array = new char[100];
			
			reader.read(array);
			System.out.println(array);
			
			reader.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void fileReadandWrite() {
		String path ="E:\\trainings\\iExcel\\Tavant\\10thfeb25\\file1.txt";
		
		String str = "This is data to be written into file";
		
		File file = new File(path);
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			
			byte[] data = str.getBytes();
			
			fos.write(data);
			fos.close();
			
			FileInputStream fis = new FileInputStream(file);
			
			int i = fis.read();
			System.out.println("Reading File");
			while(i != -1) {
				System.out.print((char)i);
				i = fis.read();
			}
			
			fis.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
