package it.antani.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.antani.entity.Record;

public abstract class DBFuoricittaDao {

	private static final String host = "jdbc:mysql://localhost:3306/dbfuoricitta?serverTimezone=UTC";
	private static final String user = "root";
	private static final String pass = "445566";
	
	public static void insertRecord(Record record) throws SQLException {
		try(Connection connection = DriverManager.getConnection(host, user, pass)) {
			
			String sql = "INSERT INTO record (codice, descrizione, scadenza, valore, percorso_file, dimensione)"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, record.getCodice());
			preparedStatement.setString(2, record.getDescrizione());
			preparedStatement.setString(3, record.getScadenza());
			preparedStatement.setDouble(4, record.getValore());
			preparedStatement.setString(5, record.getDir());
			preparedStatement.setString(6, record.getDimensioneFile());
			
			preparedStatement.executeUpdate();
		}
	}
	
}
