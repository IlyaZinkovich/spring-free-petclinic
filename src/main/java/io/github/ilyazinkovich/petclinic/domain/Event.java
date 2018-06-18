package io.github.ilyazinkovich.petclinic.domain;

import java.time.Instant;

public interface Event {

  Instant timestamp();
}
