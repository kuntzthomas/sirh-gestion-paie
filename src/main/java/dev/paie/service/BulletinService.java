package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Service
public class BulletinService {

	@Autowired
	private BulletinSalaireRepository repoBulletin;
	@Autowired
	private PeriodeRepository repoPeriode;
	@Autowired
	private RemunerationEmployeRepository repoRemunerationEmploye;

	public Periode getPeriodeById(Integer id){
		
		return repoPeriode.findOneById(id);
	}
	
	public RemunerationEmploye getRemunerationEmployeByMatricule(String matricule){
		
		return repoRemunerationEmploye.findOneByMatricule(matricule);
	}
	
	public List<Periode> findAllPeriodes() {
		
		return repoPeriode.findAll();
	}

	public List<RemunerationEmploye> findAllMatricules() {
		
		return repoRemunerationEmploye.findAll();
	}
	
	public void saveNewBulletin(String matricule, Integer periode, BigDecimal prime) {

		repoBulletin.save(new BulletinSalaire(getRemunerationEmployeByMatricule(matricule),
				getPeriodeById(periode), prime));

	}

}
