package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile({"map", "default"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialityService specialityService;
	
	public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}
	
	@Override
	public Vet findById(Long id) {
		log.debug("[VetServiceMap] - findById method has been called");
		
		return super.findById(id);
	}

	@Override
	public Set<Vet> findAll() {
		log.debug("[VetServiceMap] - findAll method has been called");
		
		return super.findAll();
	}

	@Override
	public Vet save(Vet t) {
		log.debug("[VetServiceMap] - save method has been called");
		
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
		log.debug("[VetServiceMap] - delete method has been called");
		
		super.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		log.debug("[VetServiceMap] - deleteById method has been called");
		
		super.deleteById(id);
	}

}
