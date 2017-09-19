package be.steformations.af.javaweb.jpa.controlleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import be.steformations.af.javaweb.jpa.model.BiblioManager;
import be.steformations.pc.java_data.biblio.beans.AuteurImpl;

@org.springframework.stereotype.Controller 
@org.springframework.context.annotation.Scope("request") 
public class ControlleurAuteurs {
	@org.springframework.beans.factory.annotation.Autowired
	private BiblioManager bibliomanager;
	
	public ControlleurAuteurs() {
		// TODO Auto-generated constructor stub
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("listAuteurs")
	public String getListe(Map<String,Object> param){
		List<AuteurImpl> liste = this.bibliomanager.listerAuteurs();
		if(liste == null){
			liste = new ArrayList<AuteurImpl>();
		}
		param.put("LISTE_AUTEURS", liste);
		return "/Auteurs.jsp";
		
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("newAuteur")
	public String createAndShowAuteurs(Map<String,Object> attribut,@org.springframework.web.bind.annotation.RequestParam("AUTEUR_PRENOM") String prenom,@org.springframework.web.bind.annotation.RequestParam("AUTEUR_NOM") String nom){
			
			if(!nom.matches("[A-Za-z]") || !prenom.matches("[A-Za-z]")){
				attribut.put("OK", this.bibliomanager.addAuteur(prenom, nom));
			}else{
				attribut.put("OK", null);
			}
			return this.getListe(attribut);
		
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("delAuteur")
	public String delAuteur(@org.springframework.web.bind.annotation.RequestParam("ID") String code,@org.springframework.web.bind.annotation.RequestParam("DELETE") boolean del, Map<String,Object> param){
		if(del && code.matches("^[0-9]*$")){
			this.bibliomanager.delAuteur(code);
		}
		return this.getListe(param);
	}
}
