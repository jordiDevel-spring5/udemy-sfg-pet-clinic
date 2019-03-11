package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "vets")
public class Vet extends Person {

	private static final long serialVersionUID = 5719734850419870704L;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "vet_specialities",
		joinColumns = @JoinColumn(name = "vet_id"),
		inverseJoinColumns = @JoinColumn(name = "speciality_id")
	)
	private Set<Speciality> specialities = new HashSet<>();

	@Builder
	public Vet(Long id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

	public Vet addSpeciality(Speciality speciality) {
		this.specialities.add(speciality);
		return this;
	}
}
