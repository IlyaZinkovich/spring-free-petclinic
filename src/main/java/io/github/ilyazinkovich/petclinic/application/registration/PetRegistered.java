package io.github.ilyazinkovich.petclinic.application.registration;

import io.github.ilyazinkovich.petclinic.domain.Pet.PetId;
import io.github.ilyazinkovich.petclinic.domain.Event;
import java.time.Instant;

public class PetRegistered implements Event {

  private final PetId petId;
  private final Instant timestamp;

  public PetRegistered(final PetId petId, final Instant timestamp) {
    this.petId = petId;
    this.timestamp = timestamp;
  }

  @Override
  public Instant timestamp() {
    return timestamp;
  }

  public PetId petId() {
    return petId;
  }
}
