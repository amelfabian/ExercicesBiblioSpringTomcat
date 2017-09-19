package be.steformations.af.javaweb.jpa.controlleur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sun.xml.internal.stream.Entity;

import be.steformations.af.javaweb.jpa.model.BiblioManager;
import be.steformations.java_data.biblio.interfaces.GestionnaireBibliotheque;
import be.steformations.pc.java_data.biblio.beans.LivreImpl;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("request")
public class ControlleurLivre {

	@org.springframework.beans.factory.annotation.Autowired
	private BiblioManager bibliomanager;

	public ControlleurLivre() {

	}

	@org.springframework.web.bind.annotation.RequestMapping("listLivres")
	public String getListe(Map<String, Object> param) {
		List<LivreImpl> liste = this.bibliomanager.listerLivre();
		if (liste == null) {
			liste = new ArrayList<LivreImpl>();
		}
		param.put("LISTE_LIVRE", liste);

		return "/Livres.jsp";
	}

	@org.springframework.web.bind.annotation.RequestMapping("newLivres")
	public String createAndShowLivre(Map<String, Object> param,
			@org.springframework.web.bind.annotation.RequestParam("LIVRE_TITRE") String titre,
			@org.springframework.web.bind.annotation.RequestParam("LIVRE_NOMBREDEPAGES") short nombreDePages,
			@org.springframework.web.bind.annotation.RequestParam("LIVRE_DATEDEPARUTION") Date dateDeParution,
			@org.springframework.web.bind.annotation.RequestParam("LIVRE_IDCOLLECTION") int idCollection,
			@org.springframework.web.bind.annotation.RequestParam("LIVRE_NUMEROEDITION") short numeroEdition,
			@org.springframework.web.bind.annotation.RequestParam("LIVRE_AUTEUR") List<Integer> auteurs) {
		if (!titre.matches("[A-Za-z]")) {
			param.put("OK", this.bibliomanager.addLivre(titre, nombreDePages, dateDeParution, idCollection,
					numeroEdition, auteurs));

		} else {
			param.put("OK", null);

		}
		return this.getListe(param);

	}

	@org.springframework.web.bind.annotation.RequestMapping("delLivres")
	public String delLivres(Map<String, Object> param,
			@org.springframework.web.bind.annotation.RequestParam("ID") String code,
			@org.springframework.web.bind.annotation.RequestParam("DELETE") boolean del) {
		if (del && code.matches("^[0-9]*$"))
			this.bibliomanager.DeleteLivre(code);
		return this.getListe(param);

	}

}
