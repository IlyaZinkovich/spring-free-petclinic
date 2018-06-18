package io.github.ilyazinkovich.petclinic.domain;

import io.github.ilyazinkovich.petclinic.domain.PetOwner.PetOwnerId;
import java.time.LocalDate;

public class Pet {

  private final PetId petId;
  private final Kind kind;
  private final LocalDate dateOfBirth;
  private final PetOwnerId petOwnerId;

  public Pet(final PetId petId, final Kind kind, final LocalDate dateOfBirth,
      final PetOwnerId petOwnerId) {
    this.petId = petId;
    this.kind = kind;
    this.dateOfBirth = dateOfBirth;
    this.petOwnerId = petOwnerId;
  }

  public static class PetId {

    final String uid;

    PetId(final String uid) {
      this.uid = uid;
    }
  }
}
