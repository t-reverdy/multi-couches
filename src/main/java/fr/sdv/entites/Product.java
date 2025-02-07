package fr.sdv.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "LABEL")
    private String label;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private ProdType type;

    @Column(name = "PRICE")
    private double price;

    @ManyToMany(mappedBy = "products",cascade = CascadeType.ALL)
    private Set<PetStore> petStore;

    public enum ProdType {
        FOOD, ACCESSORY, CLEANING
    }

    public Product() {}

    public Product(String code, String label, ProdType type, double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStore() {
        return petStore;
    }

    public void setPetStore(Set<PetStore> petStore) {
        this.petStore = petStore;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", label='").append(label).append('\'');
        sb.append(", type=").append(type);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
