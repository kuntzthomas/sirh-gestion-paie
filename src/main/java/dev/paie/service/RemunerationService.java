package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Service
public class RemunerationService {

	@Autowired
	private EntrepriseRepository repoEntreprise;
	@Autowired
	private ProfilRemunerationRepository repoProfilRemuneration;
	@Autowired
	private GradeRepository repoGrade;
	@Autowired
	private RemunerationEmployeRepository repoRemunerationEmploye;

	public Entreprise getEntrepriseWithName(String nomEntreprise) {

		return repoEntreprise.findOneByDenomination(nomEntreprise);

	}

	public ProfilRemuneration getProfilWithCode(String code) {

		return repoProfilRemuneration.findOneByCode(code);

	}

	public Grade getGradeWithCode(String code) {

		return repoGrade.findOneByCode(code);

	}

	public List<Entreprise> findAllEntreprise() {

		return repoEntreprise.findAll();
	}

	public List<ProfilRemuneration> findAllProfilRemun() {

		return repoProfilRemuneration.findAll();
	}

	public List<Grade> findAllGrade() {

		return repoGrade.findAll();
	}

	public List<RemunerationEmploye> findAllRemuneration() {

		return repoRemunerationEmploye.findAll();
	}

	public void saveNewRemuneration(String matricule, String nomEntreprise, String codeProfil, String codeGrade) {

		repoRemunerationEmploye.save(new RemunerationEmploye(matricule, getEntrepriseWithName(nomEntreprise),
				getProfilWithCode(codeProfil), getGradeWithCode(codeGrade)));
	}

}
