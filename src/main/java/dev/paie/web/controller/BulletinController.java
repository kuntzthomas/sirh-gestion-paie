package dev.paie.web.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.service.BulletinService;

@Controller
@RequestMapping("/bulletins")
public class BulletinController {

	@Autowired
	private BulletinService bulletinService;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmploye() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("listPeriodes", bulletinService.findAllPeriodes());
		mv.addObject("listMatricules", bulletinService.findAllMatricules());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public String creerBulletinPost(HttpServletRequest req) {

		Integer periode = Integer.parseInt(req.getParameter("periode"));
		String matricule = req.getParameter("matricule");
		BigDecimal prime = new BigDecimal(req.getParameter("prime"));

		bulletinService.saveNewBulletin(matricule, periode, prime);

		return "redirect:/mvc/bulletins/lister";

	}
}
