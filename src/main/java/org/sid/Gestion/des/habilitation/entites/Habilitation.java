package org.sid.Gestion.des.habilitation.entites;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;


import javax.persistence.*;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString

public class Habilitation {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Boolean matrice;
    private  Boolean miseAjourMatrice;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    private Date dateMiseAjourMatrice;
    private String PeriodiciteRevueMatrice;
    private  String periodiciteRevueCollaborateurs;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    private  Date dateDerniereRevueColl;
    private  String attachementFichier;
    private  String commentaire;



    @OneToOne(fetch = FetchType.LAZY)
    private Application application;








}
