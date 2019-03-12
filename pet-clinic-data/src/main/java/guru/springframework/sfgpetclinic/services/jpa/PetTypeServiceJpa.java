package guru.springframework.sfgpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile("jpa")
public class PetTypeServiceJpa implements PetTypeService {

	private final PetTypeRepository petTypeRepository;

	public PetTypeServiceJpa(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public PetType findById(Long id) {
		log.debug("[PetTypeServiceJpa] - findById method has been called");
		
		return this.petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public Set<PetType> findAll() {
		log.debug("[PetTypeServiceJpa] - findAll method has been called");
		
		Set<PetType> petTypeSet = new HashSet<>();
		
		this.petTypeRepository.findAll().forEach(petTypeSet::add);
		
		return petTypeSet;
	}

	@Override
	public PetType save(PetType t) {
		log.debug("[PetTypeServiceJpa] - save method has been called");
		
		return this.petTypeRepository.save(t);
	}

	@Override
	public void delete(PetType t) {
		log.debug("[PetTypeServiceJpa] - delete method has been called");
		
		this.petTypeRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		log.debug("[PetTypeServiceJpa] - deleteById method has been called");
		
		this.petTypeRepository.deleteById(id);
	}
	
}
