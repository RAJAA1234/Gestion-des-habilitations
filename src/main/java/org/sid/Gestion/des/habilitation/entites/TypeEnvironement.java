package org.sid.Gestion.des.habilitation.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class TypeEnvironement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String nameTypeEnv;

    @OneToMany(mappedBy = "typeEnvironement")
    private Collection<Application> applicationns;
}
