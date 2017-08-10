package dev.paie.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		Avantage avantage = new Avantage("test", "test", 100);
		// sauvegarder un nouvel avantage
		avantageRepository.save(avantage);
		// vérifier qu'il est possible de récupérer le nouvel avantage via
		// la méthode findOne.

		assertThat(avantageRepository.findOne(avantage.getId()).equals(avantage));
		// modifier un avantage
		Avantage updatedAvantage = avantageRepository.findOne(avantage.getId());
		updatedAvantage.setId(avantage.getId());
		updatedAvantage.setCode("uptest");
		updatedAvantage.setMontant(120);
		updatedAvantage.setNom("testup");
		avantageRepository.save(updatedAvantage);
		// vérifier que les modifications sont bien prises en compte via la
		// méthode findOne
		assertThat(avantageRepository.findOne(updatedAvantage.getId()).equals(updatedAvantage));
	}
}
