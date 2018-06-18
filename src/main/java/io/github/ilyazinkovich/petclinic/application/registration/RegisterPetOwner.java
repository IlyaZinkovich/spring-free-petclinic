package io.github.ilyazinkovich.petclinic.application.registration;

import io.github.ilyazinkovich.petclinic.application.Command;

public class RegisterPetOwner implements Command {

  final String name;

  public RegisterPetOwner(final String name) {
    this.name = name;
  }
}
