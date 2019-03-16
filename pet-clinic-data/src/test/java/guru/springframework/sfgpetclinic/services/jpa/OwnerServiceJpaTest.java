package guru.springframework.sfgpetclinic.services.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

	OwnerServiceJpa ownerServiceJpa;
	
	@Mock
	OwnerRepository ownerRepository;
	
	final Long ownerId = 1L;
	final String lastName = "Smith";
	final Owner smith = Owner.builder().id(this.ownerId).lastName(this.lastName).build();
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		this.ownerServiceJpa = new OwnerServiceJpa(this.ownerRepository);
	}
	
	@Test
	void testFindById() {
		when(this.ownerRepository.findById(any())).thenReturn(Optional.of(this.smith));
		
		Owner owner = this.ownerServiceJpa.findById(this.ownerId);
		
		assertNotNull(owner);
		assertEquals(this.ownerId, owner.getId());
		verify(this.ownerRepository, times(1)).findById(anyLong());
	}
	
	@Test
	void testFindByIdNotFound() {
		when(this.ownerRepository.findById(any())).thenReturn(Optional.empty());
		
		Owner owner = this.ownerServiceJpa.findById(this.ownerId);
		
		assertNull(owner);
		verify(this.ownerRepository, times(1)).findById(anyLong());
	}

	@Test
	void testFindAll() {
		Set<Owner> testOwners = new HashSet<>();
		testOwners.add(Owner.builder().id(1L).build());
		testOwners.add(Owner.builder().id(2L).build());
		
		when(this.ownerRepository.findAll()).thenReturn(testOwners);
		
		Set<Owner> owners = this.ownerServiceJpa.findAll();
		
		assertEquals(2, owners.size());
		verify(this.ownerRepository, times(1)).findAll();
	}

	@Test
	void testSave() {
		when(this.ownerRepository.save(any())).thenReturn(this.smith);
		
		Owner savedOwner = this.ownerServiceJpa.save(Owner.builder().id(1L).build());
		
		assertNotNull(savedOwner);
		verify(this.ownerRepository, times(1)).save(any(Owner.class));
	}

	@Test
	void testDelete() {
		this.ownerServiceJpa.delete(this.smith);
		
		verify(this.ownerRepository, times(1)).delete(any(Owner.class));
	}

	@Test
	void testDeleteById() {
		this.ownerServiceJpa.deleteById(this.ownerId);
		
		verify(this.ownerRepository, times(1)).deleteById(anyLong());
	}

	@Test
	void testFindByLastName() {
		when(this.ownerRepository.findByLastName(anyString())).thenReturn(this.smith);
		
		Owner owner = this.ownerServiceJpa.findByLastName(this.lastName);
		
		assertNotNull(owner);
		assertEquals(this.ownerId, owner.getId());
		verify(this.ownerRepository, times(1)).findByLastName(anyString());
	}

}
