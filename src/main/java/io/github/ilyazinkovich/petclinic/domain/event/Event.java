package io.github.ilyazinkovich.petclinic.domain.event;

import java.time.Instant;

public interface Event {

  long version();
  Instant timestamp();
}
