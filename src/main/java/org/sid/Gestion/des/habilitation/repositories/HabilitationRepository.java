package org.sid.Gestion.des.habilitation.repositories;

import org.sid.Gestion.des.habilitation.entites.Habilitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HabilitationRepository extends JpaRepository<Habilitation,Long> {

}
