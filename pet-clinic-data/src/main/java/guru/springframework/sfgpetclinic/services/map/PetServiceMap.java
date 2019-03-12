package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.PetService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile({"map", "default"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Pet findById(Long id) {
		log.debug("[PetServiceMap] - findById method has been called");
		
		return super.findById(id);
	}

	@Override
	public Set<Pet> findAll() {
		log.debug("[PetServiceMap] - findAll method has been called");
		
		return super.findAll();
	}

	@Override
	public Pet save(Pet t) {
		log.debug("[PetServiceMap] - save method has been called");
		
		return super.save(t);
	}

	@Override
	public void delete(Pet t) {
		log.debug("[PetServiceMap] - delete method has been called");
		
		super.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		log.debug("[PetServiceMap] - deleteById method has been called");
		
		super.deleteById(id);
	}

}
