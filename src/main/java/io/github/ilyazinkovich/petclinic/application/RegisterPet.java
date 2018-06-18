package io.github.ilyazinkovich.petclinic.application;

import io.github.ilyazinkovich.petclinic.domain.Kind;
import io.github.ilyazinkovich.petclinic.domain.PetOwner.PetOwnerId;
import java.time.LocalDate;

public class RegisterPet {

  final Kind kind;
  final LocalDate dateOfBirth;
  final PetOwnerId petOwnerId;

  public RegisterPet(final Kind kind, final LocalDate dateOfBirth,
      final PetOwnerId petOwnerId) {
    this.kind = kind;
    this.dateOfBirth = dateOfBirth;
    this.petOwnerId = petOwnerId;
  }
}
