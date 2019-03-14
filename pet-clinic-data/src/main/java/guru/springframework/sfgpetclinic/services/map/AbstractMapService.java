package guru.springframework.sfgpetclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import guru.springframework.sfgpetclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

	protected Map<Long, T> map = new HashMap<>();
	
	Set<T> findAll() {
		return new HashSet<>(this.map.values());
	}
	
	T findById(ID id) {
		return this.map.get(id);
	}
	
	T save(T t) {
		if (t != null) {
			if (t.getId() == null) {
				t.setId(this.getNextId());
			}
			
			this.map.put(t.getId(), t);
		}
		else {
			throw new RuntimeException("Object cannot be null");
		}
		
		return t;
	}
	
	void delete(T t) {
		this.map.entrySet().removeIf(entry -> entry.getValue().equals(t));
	}
	
	void deleteById(ID id) {
		this.map.remove(id);
	}
	
	private Long getNextId() {
		if (this.map != null && !this.map.isEmpty()) {
			return Collections.max(this.map.keySet()) + 1;
		}
		else {
			return 1L;
		}
	}
}
