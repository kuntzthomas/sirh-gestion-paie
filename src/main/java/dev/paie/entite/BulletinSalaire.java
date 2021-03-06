package dev.paie.entite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BulletinSalaire {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	private RemunerationEmploye remunerationEmploye;

	@ManyToOne
	private Periode periode;

	private BigDecimal primeExceptionnelle;

	private LocalDateTime dateCreation;

	public BulletinSalaire() {
		super();
	}

	public BulletinSalaire(RemunerationEmploye remunerationEmploye, Periode periode, BigDecimal primeExceptionnelle) {
		this.id = id;
		this.remunerationEmploye = remunerationEmploye;
		this.periode = periode;
		this.primeExceptionnelle = primeExceptionnelle;
		this.dateCreation = LocalDateTime.now();
	}

	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}

	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}

	public Periode getPeriode() {
		return periode;
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}

	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
