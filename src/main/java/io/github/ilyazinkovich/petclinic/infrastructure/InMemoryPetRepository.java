package io.github.ilyazinkovich.petclinic.infrastructure;

import io.github.ilyazinkovich.petclinic.domain.Pet;
import io.github.ilyazinkovich.petclinic.domain.Pet.PetId;
import io.github.ilyazinkovich.petclinic.domain.PetRepository;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryPetRepository implements PetRepository {

  private final Map<PetId, Pet> pets;

  public InMemoryPetRepository(final Map<PetId, Pet> pets) {
    this.pets = pets;
  }

  @Override
  public PetId nextIdentity() {
    final String uid = UUID.randomUUID().toString();
    return new PetId(uid);
  }

  @Override
  public void persist(final Pet pet) {
    pets.put(pet.id, pet);
  }

  @Override
  public Optional<Pet> query(final PetId petId) {
    return Optional.ofNullable(pets.get(petId));
  }
}
