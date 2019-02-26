package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerService {

	public Owner findById(Long id);
	
	public Owner findByLastName(String lastName);
	
	public Set<Owner> findAll();
	
	public Owner save(Owner owner);
	
}
