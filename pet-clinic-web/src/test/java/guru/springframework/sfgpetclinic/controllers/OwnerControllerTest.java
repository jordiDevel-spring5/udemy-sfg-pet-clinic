package guru.springframework.sfgpetclinic.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@InjectMocks
	OwnerController ownerController;
	
	@Mock
	OwnerService ownerService;
	
	MockMvc mockMvc;
	
	Set<Owner> owners = new HashSet<>();
	
	@BeforeEach
	void setUp() throws Exception {
		this.owners.add(Owner.builder().id(1L).build());
		this.owners.add(Owner.builder().id(2L).build());
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.ownerController).build();
	}

	@Test
	void testListOwners() throws Exception {
		when(this.ownerService.findAll()).thenReturn(this.owners);
		
		this.mockMvc.perform(get("/owners"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/index"))
			.andExpect(model().attribute("owners", hasSize(2)));
		
		verify(this.ownerService, times(1)).findAll();
	}

	@Test
	void testFindOwners() throws Exception {
		this.mockMvc.perform(get("/owners/find"))
			.andExpect(status().isOk())
			.andExpect(view().name("notimplemented"));
		
		verifyZeroInteractions(this.ownerService);
	}
	
	//Esperant aclaració al forum del curs sobre aquests dos tests:
	//Pq el primer passa i el segon no? És per culpa del when?
	/*
	@Test
	void testListOwnersWhenFirst() throws Exception {
		Set<Owner> list = new HashSet<>();
		list.add(Owner.builder().id(1L).build());
		list.add(Owner.builder().id(2L).build());
		
		when(this.ownerService.findAll()).thenReturn(list);
		
		this.ownerService.findAll();
		
		verifyZeroInteractions(this.ownerService);
	}
	
	@Test
	void testListOwnersNoWhen() throws Exception {
		this.ownerService.findAll();
		
		verifyZeroInteractions(this.ownerService);
	}*/

}
