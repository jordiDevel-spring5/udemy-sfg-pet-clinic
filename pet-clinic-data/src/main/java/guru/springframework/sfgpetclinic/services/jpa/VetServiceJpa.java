package guru.springframework.sfgpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile("jpa")
public class VetServiceJpa implements VetService {

	private final VetRepository vetRepository;
	
	public VetServiceJpa(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public Vet findById(Long id) {
		log.debug("[VetServiceJpa] - findById method has been called");
		
		return this.vetRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Vet> findAll() {
		log.debug("[VetServiceJpa] - findAll method has been called");
		
		Set<Vet> vetSet = new HashSet<>();
		
		this.vetRepository.findAll().forEach(vetSet::add);
		
		return vetSet;
	}

	@Override
	public Vet save(Vet t) {
		log.debug("[VetServiceJpa] - save method has been called");
		
		return this.vetRepository.save(t);
	}

	@Override
	public void delete(Vet t) {
		log.debug("[VetServiceJpa] - delete method has been called");
		
		this.vetRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		log.debug("[VetServiceJpa] - deleteById method has been called");
		
		this.vetRepository.deleteById(id);
	}

}
