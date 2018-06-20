package io.github.ilyazinkovich.petclinic.application.appointment;

import io.github.ilyazinkovich.petclinic.domain.Vet.VetId;
import java.time.LocalDate;

public class FindSlot {

  final VetId vetId;
  private final LocalDate date;

  public FindSlot(final VetId vetId, final LocalDate date) {
    this.vetId = vetId;
    this.date = date;
  }
}
