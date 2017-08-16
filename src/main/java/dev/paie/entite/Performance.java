package dev.paie.entite;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Performance {

	@Id
	@GeneratedValue
	private Integer id;
	private String nomService;
	private LocalDateTime dateHeure;
	private Long tempsExecution;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomService() {
		return nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

	public LocalDateTime getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(LocalDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}

	public Long getTempsExecution() {
		return tempsExecution;
	}

	public void setTempsExecution(Long tempsExecution) {
		this.tempsExecution = tempsExecution;
	}

}
