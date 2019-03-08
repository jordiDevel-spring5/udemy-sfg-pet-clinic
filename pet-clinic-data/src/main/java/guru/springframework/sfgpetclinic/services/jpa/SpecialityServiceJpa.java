package guru.springframework.sfgpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.sfgpetclinic.services.SpecialityService;

@Service
@Profile("jpa")
public class SpecialityServiceJpa implements SpecialityService {

	private final SpecialityRepository specialityRepository;

	public SpecialityServiceJpa(SpecialityRepository specialityRepository) {
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Speciality findById(Long id) {
		return this.specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialitySet = new HashSet<>();
		
		this.specialityRepository.findAll().forEach(specialitySet::add);
		
		return specialitySet;
	}

	@Override
	public Speciality save(Speciality t) {
		return this.specialityRepository.save(t);
	}

	@Override
	public void delete(Speciality t) {
		this.specialityRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		this.specialityRepository.deleteById(id);
	}
	
}
