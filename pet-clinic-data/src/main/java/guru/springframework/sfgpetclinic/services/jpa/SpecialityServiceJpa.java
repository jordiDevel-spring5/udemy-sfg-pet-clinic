package guru.springframework.sfgpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile("jpa")
public class SpecialityServiceJpa implements SpecialityService {

	private final SpecialityRepository specialityRepository;

	public SpecialityServiceJpa(SpecialityRepository specialityRepository) {
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Speciality findById(Long id) {
		log.debug("[SpecialityServiceJpa] - findById method has been called");
		
		return this.specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Speciality> findAll() {
		log.debug("[SpecialityServiceJpa] - findAll method has been called");
		
		Set<Speciality> specialitySet = new HashSet<>();
		
		this.specialityRepository.findAll().forEach(specialitySet::add);
		
		return specialitySet;
	}

	@Override
	public Speciality save(Speciality t) {
		log.debug("[SpecialityServiceJpa] - save method has been called");
		
		return this.specialityRepository.save(t);
	}

	@Override
	public void delete(Speciality t) {
		log.debug("[SpecialityServiceJpa] - delete method has been called");
		
		this.specialityRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		log.debug("[SpecialityServiceJpa] - deleteById method has been called");
		
		this.specialityRepository.deleteById(id);
	}
	
}
