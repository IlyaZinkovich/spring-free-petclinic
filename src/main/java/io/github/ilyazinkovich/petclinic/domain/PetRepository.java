package io.github.ilyazinkovich.petclinic.domain;

import io.github.ilyazinkovich.petclinic.domain.Pet.PetId;
import java.util.Optional;

public interface PetRepository {

  PetId nextIdentity();

  void persist(final Pet pet);

  Optional<Pet> query(final PetId petId);
}
