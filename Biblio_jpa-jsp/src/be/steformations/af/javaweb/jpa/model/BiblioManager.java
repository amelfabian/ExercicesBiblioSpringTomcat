package be.steformations.af.javaweb.jpa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import be.steformations.java_data.biblio.interfaces.Auteur;
import be.steformations.java_data.biblio.interfaces.Collection;
import be.steformations.java_data.biblio.interfaces.GestionnaireBibliotheque;
import be.steformations.java_data.biblio.interfaces.Livre;
import be.steformations.pc.java_data.biblio.beans.AuteurImpl;
import be.steformations.pc.java_data.biblio.beans.CollectionImpl;
import be.steformations.pc.java_data.biblio.beans.LivreImpl;
import be.steformations.pc.java_data.biblio.dao.jpa.JpaGestionnaireBibliotheque;

@org.springframework.stereotype.Service
@org.springframework.context.annotation.Scope("application")
public class BiblioManager {

	protected JpaGestionnaireBibliotheque dao;
	protected EntityManager em;

	public BiblioManager() {
		this.em = Persistence.createEntityManagerFactory("postgresql_eclipselink").createEntityManager();
		this.dao = new JpaGestionnaireBibliotheque(em);

	}

	public List<LivreImpl> listerLivre() {
		return this.dao.getAllLivres();
	}

	public List<AuteurImpl> listerAuteurs() {
		return this.dao.getAllAuteurs();
	}

	public List<CollectionImpl> listerCollections() {
		return this.dao.getAllCollections();

	}

	public Livre addLivre(String titre, short nombreDePages, Date dateDeParution, int idCollection, short numeroEdition,
			List<Integer> auteurs) {
		return this.dao.addLivre(titre, nombreDePages, dateDeParution, idCollection, numeroEdition, auteurs);

	}

	public Auteur addAuteur(String prenom, String nom) {
		return this.dao.addAuteur(prenom, nom);
	}

	public Collection addCollection(String nom) {
		return this.dao.addCollection(nom);
	}

	public void DeleteLivre(String code) {
		this.dao.removeLivre(code);
	}

	public void delAuteur(String id) {
		this.dao.removeAuteur(Integer.parseInt(id));
	}

	public void DeleteCollection(int code) {
		this.dao.removeCollection(code);
		;
	}

}
