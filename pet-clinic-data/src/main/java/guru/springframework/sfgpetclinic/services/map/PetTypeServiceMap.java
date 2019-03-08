package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetTypeService;

@Service
@Profile({"map", "default"})
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

	@Override
	public PetType findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<PetType> findAll() {
		return super.findAll();
	}

	@Override
	public PetType save(PetType t) {
		return super.save(t);
	}

	@Override
	public void delete(PetType t) {
		super.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
