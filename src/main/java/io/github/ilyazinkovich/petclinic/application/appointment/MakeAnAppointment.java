package io.github.ilyazinkovich.petclinic.application.appointment;

import io.github.ilyazinkovich.petclinic.application.Command;
import io.github.ilyazinkovich.petclinic.domain.Pet.PetId;
import io.github.ilyazinkovich.petclinic.domain.PetOwner.PetOwnerId;
import io.github.ilyazinkovich.petclinic.domain.Slot;
import io.github.ilyazinkovich.petclinic.domain.Vet.VetId;

public class MakeAnAppointment implements Command {

  public static final String MAKE_AN_APPOINTMENT = "makeAnAppointment";

  final PetId petId;
  final PetOwnerId petOwnerId;
  final VetId vetId;
  final Slot slot;

  public MakeAnAppointment(final PetId petId, final PetOwnerId petOwnerId,
      final VetId vetId, final Slot slot) {
    this.petId = petId;
    this.petOwnerId = petOwnerId;
    this.vetId = vetId;
    this.slot = slot;
  }

  @Override
  public String commandName() {
    return MAKE_AN_APPOINTMENT;
  }
}
