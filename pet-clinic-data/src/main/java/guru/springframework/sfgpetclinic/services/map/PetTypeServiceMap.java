package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile({"map", "default"})
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

	@Override
	public PetType findById(Long id) {
		log.debug("[PetTypeServiceMap] - findById method has been called");
		
		return super.findById(id);
	}

	@Override
	public Set<PetType> findAll() {
		log.debug("[PetTypeServiceMap] - findAll method has been called");
		
		return super.findAll();
	}

	@Override
	public PetType save(PetType t) {
		log.debug("[PetTypeServiceMap] - save method has been called");
		
		return super.save(t);
	}

	@Override
	public void delete(PetType t) {
		log.debug("[PetTypeServiceMap] - delete method has been called");
		
		super.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		log.debug("[PetTypeServiceMap] - deleteById method has been called");
		
		super.deleteById(id);
	}

}
