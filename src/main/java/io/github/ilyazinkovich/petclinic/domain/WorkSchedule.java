package io.github.ilyazinkovich.petclinic.domain;

import io.github.ilyazinkovich.petclinic.domain.Vet.VetId;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public class WorkSchedule {

  private final VetId vetId;
  private final LocalDate date;
  private final List<Slot> slots;

  public WorkSchedule(final VetId vetId, final LocalDate date,
      final List<Slot> slots) {
    this.vetId = vetId;
    this.date = date;
    this.slots = slots;
  }

  public Optional<Slot> emptySlot(final ZonedDateTime dateAndTime) {
    return Optional.empty();
  }
}
