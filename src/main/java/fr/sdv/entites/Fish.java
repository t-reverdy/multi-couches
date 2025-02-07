package fr.sdv.entites;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "fish")
public class Fish extends Animal implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(name = "LIVING_ENV")
    private FishLivEnv livingEnv;

    public enum FishLivEnv {
        FRESH_WATER, SEA_WATER
    }

    public Fish() {}

    public Fish(LocalDate birth, String couleur, PetStore petStore, FishLivEnv livingEnv) {
        super(birth, couleur, petStore);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fish{");
        sb.append("livingEnv=").append(livingEnv);
        sb.append('}');
        return sb.toString();
    }
}
