package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

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
		return super.save(t.getId(), t);
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
