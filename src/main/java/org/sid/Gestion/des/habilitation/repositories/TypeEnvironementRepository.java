package org.sid.Gestion.des.habilitation.repositories;

import org.sid.Gestion.des.habilitation.entites.TypeEnvironement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TypeEnvironementRepository extends JpaRepository<TypeEnvironement, Long> {
}
