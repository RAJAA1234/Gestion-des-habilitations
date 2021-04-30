package org.sid.Gestion.des.habilitation.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @ToString
public class Environement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(length = 75)
    private  String nameEnv;
    @OneToMany(mappedBy = "environement")
    private Collection<Application> applicationns;

}
