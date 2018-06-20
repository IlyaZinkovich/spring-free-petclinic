package io.github.ilyazinkovich.petclinic.domain;

import io.github.ilyazinkovich.petclinic.domain.Vet.VetId;
import java.time.LocalDate;

public interface WorkScheduleRepository {

  WorkSchedule query(final VetId vetId, final LocalDate date);
}
