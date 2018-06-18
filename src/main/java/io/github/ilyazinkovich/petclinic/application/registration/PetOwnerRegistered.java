package io.github.ilyazinkovich.petclinic.application.registration;

import io.github.ilyazinkovich.petclinic.domain.PetOwner.PetOwnerId;
import io.github.ilyazinkovich.petclinic.domain.Event;
import java.time.Instant;

public class PetOwnerRegistered implements Event {

  private final PetOwnerId petOwnerId;
  private final Instant timestamp;

  public PetOwnerRegistered(final PetOwnerId petOwnerId, final Instant timestamp) {
    this.petOwnerId = petOwnerId;
    this.timestamp = timestamp;
  }

  @Override
  public Instant timestamp() {
    return timestamp;
  }

  public PetOwnerId petOwnerId() {
    return petOwnerId;
  }
}
