package fr.univrouen.rss25SB.model;

import java.time.OffsetDateTime;
import java.util.List;

import fr.univrouen.rss25SB.adapters.OffsetDateTimeAdapter;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
@Table(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @XmlElement(namespace = "http://univ.fr/rss25", required = true)
    private String guid;

    @Column(nullable = false)
    @XmlElement(namespace = "http://univ.fr/rss25", required = true)
    private String title;

    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private List<Category> categories;

    @XmlElement(namespace = "http://univ.fr/rss25")
    @XmlJavaTypeAdapter(OffsetDateTimeAdapter.class)
    private OffsetDateTime published;

    @XmlElement(namespace = "http://univ.fr/rss25")
    @XmlJavaTypeAdapter(OffsetDateTimeAdapter.class)
    private OffsetDateTime updated;

    @XmlTransient
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    @XmlTransient
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    private Content content;

    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private List<PersonType> authorsAndContributors;

    // Constructeur par défaut requis par JPA
    public Item() {}

    // Getters / Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<Category> getCategories() { return categories; }
    public void setCategories(List<Category> categories) { this.categories = categories; }

    public OffsetDateTime getPublished() { return published; }
    public void setPublished(OffsetDateTime published) { this.published = published; }

    public OffsetDateTime getUpdated() { return updated; }
    public void setUpdated(OffsetDateTime updated) { this.updated = updated; }

    public Image getImage() { return image; }
    public void setImage(Image image) { this.image = image; }

    public Content getContent() { return content; }
    public void setContent(Content content) { this.content = content; }

    public List<PersonType> getAuthorsAndContributors() { return authorsAndContributors; }
    public void setAuthorsAndContributors(List<PersonType> authorsAndContributors) {
        this.authorsAndContributors = authorsAndContributors;
    }
}