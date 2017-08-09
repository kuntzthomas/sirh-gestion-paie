package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Repository
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
	}

	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {

		String codeUpdate = em.createQuery("select c.code from Cotisation c where c.code =:code", String.class)
				.setParameter("code", cotisation.getCode()).getSingleResult();
		if (codeUpdate != null) {
			em.merge(cotisation);
		}

	}

	@Override
	public List<Cotisation> lister() {
		return em.createNamedQuery("Cotisation.findAll", Cotisation.class).getResultList();
	}

}
