package io.github.ilyazinkovich.petclinic.application.registration;

import io.github.ilyazinkovich.petclinic.domain.Event;
import io.github.ilyazinkovich.petclinic.domain.PetOwner.PetOwnerId;
import java.time.Instant;

public class PetOwnerRegistered implements Event {

  final PetOwnerId petOwnerId;
  private final Instant timestamp;

  public PetOwnerRegistered(final PetOwnerId petOwnerId, final Instant timestamp) {
    this.petOwnerId = petOwnerId;
    this.timestamp = timestamp;
  }

  @Override
  public Instant timestamp() {
    return timestamp;
  }
}
