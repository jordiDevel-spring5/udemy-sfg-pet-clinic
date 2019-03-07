package guru.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.sfgpetclinic.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {}
