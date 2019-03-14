package guru.springframework.sfgpetclinic.services.jpa;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

	@InjectMocks
	OwnerServiceJpa ownerServiceJpa;
	
	@Mock
	OwnerRepository ownerRepository;
	
	final Long ownerId = 1L;
	final String lastName = "Smith";
	final Owner smith = Owner.builder().id(this.ownerId).lastName(this.lastName).build();
	
	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByLastName() {
		fail("Not yet implemented");
	}

}
