package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table
public class ClimbingGroup {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private boolean complectationIsOn = true;

    // В одну группу входит несколько альпинистов
    @OneToMany (mappedBy = "climbingGroup",fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List <Alpinist> alplist;
   //  одна группа восходит на одну гору
    @OneToOne(cascade = CascadeType.PERSIST)
    private Mountain mountain;
    private LocalDateTime climbTime;

    public ClimbingGroup(){
        alplist = new ArrayList<>();
    }

    public boolean isComplectationIsOn() {
        return complectationIsOn;
    }

    public void setComplectationIsOn(boolean complectationIsOn) {
        this.complectationIsOn = complectationIsOn;
    }

    public List<Alpinist> getAlplist() {
        return alplist;
    }

    public void setAlplist(List<Alpinist> alplist) {
        this.alplist = alplist;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
    }

    public LocalDateTime getClimbTime() {
        return climbTime;
    }

    public void setClimbTime(LocalDateTime climbTime) {
        this.climbTime = climbTime;
    }
}
