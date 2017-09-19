package be.steformations.af.javaweb.jpa.controlleur;

import java.util.ArrayList;
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
			List<LivreImpl > liste = this.bibliomanager.listerLivre(); 
			if(liste == null) {
				liste = new ArrayList<LivreImpl>();
			}
			param.put("LISTE_LIVRE",liste);
			
			return "/Livres.jsp";
		}
	
	
	

	
	}

