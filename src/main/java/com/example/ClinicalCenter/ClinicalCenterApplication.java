package com.example.ClinicalCenter;
import  java.sql.*;
import java.sql.Statement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicalCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicalCenterApplication.class, args);

		try{
			String host =  "jdbc:mysql://localhost:3306/?user=root";
			String uName = "root";
			String uPass = "Dragana123.";
			Connection con = DriverManager.getConnection(host, uName, uPass);

			Statement stnm = con.createStatement();
			String SQL = "SELECT * FROM pacijenti";

		} catch(SQLException err) {
			System.out.println(err.getMessage());
		}
	}

}
