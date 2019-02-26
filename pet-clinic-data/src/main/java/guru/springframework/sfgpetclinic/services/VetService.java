package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Vet;

public interface VetService {

	public Vet findById(Long id);
	
	public Set<Vet> findAll();
	
	public Vet save(Vet vet);
	
}
