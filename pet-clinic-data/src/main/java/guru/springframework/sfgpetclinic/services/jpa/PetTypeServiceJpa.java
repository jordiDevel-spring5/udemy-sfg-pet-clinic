package guru.springframework.sfgpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.PetTypeService;

@Service
@Profile("jpa")
public class PetTypeServiceJpa implements PetTypeService {

	private final PetTypeRepository petTypeRepository;

	public PetTypeServiceJpa(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public PetType findById(Long id) {
		return this.petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypeSet = new HashSet<>();
		
		this.petTypeRepository.findAll().forEach(petTypeSet::add);
		
		return petTypeSet;
	}

	@Override
	public PetType save(PetType t) {
		return this.petTypeRepository.save(t);
	}

	@Override
	public void delete(PetType t) {
		this.petTypeRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		this.petTypeRepository.deleteById(id);
	}
	
}
