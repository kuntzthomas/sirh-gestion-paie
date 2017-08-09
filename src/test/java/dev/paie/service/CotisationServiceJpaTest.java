package dev.paie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		Cotisation cotisation = new Cotisation("test", "cotisation test", new BigDecimal(3.56), new BigDecimal(2.85));
		Cotisation UpdatedCotisation = new Cotisation("test", "cotisation update test", new BigDecimal(4.56),
				new BigDecimal(2.20));
		// sauvegarder une nouvelle cotisation
		cotisationService.sauvegarder(cotisation);
		// vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via laméthode lister
		assertThat(cotisationService.lister().contains(cotisation));
		// modifier une cotisation
		cotisationService.mettreAJour(UpdatedCotisation);
		// vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		assertThat(cotisationService.lister().contains(UpdatedCotisation));
	}
}