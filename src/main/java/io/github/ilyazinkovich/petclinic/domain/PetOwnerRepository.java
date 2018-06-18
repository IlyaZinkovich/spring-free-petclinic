package io.github.ilyazinkovich.petclinic.domain;

import io.github.ilyazinkovich.petclinic.domain.PetOwner.PetOwnerId;
import java.util.Optional;

public interface PetOwnerRepository {

  Optional<PetOwner> query(final PetOwnerId petOwnerId);
}
