package guru.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.sfgpetclinic.model.Speciality;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {}
