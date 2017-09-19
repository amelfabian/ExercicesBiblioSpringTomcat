package be.steformations.af.javaweb.jpa.controlleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import be.steformations.af.javaweb.jpa.model.BiblioManager;
import be.steformations.pc.java_data.biblio.beans.AuteurImpl;
import be.steformations.pc.java_data.biblio.beans.CollectionImpl;

@org.springframework.stereotype.Controller 
@org.springframework.context.annotation.Scope("request") 
public class ControlleurCollections {

	@org.springframework.beans.factory.annotation.Autowired
	private BiblioManager bibliomanager;
	public ControlleurCollections() {
		// TODO Auto-generated constructor stub
	}
		@org.springframework.web.bind.annotation.RequestMapping("listCollections")
			public String getListe(Map<String,Object> param){
				List<CollectionImpl> liste = this.bibliomanager.listerCollections();
				if(liste == null){
					liste = new ArrayList<CollectionImpl>();
				}
				param.put("LISTE_COLLECTION", liste);
				return "/Collections.jsp";
			
		}
		
		@org.springframework.web.bind.annotation.RequestMapping("newCollection")
		public String createAndShowCollection(Map<String,Object> attribut,@org.springframework.web.bind.annotation.RequestParam("COLLECTION_NOM") String nom){
				
				if(!nom.matches("[A-Za-z]")){
					attribut.put("OK", this.bibliomanager.addCollection(nom));
				}else{
					attribut.put("OK", null);
				}
				return this.getListe(attribut);
}
		@org.springframework.web.bind.annotation.RequestMapping("delCollection")
		public String delAuteur(@org.springframework.web.bind.annotation.RequestParam("ID") String id,@org.springframework.web.bind.annotation.RequestParam("DELETE") boolean del, Map<String,Object> param){
			if(del && id.matches("^[0-9]*$")){
				this.bibliomanager.delAuteur(id);;
			}
			return this.getListe(param);
		}
}