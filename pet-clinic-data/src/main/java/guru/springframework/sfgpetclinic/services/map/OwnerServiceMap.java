package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile({"map", "default"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;
	
	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner findById(Long id) {
		log.debug("[OwnerServiceMap] - findById method has been called");
		
		return super.findById(id);
	}

	@Override
	public Set<Owner> findAll() {
		log.debug("[OwnerServiceMap] - findAll method has been called");
		
		return super.findAll();
	}

	@Override
	public Owner save(Owner t) {
		log.debug("[OwnerServiceMap] - save method has been called");
		
		if (t != null) {
			if (t.getPets() != null) {
				t.getPets().forEach(pet -> {
					if (pet.getPetType() != null) {
						if (pet.getPetType().getId() == null) {
							pet.setPetType(this.petTypeService.save(pet.getPetType()));
						}
					} else {
						throw new RuntimeException("Pet Type is required");
					}
					
					if (pet.getId() == null) {
						Pet savedPet = this.petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			
			return super.save(t);	
		}
		else {
			return null;
		}
	}
	
	@Override
	public void delete(Owner t) {
		log.debug("[OwnerServiceMap] - delete method has been called");
		
		super.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		log.debug("[OwnerServiceMap] - deleteById method has been called");
		
		super.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		log.debug("[OwnerServiceMap] - findByLastName method has been called");
		
		return this.findAll().stream().filter(owner -> lastName.equalsIgnoreCase(owner.getLastName())).findFirst().orElse(null);
	}

}
