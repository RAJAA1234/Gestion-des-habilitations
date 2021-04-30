package org.sid.Gestion.des.habilitation.repositories;

import org.sid.Gestion.des.habilitation.entites.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ApplicationRepository extends JpaRepository<Application,Long> {
}
