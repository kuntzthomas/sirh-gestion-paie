package dev.paie.config.aspect;

import java.time.Duration;
import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import dev.paie.entite.Performance;
import dev.paie.repository.PerformanceRepository;

@Configuration
@Aspect
public class ControllerPerformanceAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerPerformanceAspect.class);
	
	@Autowired
	private PerformanceRepository repoPerf;
	@Around("execution(* dev.paie.web.controller.*.*(..))")
	public Object logPerf(ProceedingJoinPoint pjp) throws Throwable{
		
		LOGGER.debug("Debut d'exécution de la méthode " + pjp.getSignature().toString());
		
		LocalDateTime debutMethod = LocalDateTime.now();

		Object resultat = pjp.proceed();
		
		LOGGER.info("Fin d'exécution de la méthode");
		
		LocalDateTime finMethod = LocalDateTime.now();
		
		Performance performance = new Performance();
		performance.setNomService(pjp.getSignature().getName());
		performance.setDateHeure(debutMethod);
		performance.setTempsExecution(Duration.between(debutMethod, finMethod).toMillis());
		
		repoPerf.save(performance);
		
		return resultat;
	}
}
