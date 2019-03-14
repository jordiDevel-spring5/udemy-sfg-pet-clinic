package guru.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;

public class OwnerServiceMapTest {

	OwnerServiceMap ownerServiceMap;
	
	final Long ownerId = 1L;
	final String lastName = "Smith";
	
	@BeforeEach
	void setUp() {
		this.ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
		
		this.ownerServiceMap.save(Owner.builder().id(this.ownerId).lastName(this.lastName).build());
	}
	
	@Test
	void testFindByIdLong() {
		Owner owner = this.ownerServiceMap.findById(this.ownerId);
		
		assertEquals(this.ownerId, owner.getId());
	}

	@Test
	void testFindAll() {
		Set<Owner> owners = this.ownerServiceMap.findAll();
		
		assertEquals(1,  owners.size());
	}

	@Test
	void testSaveOwnerWithId() {
		final Long newId = 2L;
		Owner newOwner = Owner.builder().id(newId).build();
		
		Owner savedOwner = this.ownerServiceMap.save(newOwner);
		
		assertEquals(newId, savedOwner.getId());
	}
	
	@Test
	void testSaveOwnerWithoutId() {
		Owner savedOwner = this.ownerServiceMap.save(Owner.builder().build());
		
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}

	@Test
	void testDeleteOwner() {
		this.ownerServiceMap.delete(this.ownerServiceMap.findById(this.ownerId));
		
		assertEquals(0, this.ownerServiceMap.findAll().size());
	}

	@Test
	void testDeleteByIdLong() {
		this.ownerServiceMap.deleteById(this.ownerId);
		
		assertEquals(0, this.ownerServiceMap.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner smithOwner = this.ownerServiceMap.findByLastName(this.lastName);
		
		assertNotNull(smithOwner);
		assertEquals(this.ownerId, smithOwner.getId());
	}
	
	@Test
	void testFindByLastNameNotFound() {
		Owner dawsonOwner = this.ownerServiceMap.findByLastName("Dawson");
		
		assertNull(dawsonOwner);
	}

}
