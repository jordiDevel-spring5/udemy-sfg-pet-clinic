package guru.springframework.sfgpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.services.PetService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile("jpa")
public class PetServiceJpa implements PetService {

	private final PetRepository petRepository;

	public PetServiceJpa(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Pet findById(Long id) {
		log.debug("[PetServiceJpa] - findById method has been called");
		
		return this.petRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Pet> findAll() {
		log.debug("[PetServiceJpa] - findAll method has been called");
		
		Set<Pet> petSet = new HashSet<>();
		
		this.petRepository.findAll().forEach(petSet::add);
		
		return petSet;
	}

	@Override
	public Pet save(Pet t) {
		log.debug("[PetServiceJpa] - save method has been called");
		
		return this.petRepository.save(t);
	}

	@Override
	public void delete(Pet t) {
		log.debug("[PetServiceJpa] - delete method has been called");
		
		this.petRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		log.debug("[PetServiceJpa] - deleteById method has been called");
		
		this.petRepository.deleteById(id);
	}
	
}
