package be.josimon.GSDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JOptionPane;
import be.josimon.GSPOJO.Client;
import be.josimon.GSPOJO.Personne;

public class PersonneDAO extends DAO<Personne>{	
	public PersonneDAO(Connection conn) {
		super(conn);
	}
	
	public boolean Create(Personne obj) {
		return false;
	}
	
	public boolean Delete(Personne obj) {
		return false;
	}


	public Personne Update(Personne obj) {
		return new Client();
	}


	public List<Personne> getAll(Personne obj) {
		return null;
	}

	public Personne Find(Personne obj) {
		// On cr�er un objet Personne
		Personne pr = new Personne();
		try {
			// On prepare la requete sql
			String sql = "SELECT * FROM Personne WHERE email=? AND motDePasse=?";
			PreparedStatement pS = this.connect.prepareStatement(sql);
			pS.setString(1,obj.getEmail());
			pS.setString(2, obj.getMotDePasse());
			// on execute la requete sql
			ResultSet result = pS.executeQuery();
			// On set les valeur sur l'ob
			if(result.next()) {
				pr.setIdPersonne(result.getInt("idPersonne"));
				pr.setNom(result.getString("nom"));
				pr.setPrenom(result.getString("prenom"));
				pr.setRue(result.getString("rue"));
				pr.setNumRue(result.getInt("numRue"));
				pr.setCp(result.getInt("cp"));
				pr.setVille(result.getString("Ville"));
				pr.setRole(result.getString("discriminator"));
				pr.setEmail(result.getString("email"));
				pr.setMotDePasse(result.getString("motDePasse"));
			}
			return pr;
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
			return null;
		}
	}

	@Override
	public List<Personne> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
