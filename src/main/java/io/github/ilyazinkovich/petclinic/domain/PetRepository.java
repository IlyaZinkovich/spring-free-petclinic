package io.github.ilyazinkovich.petclinic.domain;

import io.github.ilyazinkovich.petclinic.domain.Pet.PetId;

public interface PetRepository {

  PetId nextIdentity();

  void persist(final Pet pet);

  Pet query(final PetId petId);
}
