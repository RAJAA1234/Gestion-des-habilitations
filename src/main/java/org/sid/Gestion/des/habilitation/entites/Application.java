package org.sid.Gestion.des.habilitation.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Application {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long ApplicationId;
    @Column(length = 75)
    private String nameApp;
    private String commentaire;

@ManyToOne
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private Environement environement;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private TypeEnvironement typeEnvironement;


}
