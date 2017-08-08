package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired
	private PaieUtils paieUtils;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {

		ResultatCalculRemuneration resultat = new ResultatCalculRemuneration();
		resultat.setSalaireDeBase(paieUtils.formaterBigDecimal(bulletin.getRemunerationEmploye().getGrade()
				.getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase())));

		resultat.setSalaireBrut(
				(new BigDecimal(resultat.getSalaireDeBase()).add(bulletin.getPrimeExceptionnelle())).toString());

		resultat.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(
				bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
						.filter(c -> c.getTauxSalarial() != null).map(c -> c.getTauxSalarial())
						.reduce(BigDecimal.ZERO, BigDecimal::add).multiply(new BigDecimal(resultat.getSalaireBrut()))));

		resultat.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(
				bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
						.filter(c -> c.getTauxPatronal() != null).map(c -> c.getTauxPatronal())
						.reduce(BigDecimal.ZERO, BigDecimal::add).multiply(new BigDecimal(resultat.getSalaireBrut()))));

		resultat.setNetImposable(paieUtils.formaterBigDecimal(new BigDecimal(resultat.getSalaireBrut())
				.subtract(new BigDecimal(resultat.getTotalRetenueSalarial()))));

		resultat.setNetAPayer(paieUtils.formaterBigDecimal(new BigDecimal(resultat.getNetImposable()).subtract((bulletin
				.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().stream()
				.filter(c -> c.getTauxSalarial() != null).map(c -> c.getTauxSalarial())
				.reduce(BigDecimal.ZERO, BigDecimal::add).multiply(new BigDecimal(resultat.getSalaireBrut()))))));

		return resultat;
	}

}
