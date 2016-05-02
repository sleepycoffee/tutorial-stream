package com.sundance.stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo
{
	public static void main(String [] args) {
		Employee e = null;
		try
		{
			FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(fileIn));

			System.out.println("Deserialized Employee...");
			for(int i = 0; i < 5; i++) {
				e = (Employee) in.readObject();
				System.out.println("Name: " + e.name);
				System.out.println("Address: " + e.address);
				System.out.println("SSN: " + e.SSN);
				System.out.println("Number: " + e.number);
			}

			in.close();
			fileIn.close();
		}catch(IOException i)
		{
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c)
		{
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}

	}
}
