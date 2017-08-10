package dev.paie.service;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired
	private GradeRepository repoGrade;
	@Autowired
	private EntrepriseRepository repoEntreprise;
	@Autowired
	private ProfilRemunerationRepository repoProfilRemun;
	@Autowired
	private CotisationRepository repoCotisation;
	@Autowired
	private PeriodeRepository repoPeriode;

	@Override
	public void initialiser() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:grades.xml",
				"entreprises.xml", "profils-remuneration.xml", "cotisations-imposables.xml",
				"cotisations-non-imposables.xml")) {
			Map<String, Grade> grades = context.getBeansOfType(Grade.class);
			grades.values().stream().forEach(g -> repoGrade.save(g));

			Map<String, Entreprise> entreprises = context.getBeansOfType(Entreprise.class);
			entreprises.values().stream().forEach(e -> repoEntreprise.save(e));

			Map<String, Cotisation> cotisations = context.getBeansOfType(Cotisation.class);
			cotisations.values().stream().forEach(c -> repoCotisation.save(c));

			Map<String, ProfilRemuneration> profilsRemun = context.getBeansOfType(ProfilRemuneration.class);
			profilsRemun.values().stream().forEach(p -> repoProfilRemun.save(p));
		}

		IntStream.range(1, 13).forEach(mois -> {
			Periode periode = new Periode();
			periode.setDateDebut(LocalDate.of(Year.now().getValue(), mois, 1));
			periode.setDateFin(periode.getDateDebut().with(TemporalAdjusters.lastDayOfMonth()));
			repoPeriode.save(periode);
		});
	}

}
