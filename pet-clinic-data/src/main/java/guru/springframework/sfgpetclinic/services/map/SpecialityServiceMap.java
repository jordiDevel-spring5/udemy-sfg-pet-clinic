package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile({"map", "default"})
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {

	@Override
	public Speciality findById(Long id) {
		log.debug("[SpecialityServiceMap] - findById method has been called");
		
		return super.findById(id);
	}

	@Override
	public Set<Speciality> findAll() {
		log.debug("[SpecialityServiceMap] - findAll method has been called");
		
		return super.findAll();
	}

	@Override
	public Speciality save(Speciality t) {
		log.debug("[SpecialityServiceMap] - save method has been called");
		
		return super.save(t);
	}

	@Override
	public void delete(Speciality t) {
		log.debug("[SpecialityServiceMap] - delete method has been called");
		
		super.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		log.debug("[SpecialityServiceMap] - deleteById method has been called");
		
		super.deleteById(id);
	}

}
