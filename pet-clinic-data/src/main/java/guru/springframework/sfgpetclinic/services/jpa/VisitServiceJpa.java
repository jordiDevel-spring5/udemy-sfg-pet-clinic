package guru.springframework.sfgpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import guru.springframework.sfgpetclinic.services.VisitService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile("jpa")
public class VisitServiceJpa implements VisitService {
	
	private final VisitRepository visitRepository;

	public VisitServiceJpa(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@Override
	public Visit findById(Long id) {
		log.debug("[VisitServiceJpa] - findById method has been called");
		
		return this.visitRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Visit> findAll() {
		log.debug("[VisitServiceJpa] - findAll method has been called");
		
		Set<Visit> visitSet = new HashSet<>();
		
		this.visitRepository.findAll().forEach(visitSet::add);
		
		return visitSet;
	}

	@Override
	public Visit save(Visit t) {
		log.debug("[VisitServiceJpa] - save method has been called");
		
		return this.visitRepository.save(t);
	}

	@Override
	public void delete(Visit t) {
		log.debug("[VisitServiceJpa] - delete method has been called");
		
		this.visitRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		log.debug("[VisitServiceJpa] - deleteById method has been called");
		
		this.visitRepository.deleteById(id);
	}

}
