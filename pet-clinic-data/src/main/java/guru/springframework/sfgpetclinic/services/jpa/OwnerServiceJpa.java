package guru.springframework.sfgpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile("jpa")
public class OwnerServiceJpa implements OwnerService {

	private final OwnerRepository ownerRepository;
	
	public OwnerServiceJpa(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Owner findById(Long id) {
		log.debug("[OwnerServiceJpa] - findById method has been called");
		
		return this.ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Owner> findAll() {
		log.debug("[OwnerServiceJpa] - findAll method has been called");
		
		Set<Owner> ownerSet = new HashSet<>();
		
		this.ownerRepository.findAll().forEach(ownerSet::add);
		
		return ownerSet;
	}

	@Override
	public Owner save(Owner t) {
		log.debug("[OwnerServiceJpa] - save method has been called");
		
		return this.ownerRepository.save(t);
	}

	@Override
	public void delete(Owner t) {
		log.debug("[OwnerServiceJpa] - delete method has been called");
		
		this.ownerRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		log.debug("[OwnerServiceJpa] - deleteById method has been called");
		
		this.ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		log.debug("[OwnerServiceJpa] - findByLastName method has been called");
		
		return this.ownerRepository.findByLastName(lastName);
	}

}
