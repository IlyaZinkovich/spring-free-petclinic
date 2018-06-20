package io.github.ilyazinkovich.petclinic.application.registration;

import io.github.ilyazinkovich.petclinic.application.Command;
import io.github.ilyazinkovich.petclinic.domain.AnimalKind;
import java.util.List;

public class RegisterVet implements Command {

  public static final String REGISTER_VET = "registerVet";

  final String vetName;
  final List<AnimalKind> specialisations;

  public RegisterVet(final String vetName, final List<AnimalKind> specialisations) {
    this.vetName = vetName;
    this.specialisations = specialisations;
  }

  @Override
  public String commandName() {
    return REGISTER_VET;
  }
}
