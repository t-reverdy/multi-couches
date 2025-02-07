package fr.sdv.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "cat")
public class Cat extends Animal implements Serializable {

    @Column(name = "CHIP_ID")
    private String chipId;

    public Cat() {}

    public Cat(LocalDate birth, String couleur, PetStore petStore, String chipId) {
        super(birth, couleur, petStore);
        this.chipId = chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cat{");
        sb.append("chipId='").append(chipId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
