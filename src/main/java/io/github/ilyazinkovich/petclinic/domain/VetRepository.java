package io.github.ilyazinkovich.petclinic.domain;

import io.github.ilyazinkovich.petclinic.domain.Vet.VetId;
import java.util.Optional;

public interface VetRepository {

  Optional<Vet> query(final VetId vetId);

  VetId nextIdentity();

  void persist(final Vet vet);
}
