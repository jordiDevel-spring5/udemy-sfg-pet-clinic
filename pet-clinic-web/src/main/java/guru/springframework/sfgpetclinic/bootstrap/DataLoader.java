package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.VisitService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;
	
	private final Environment environment;
	
	public DataLoader(OwnerService ownerService, VetService vetService, 
			PetTypeService petTypeService, SpecialityService specialityService,
			VisitService visitService, Environment environment) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
		this.environment = environment;
	}

	@Override
	public void run(String... args) throws Exception {
		int count = this.petTypeService.findAll().size();
		
		if (count == 0) {
			if (this.environment.getActiveProfiles() != null && this.environment.getActiveProfiles().length > 0) {
				if (this.environment.getActiveProfiles().length == 1) {
					String activeProfile = this.environment.getActiveProfiles()[0];
					
					log.debug("Found Spring active profile: " + activeProfile);
					
					switch (activeProfile) {
						case "jpa":
							this.loadDataIntoJpa();
							return;
						case "map":
						case "default":
							this.loadDataIntoMaps();
							return;
						default:
							throw new RuntimeException("Unknown Spring active profile [" + activeProfile + "]");
					}
				}
				else {
					throw new RuntimeException("Found multiple Spring active profiles");
				}
			}
			else {
				throw new RuntimeException("Spring active profile not found");
			}
		}
	}
	
	private void loadDataIntoJpa() {
		PetType dogPetType = this.petTypeService.save(PetType.builder().name("Dog").build());
		PetType catPetType = this.petTypeService.save(PetType.builder().name("Cat").build());
		
		log.debug("*** DataLoader *** - Loaded PetTypes...");
		
		Speciality radiology = this.specialityService.save(Speciality.builder().description("Radiology").build());
		Speciality surgery = this.specialityService.save(Speciality.builder().description("Surgery").build());
		Speciality dentistry = this.specialityService.save(Speciality.builder().description("Dentistry").build());
		
		log.debug("*** DataLoader *** - Loaded Specialities...");
		
		Vet vet1 = Vet.builder()
			.firstName("Sam")
			.lastName("Axe")
		.build()
		.addSpeciality(radiology);
		
		this.vetService.save(vet1);
		
		log.debug("*** DataLoader *** - Loaded Vet 1...");
		
		Vet vet2 = Vet.builder()
			.firstName("Jessie")
			.lastName("Porter")
		.build()
		.addSpeciality(surgery)
		.addSpeciality(dentistry);
		
		this.vetService.save(vet2);
		
		log.debug("*** DataLoader *** - Loaded Vet 2...");
		
		Visit visit1 = Visit.builder()
			.date(LocalDate.now())
			.description("Rosco Annual Revision")
		.build();
		
		Pet mikesPet = Pet.builder()
			.petType(dogPetType)
			.birthDate(LocalDate.now())
			.name("Rosco")
		.build()
		.addVisit(visit1);
		
		Owner owner1 = Owner.builder()
			.firstName("Michael")
			.lastName("Weston")
			.address("Muntaner 202")
			.city("Barcelona")
			.telephone("666555444")
		.build()
		.addPet(mikesPet);
		
		this.ownerService.save(owner1);
		
		log.debug("*** DataLoader *** - Loaded Owner 1...");
		
		Visit visit2 = Visit.builder()
			.date(LocalDate.now())
			.description("Kitti Annual Revision")
		.build();
		
		Pet fionasPet = Pet.builder()
			.petType(catPetType)
			.birthDate(LocalDate.now())
			.name("Kitti")
		.build()
		.addVisit(visit2);
		
		Owner owner2 = Owner.builder()
			.firstName("Fiona")
			.lastName("Glenanne")
			.address("Balmes 40")
			.city("Barcelona")
			.telephone("677566455")
		.build()
		.addPet(fionasPet);
		
		this.ownerService.save(owner2);
		
		log.debug("*** DataLoader *** - Loaded Owner 2...");
		
		log.info("*** Data loaded successfully using loadDataIntoJpa ***");
	}
	
	private void loadDataIntoMaps() {
		PetType dogPetType = this.petTypeService.save(PetType.builder().name("Dog").build());
		PetType catPetType = this.petTypeService.save(PetType.builder().name("Cat").build());
		
		log.debug("*** DataLoader *** - Loaded PetTypes...");
		
		Speciality radiology = this.specialityService.save(Speciality.builder().description("Radiology").build());
		Speciality surgery = this.specialityService.save(Speciality.builder().description("Surgery").build());
		Speciality dentistry = this.specialityService.save(Speciality.builder().description("Dentistry").build());
		
		log.debug("*** DataLoader *** - Loaded Specialities...");
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("Muntaner 202");
		owner1.setCity("Barcelona");
		owner1.setTelephone("666555444");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(dogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		
		owner1.getPets().add(mikesPet);
		
		this.ownerService.save(owner1);
		
		Visit visit1 = new Visit();
		visit1.setDate(LocalDate.now());
		visit1.setDescription("Rosco Annual Revision");
		visit1.setPet(mikesPet);

		this.visitService.save(visit1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("Balmes 40");
		owner2.setCity("Barcelona");
		owner2.setTelephone("677566455");
		
		Pet fionasPet = new Pet();
		fionasPet.setPetType(catPetType);
		fionasPet.setOwner(owner2);
		fionasPet.setBirthDate(LocalDate.now());
		fionasPet.setName("Kitti");
		
		owner2.getPets().add(fionasPet);
		
		this.ownerService.save(owner2);
		
		Visit visit2 = new Visit();
		visit2.setDate(LocalDate.now());
		visit2.setDescription("Kitti Annual Revision");
		visit2.setPet(fionasPet);
		
		this.visitService.save(visit2);
		
		log.debug("*** DataLoader *** - Loaded Owners...");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(radiology);
		
		this.vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialities().add(surgery);
		vet2.getSpecialities().add(dentistry);
		
		this.vetService.save(vet2);
		
		log.debug("*** DataLoader *** - Loaded Vets...");
		
		log.info("*** Data loaded successfully using loadDataIntoMaps ***");
	}	
	
}
