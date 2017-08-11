package dev.paie.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.service.RemunerationService;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	private RemunerationService remunerationService;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmploye() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("listEntreprises", remunerationService.findAllEntreprise());
		mv.addObject("listProfils", remunerationService.findAllProfilRemun());
		mv.addObject("listGrades", remunerationService.findAllGrade());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public String creerEmployePost(HttpServletRequest req) {

		String matricule = req.getParameter("matricule");
		String nomEntreprise = req.getParameter("entreprise");
		String codeProfil = req.getParameter("profil");
		String codeGrade = req.getParameter("grade");

		remunerationService.saveNewRemuneration(matricule, nomEntreprise, codeProfil, codeGrade);
		
		return "redirect:/mvc/employes/lister";

	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({"ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR"})
	public ModelAndView listerEmployes() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		mv.addObject("listEmployes", remunerationService.findAllRemuneration());

		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/logout")
    @Secured({ "ROLE_ADMINISTRATEUR", "ROLE_UTILISATEUR" })
    protected String logOut(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/mvc/connexion?logout";
    }
}