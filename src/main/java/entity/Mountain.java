package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString

@Entity
@Table (name = "mountains")
public class Mountain {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column( name = "mountain_id")
    private int id;
    @Column( name = "mountain_name", nullable = false)
    private String name;
    @Column( name = "mountain_country", nullable = false)
    private String country;
    @Column( name = "mountain_altitude", nullable = false)
    private int altitude;

    @OneToMany (mappedBy = "mountain")
    private List<ClimbingGroup> climbingGroups;

    public Mountain(){
        climbingGroups = new ArrayList<>();
    }
    public Mountain(String name, String country, int altitude) {
        if (country==null || name == null || name.length() < 4 || country.length() < 4 || altitude < 100 )
            throw new IllegalArgumentException("Неверные данные");

        this.name = name;
        this.country = country;
        this.altitude = altitude;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mountain mountain = (Mountain) o;

        if (id != mountain.id) return false;
        if (altitude != mountain.altitude) return false;
        if (!Objects.equals(name, mountain.name)) return false;
        return Objects.equals(country, mountain.country);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + altitude;
        return result;
    }
}
