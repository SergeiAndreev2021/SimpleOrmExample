import entity.Alpinist;
import entity.ClimbingGroup;
import entity.Mountain;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;


public class Application {
    public static void main(String[] args) {
      try  ( EntityManagerFactory emf = Persistence.createEntityManagerFactory("myLesson")) {
          EntityManager manager = emf.createEntityManager();

          Alpinist alp1 = new Alpinist("Ivan", "Russia, Petersburg, Nevsky 29", 35);
          Alpinist alp2 = new Alpinist("Egor", "Russia, Petersburg, Bolshoi PS 12", 31);
          Alpinist alp3 = new Alpinist("Lamo", "Kongo, Barbudo, Lumumba sqare 2", 31);
          Alpinist alp4 = new Alpinist("Andrei", "Belarus, Gomel, Slivnevicha street 26", 20);


          Mountain mountain = new Mountain("Everest","Russia",1500);

          ClimbingGroup cg = new ClimbingGroup();
          cg.getAlplist().add(alp1);
          cg.getAlplist().add(alp2);
          cg.getAlplist().add(alp3);
          cg.getAlplist().add(alp4);
          cg.setMountain(mountain);
          cg.setClimbTime(LocalDateTime.now());
          if (cg.getAlplist().size()>=3) cg.setComplectationIsOn(false);


          manager.getTransaction().begin();
          manager.persist(alp1);
          manager.persist(alp2);
          manager.persist(alp3);
          manager.persist(alp4);
          manager.persist(cg);
          manager.persist(mountain);
          manager.getTransaction().commit();

      }

    }
}
