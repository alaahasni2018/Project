package connexionCS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnexion {
	
	public static void main (String[]args) {
		String url="jdbc:mysql://localhost:3306/esprit";
		String login="root";
		String pwd="";
		
		try {
		Connection cnx = DriverManager.getConnection(url,login,pwd);
		System.out.println("Connexion etablie !");
		
		
		////////////// Insertion //////////////////// 
		
		String requete = "INSERT INTO personne (nom,prenom) VALUES ('flouen','ben foulen')"; 
		Statement st = cnx.createStatement();
		st.executeUpdate(requete);
		System.out.println("Personne Ajoutée");
		
		
         //////////////INSERTION 2 ///////////////////////////
		
		//String requete2 = "INSERT INTO personne (nom,prenom) VALUES (?,?)"; 
		//PreparedStatement pst= cnx.prepareStatement (requete2); 
		//pst.setString(1, "Dupont");
		//pst.setString(2,"Julien"); 
		//pst.executeUpdate();
		//System.out.println("Personne 2 ajoutée");
		
		
	////////////// Update //////////////////// 
		
		String requeteUpd = "UPDATE  personne set nom=?,prenom=? where id=?"; 
		PreparedStatement pst2= cnx.prepareStatement (requeteUpd); 
		//pst2.setString(1, "X");
	//	pst2.setString(2,"YYY");
		//pst2.setInt(3, 1);
		//pst2.executeUpdate();
	//	System.out.println("Personne Modifiée");
		
		
////////////// Delete //////////////////// 
		
	String requeteDel = "DELETE  FROM personne  where id=?"; 
	PreparedStatement pst3= cnx.prepareStatement (requeteDel); 
	//pst3.setInt(1,1);
	
	//pst3.executeUpdate();
	//System.out.println("Personne Supprimée");
		
//////////////Affichage //////////////////// 
	
String requeteAff = "Select *  FROM personne "; 
Statement stt=cnx.createStatement();
ResultSet rs =stt.executeQuery(requeteAff);
System.out.println("////////////////////////////////");
while(rs.next()) {
	System.out.println("ID : "+rs.getInt (1));
	System.out.println("Nom : "+rs.getString (2));
	System.out.println("Prenom : "+rs.getString ("prenom"));
	System.out.println("**********");
}
		
		


		
	}catch (SQLException ex ) {
		System.err.println(ex.getMessage());
	}
	
	
	}}
	
