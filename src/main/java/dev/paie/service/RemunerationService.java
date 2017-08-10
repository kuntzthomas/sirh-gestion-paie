package dev.paie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;

@Service
public class RemunerationService {

	@Autowired
	private EntrepriseRepository repoEntreprise;

	@Autowired
	private ProfilRemunerationRepository repoProfilREmuneration;

	@Autowired
	private GradeRepository reporGrade;

	public Entreprise getEntrepriseWithName(String nomEntreprise) {

		return repoEntreprise.findOneByDenomination(nomEntreprise);

	}

	public ProfilRemuneration getProfilWithCode(String codeProfil) {

		return repoProfilREmuneration.findOneByCode(codeProfil);

	}

	public Grade getGradeWithCode(String codeGrade) {

		return reporGrade.findOneByCode(codeGrade);

	}

}
