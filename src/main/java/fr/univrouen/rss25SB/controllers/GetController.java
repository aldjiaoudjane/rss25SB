package fr.univrouen.rss25SB.controllers;
import fr.univrouen.rss25SB.model.Item;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
@RestController
public class GetController {
@GetMapping("/resume")
public String getListRSSinXML() {
return "Envoi de la liste des flux RSS";
}
@GetMapping("/guid")
public String getRSSinXML(
@RequestParam(value = "guid") String texte) {
return ("Détail du flux RSS demandé : " + texte);
}
@GetMapping("/test")
public String getTest(@RequestParam(value = "nb") int guid, @RequestParam(value = "search") String titre) {
	return "Test :<br>guid = " + guid + "<br>titre = " + titre;
}
@RequestMapping(value = "/feed", produces = MediaType.APPLICATION_XML_VALUE)
public @ResponseBody Item getXML() {
    return new Item("12345678", "Test item", "2022-05-01T11:22:33");
}
}