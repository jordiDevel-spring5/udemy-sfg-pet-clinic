package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialityService specialityService;
	
	public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}
	
	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet save(Vet t) {
		if (t.getSpecialities().size() > 0) {
			t.getSpecialities().forEach(speciality -> {
				if (speciality.getId() == null) {
					Speciality savedSpecialty = this.specialityService.save(speciality);
					speciality.setId(savedSpecialty.getId());
				}
			});
		}
		
		return super.save(t);
	}

	@Override
	public void delete(Vet t) {
		super.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		deleteById(id);
	}

}
