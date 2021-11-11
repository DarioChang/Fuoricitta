package it.antani;

import it.antani.entity.Record;
import it.antani.models.DBFuoricittaDao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {
	//C:\Users\D\Desktop\antani\file.csv
	public static void main(String[] args) throws SQLException {
		
		try (Scanner scanner = new Scanner(System.in)){
			
			System.out.println("Inserisci la directory: ");
			
			String dir = scanner.next();
			
			File file = new File(dir);
			long dimensione = file.length();
			
			if (!file.exists()) {
				System.err.println("file non trovato");
				System.exit(0);
			}
			
			List<Record> righe = new ArrayList<>();
			
			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {	
				String linea;
				int contatore = 2;
				bufferedReader.readLine();
				
				while ((linea = bufferedReader.readLine()) != null) {					
					List<String> temp = new ArrayList<>(Arrays.asList(linea.split(";")));
					if(temp.size() < 4) {						
							System.err.println("Il file in: " + dir + " ha riscontrato un errore alla linea " + contatore);
							System.exit(1);
					}
					
					Record record = new Record(Integer.parseInt(temp.get(0)), temp.get(1), temp.get(2), 
							Double.parseDouble(temp.get(3)), dir, dimensione);
					
					righe.add(record);
					contatore++;
				}
				
				for (Record record : righe) {
					DBFuoricittaDao.insertRecord(record);
				}
				
				System.out.println("Sono state importate " + (contatore -2) + " righe dal file al DB.");
			
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}