package dev.paie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class })

// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		Grade grade = new Grade("test", new BigDecimal(200.25), new BigDecimal(26.49));
		Grade UpdatedGrade = new Grade("test", new BigDecimal(500.25), new BigDecimal(26.50));
		// Sauvegarder un nouveau grade
		gradeService.sauvegarder(grade);

		// Vérifier qu'il est possible de récupérer le nouveau grade via la
		// méthode lister
		assertThat(gradeService.lister().contains(grade));

		// Modifier un grade
		gradeService.mettreAJour(UpdatedGrade);

		// Vérifier que les modifications sont bien prises en compte via la
		// méthode lister

		assertThat(gradeService.lister().contains(UpdatedGrade));
	}
}