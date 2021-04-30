package org.sid.Gestion.des.habilitation;

import org.sid.Gestion.des.habilitation.entites.Application;
import org.sid.Gestion.des.habilitation.entites.Environement;
import org.sid.Gestion.des.habilitation.entites.Habilitation;
import org.sid.Gestion.des.habilitation.entites.TypeEnvironement;
import org.sid.Gestion.des.habilitation.repositories.ApplicationRepository;
import org.sid.Gestion.des.habilitation.repositories.EnvironementRepository;
import org.sid.Gestion.des.habilitation.repositories.HabilitationRepository;
import org.sid.Gestion.des.habilitation.repositories.TypeEnvironementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Gestion  {

	public static void main(String[] args) {

		SpringApplication.run(Gestion.class, args);

	}
	@Bean
	CommandLineRunner start(ApplicationRepository applicationRepository,
							EnvironementRepository environementRepository,
							TypeEnvironementRepository typeEnvironementRepository, HabilitationRepository habilitationRepository, RepositoryRestConfiguration repositoryRestConfiguration) {

		return args -> {
			repositoryRestConfiguration.exposeIdsFor(Habilitation.class);
			Stream.of("Capgemini", "Client", "Tiers").forEach(nameEnv -> {
				Environement environement = new Environement();
				environement.setNameEnv(nameEnv);

				environementRepository.save(environement);
			});
			Stream.of("Production", "tests").forEach(nameTypeEnv -> {
				TypeEnvironement typeEnvironement = new TypeEnvironement();
				typeEnvironement.setNameTypeEnv(nameTypeEnv);



				typeEnvironementRepository.save(typeEnvironement);
			});
			environementRepository.findAll().forEach(env ->
					 typeEnvironementRepository.findAll().forEach(type_env -> {

				Application application = new Application();
				application.setCommentaire("");
				application.setEnvironement(env);
				application.setTypeEnvironement(type_env);


				application.setNameApp("App");
				applicationRepository.save(application);
			}));

			applicationRepository.findAll().forEach(application ->

					{
						Habilitation habilitation=new Habilitation();
						habilitation.setDateDerniereRevueColl(new Date());
						habilitation.setDateMiseAjourMatrice(new Date());
						habilitation.setApplication(application);

						habilitationRepository.save(habilitation);



					}






					);

		};


	}}


