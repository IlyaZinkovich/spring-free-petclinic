package io.github.ilyazinkovich.petclinic.domain;

import io.github.ilyazinkovich.petclinic.domain.Pet.PetId;
import io.github.ilyazinkovich.petclinic.domain.PetOwner.PetOwnerId;
import io.github.ilyazinkovich.petclinic.domain.Vet.VetId;
import java.time.ZonedDateTime;

public class Appointment {

  private final PetId petId;
  private final PetOwnerId petOwnerId;
  private final VetId vetId;
  private final ZonedDateTime dateAndTime;

  public Appointment(final PetId petId, final PetOwnerId petOwnerId,
      final VetId vetId, final ZonedDateTime dateAndTime) {
    this.petId = petId;
    this.petOwnerId = petOwnerId;
    this.vetId = vetId;
    this.dateAndTime = dateAndTime;
  }
}
