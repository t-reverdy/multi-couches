package fr.sdv.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pet_store")
public class PetStore implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MANAGER_NAME")
    private String managerName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "COMPO",
            joinColumns = @JoinColumn(name = "PETSTORE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID"))
    private Set<Product> products;
    {
        products = new HashSet<Product>();
    }

    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private Set<Animal> animals;
    {
        animals = new HashSet<>();
    }

    public PetStore() {}

    public PetStore(String name, String managerName, Address address) {
        this.name = name;
        this.managerName = managerName;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PetStore{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", managerName='").append(managerName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
