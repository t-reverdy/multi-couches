package fr.sdv.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "BIRTH")
    private LocalDate birth;

    @Column(name = "COULEUR")
    private String couleur;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PETSTORE_ID")
    private PetStore petStore;

    public Animal() {}

    public Animal(LocalDate birth, String couleur, PetStore petStore) {
        this.birth = birth;
        this.couleur = couleur;
        this.petStore = petStore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("id=").append(id);
        sb.append(", birth=").append(birth);
        sb.append(", couleur='").append(couleur).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
