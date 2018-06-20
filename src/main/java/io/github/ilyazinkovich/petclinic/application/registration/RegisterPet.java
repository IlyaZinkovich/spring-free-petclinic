package io.github.ilyazinkovich.petclinic.application.registration;

import io.github.ilyazinkovich.petclinic.application.Command;
import io.github.ilyazinkovich.petclinic.domain.AnimalKind;
import io.github.ilyazinkovich.petclinic.domain.PetOwner.PetOwnerId;
import java.time.LocalDate;

public class RegisterPet implements Command {

  public static final String REGISTER_PET = "registerPet";

  final AnimalKind kind;
  final LocalDate dateOfBirth;
  final PetOwnerId petOwnerId;

  public RegisterPet(final AnimalKind kind, final LocalDate dateOfBirth,
      final PetOwnerId petOwnerId) {
    this.kind = kind;
    this.dateOfBirth = dateOfBirth;
    this.petOwnerId = petOwnerId;
  }

  @Override
  public String commandName() {
    return REGISTER_PET;
  }
}
