package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;

@ContextConfiguration(classes = { ServicesConfig.class, DataSourceMySQLConfig.class })

@Repository
public class GradeServiceJdbcTemplate implements GradeService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO grade (code, nbheuresbase, tauxbase) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());

	}

	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE grade SET nbheuresbase=?, tauxbase=? WHERE code=?";
		jdbcTemplate.update(sql, grade.getNbHeuresBase(), grade.getTauxBase(), grade.getCode());

	}

	@Override
	public List<Grade> lister() {
		return jdbcTemplate.query("select * from grade", (result, rowNum) -> {
			Grade grade = new Grade();
			grade.setId(result.getInt("id"));
			grade.setCode(result.getString("code"));
			grade.setNbHeuresBase(result.getBigDecimal("nbheuresbase"));
			grade.setTauxBase(result.getBigDecimal("tauxbase"));
			return grade;
		});
	}

	@Override
	public void truncateTableGrade() {
		String sql = "TRUNCATE GRADE";
		jdbcTemplate.execute(sql);
	}

}
