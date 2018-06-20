package io.github.ilyazinkovich.petclinic.application.registration;

import io.github.ilyazinkovich.petclinic.application.Command;

public class RegisterPetOwner implements Command {

  public static final String REGISTER_PET_OWNER = "registerPetOwner";

  final String name;

  public RegisterPetOwner(final String name) {
    this.name = name;
  }

  @Override
  public String commandName() {
    return REGISTER_PET_OWNER;
  }
}
