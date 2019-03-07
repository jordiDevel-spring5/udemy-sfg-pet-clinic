package guru.springframework.sfgpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;

@Service
@Profile("jpa")
public class OwnerServiceJpa implements OwnerService {

	private final OwnerRepository ownerRepository;
	
	public OwnerServiceJpa(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Owner findById(Long id) {
		return this.ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> ownerSet = new HashSet<>();
		
		this.ownerRepository.findAll().forEach(ownerSet::add);
		
		return ownerSet;
	}

	@Override
	public Owner save(Owner t) {
		return this.ownerRepository.save(t);
	}

	@Override
	public void delete(Owner t) {
		this.ownerRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		this.ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return this.ownerRepository.findByLastName(lastName);
	}

}
