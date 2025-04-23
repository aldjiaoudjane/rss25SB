package fr.univrouen.rss25SB.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.Resource;
import org.springframework.core.io.DefaultResourceLoader;

public class TestRSS {

    private Resource resource;

    public String loadFileXML() {
        try {
            resource = new DefaultResourceLoader().getResource("classpath:xml/item.xml");
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)
            );
            StringBuilder xmlContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                xmlContent.append(line);
            }
            reader.close();
            return xmlContent.toString();
        } catch (Exception e) {
            return "<error>Erreur lors du chargement du fichier XML : " + e.getMessage() + "</error>";
        }
    }
}