package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString

@Entity
@Table (name = "alpinists")
public class Alpinist {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column ( name = "alpinist_id")
    int id;
    @Column( name = "alpinist_name",nullable = false)
    String name;
    @Column ( name = "alpinist_address",nullable = false)
    String address;
    @Column  ( name = "alpinist_age",nullable = false)
    int age;

    @ManyToMany( mappedBy ="alplist")
    private List<ClimbingGroup> climbingGroups;


   public Alpinist(){
       climbingGroups = new ArrayList<>();
   }
   public Alpinist(String name, String address, int age){
        if ( name == null || address == null ||name.length() < 3 || address.length() < 5 || age <16)
            throw new IllegalArgumentException("Ошибка данных");
        this.name = name;
        this.address = address;
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alpinist alpinist = (Alpinist) o;

        if (id != alpinist.id) return false;
        if (age != alpinist.age) return false;
        if (!Objects.equals(name, alpinist.name)) return false;
        return Objects.equals(address, alpinist.address);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}