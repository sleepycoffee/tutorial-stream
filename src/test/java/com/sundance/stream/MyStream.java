package com.sundance.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.log4j.Logger;

public class MyStream {

	/** log4j instance. **/
	protected static final Logger LOGGER = Logger.getLogger(MyStream.class);

	public static void main(String[] args)  {

		//		BufferedReader br = null;
		//
		//		try {
		//			br = new BufferedReader(new FileReader(new File("xanadu.txt")));
		//
		//			String line = null;
		//			while((line = br.readLine()) != null) {
		//				System.out.println(line);
		//			}
		//		} catch (FileNotFoundException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		} catch (IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		} finally {
		//			try {
		//				if (br != null) {
		//					br.close();				
		//				}
		//			} catch (IOException ex) { 
		//				LOGGER.warn("Could not close files."); 
		//			}
		//		}	

		int BUFFER_SIZE = 10;
		BufferedInputStream bi = null;
		BufferedOutputStream bo = null;
		OutputStream outputStream = null;
		try {
			bi = new BufferedInputStream(new FileInputStream(new File("src/test/resources", "xanadu.txt")));
			bo = new BufferedOutputStream(new FileOutputStream(new File("src/test/resources", "outagain.txt")));
			byte [] bytes = new byte[BUFFER_SIZE]; 
			int count;
			outputStream = new ByteArrayOutputStream( );
			while((count = bi.read(bytes, 0, BUFFER_SIZE)) != -1) {
				bo.write(bytes, 0, count);
				System.out.println(bytes.length);
				outputStream.write(bytes,0, count);
			}
			System.out.println(outputStream.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bi != null) {
					bi.close();				
				}
				if (bo != null) {
					bo.close();				
				}
				if (outputStream != null) {
					outputStream.close();				
				}
			} catch (IOException ex) { 
				LOGGER.warn("Could not close files."); 
			}
		}	

		//		BufferedReader br = null;
		//		BufferedWriter bw = null;
		//		
		//		try {
		//			br = new BufferedReader(new FileReader(new File("src/main/resources", "xanadu.txt")));
		//			bw = new BufferedWriter(new FileWriter(new File("src/main/resources", "outagain.txt")));
		//			
		//			String line;
		//			while((line = br.readLine()) != null) {
		//				bw.write(line);
		//				bw.newLine();
		//				LOGGER.info(line);
		//			}
		//		} catch (FileNotFoundException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		} catch (IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		} finally {
		//			try {
		//				if (br != null) {
		//					br.close();				
		//				}
		//				if (bw != null) {
		//					bw.close();				
		//				}
		//			} catch (IOException ex) { 
		//				LOGGER.warn("Could not close files."); 
		//			}
		//		}	


		//		Scanner scanner = null;
		//
		//		try {
		//			scanner = new Scanner(new BufferedReader(new FileReader(new File("src/test/resources", "xanadu.txt"))));
		//			scanner.useDelimiter(",");
		//			
		//			while (scanner.hasNext()) {
		//				System.out.println(scanner.next().trim());
		//			}
		//		} catch (FileNotFoundException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		} finally {
		//			if (scanner != null) {
		//				scanner.close();
		//			}
		//		}

	}

}

