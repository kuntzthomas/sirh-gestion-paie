package dev.paie.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.RemunerationService;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	private GradeRepository repoGrade;
	@Autowired
	private EntrepriseRepository repoEntreprise;
	@Autowired
	private ProfilRemunerationRepository repoProfilRemun;
	@Autowired
	private RemunerationEmployeRepository repoRemunerationEmploye;
	@Autowired
	private RemunerationService remunerationService;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("listEntreprises", repoEntreprise.findAll());
		mv.addObject("listProfils", repoProfilRemun.findAll());
		mv.addObject("listGrades", repoGrade.findAll());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView creerEmployePost(HttpServletRequest req) {

		ModelAndView mv = new ModelAndView();

		String matricule = req.getParameter("matricule");
		String nomEntreprise = req.getParameter("entreprise");
		String codeProfil = req.getParameter("profil");
		String codeGrade = req.getParameter("grade");

		Entreprise entreprise = remunerationService.getEntrepriseWithName(nomEntreprise);
		ProfilRemuneration profil = remunerationService.getProfilWithCode(codeProfil);
		Grade grade = remunerationService.getGradeWithCode(codeGrade);

		repoRemunerationEmploye.save(new RemunerationEmploye(matricule, entreprise, profil, grade));

		mv.setViewName("employes/creerEmploye");

		return mv;

	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmployes() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmployes");
		mv.addObject("listeRenumEmployes", repoRemunerationEmploye.findAll());

		return mv;
	}
}