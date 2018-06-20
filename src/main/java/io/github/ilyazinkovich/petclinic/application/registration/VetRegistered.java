package io.github.ilyazinkovich.petclinic.application.registration;

import io.github.ilyazinkovich.petclinic.domain.Event;
import io.github.ilyazinkovich.petclinic.domain.Vet.VetId;
import java.time.Instant;

public class VetRegistered implements Event {

  final VetId vetId;
  private final Instant timestamp;

  public VetRegistered(final VetId vetId, final Instant timestamp) {
    this.vetId = vetId;
    this.timestamp = timestamp;
  }

  @Override
  public Instant timestamp() {
    return timestamp;
  }
}
