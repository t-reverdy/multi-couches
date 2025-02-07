package fr.sdv;

import fr.sdv.entites.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Execution {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("multi-couches");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Product produit1 = new Product("0001","Scooby Snack", Product.ProdType.FOOD,50.0);
        Product produit2 = new Product("0002","collier", Product.ProdType.ACCESSORY,20.0);
        Product produit3 = new Product("0003","litière", Product.ProdType.CLEANING,200.0);

        Address addresse1 = new Address("221b","Baker Street", "20000","London");
        Address addresse2 = new Address("121","Downing Street", "10000","London");
        Address addresse3 = new Address("5","Avenue Anatol", "75007","Paris");

        PetStore petStore1 = new PetStore("animalerie", "Wick", addresse1);
        PetStore petStore2 = new PetStore("DogCenter", "Smith", addresse2);
        PetStore petStore3 = new PetStore("Mon animal de compagnie", "Nolan", addresse3);
        //liaison petstore et products
        {
            petStore1.getProducts().add(produit1);
            petStore1.getProducts().add(produit2);
            petStore2.getProducts().add(produit2);
            petStore2.getProducts().add(produit3);
            petStore3.getProducts().add(produit3);
            petStore3.getProducts().add(produit1);
        }

        Animal animal1 = new Animal(LocalDate.of(2005,11,4),"Blanc",petStore1);
        Animal animal2 = new Animal(LocalDate.of(2020,5,10),"Blance et noir",petStore1);
        Animal animal3 = new Animal(LocalDate.of(2008,7,1),"Marron",petStore2);

        Cat cat1 = new Cat(LocalDate.of(2005,5,10),"Gris",petStore2,"10");
        Cat cat2 = new Cat(LocalDate.of(2010,4,25),"Blanc",petStore1,"25");
        Cat cat3 = new Cat(LocalDate.of(2019,2,28),"Noir",petStore3,"12");

        Fish fish1 = new Fish(LocalDate.of(2024,8,9),"Rouge",petStore3, Fish.FishLivEnv.FRESH_WATER);
        Fish fish2 = new Fish(LocalDate.of(2022,12,20),"Rouge",petStore2, Fish.FishLivEnv.SEA_WATER);
        Fish fish3  = new Fish(LocalDate.of(2023,10,30),"Jaune",petStore2, Fish.FishLivEnv.FRESH_WATER);
        //liaison
        {
            petStore1.getAnimals().add(animal1);
            petStore1.getAnimals().add(animal2);
            petStore1.getAnimals().add(cat2);
            petStore2.getAnimals().add(animal3);
            petStore2.getAnimals().add(cat1);
            petStore2.getAnimals().add(fish2);
            petStore2.getAnimals().add(fish3);
            petStore3.getAnimals().add(cat3);
            petStore3.getAnimals().add(fish1);
        }

        em.persist(petStore1);
        em.persist(petStore2);
        em.persist(petStore3);

        System.out.println(petStore1.getAnimals());

        tx.commit();
        em.close();
        emf.close();
    }
}
