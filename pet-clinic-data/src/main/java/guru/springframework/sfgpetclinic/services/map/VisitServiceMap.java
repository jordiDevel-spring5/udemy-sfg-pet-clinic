package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile({"map", "default"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Visit findById(Long id) {
		log.debug("[VisitServiceMap] - findById method has been called");
		
		return super.findById(id);
	}

	@Override
	public Set<Visit> findAll() {
		log.debug("[VisitServiceMap] - findAll method has been called");
		
		return super.findAll();
	}

	@Override
	public Visit save(Visit t) {
		log.debug("[VisitServiceMap] - save method has been called");
		
		if (t.getPet() == null 
			|| t.getPet().getId() == null 
			|| t.getPet().getOwner() == null 
			|| t.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Invalid Visit");
		}
		
		return super.save(t);
	}

	@Override
	public void delete(Visit t) {
		log.debug("[VisitServiceMap] - delete method has been called");
		
		super.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		log.debug("[VisitServiceMap] - deleteById method has been called");
		
		super.deleteById(id);
	}

}
