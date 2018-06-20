package io.github.ilyazinkovich.petclinic.application.appointment;

import io.github.ilyazinkovich.petclinic.domain.WorkScheduleRepository;
import io.github.ilyazinkovich.petclinic.domain.EventLog;
import io.github.ilyazinkovich.petclinic.domain.PetOwnerRepository;
import io.github.ilyazinkovich.petclinic.domain.PetRepository;
import io.github.ilyazinkovich.petclinic.domain.VetRepository;

public class Appointments {

  private final PetOwnerRepository petOwnerRepository;
  private final PetRepository petRepository;
  private final VetRepository vetRepository;
  private final WorkScheduleRepository workScheduleRepository;
  private final EventLog eventLog;

  public Appointments(final PetOwnerRepository petOwnerRepository,
      final PetRepository petRepository, final VetRepository vetRepository,
      final WorkScheduleRepository workScheduleRepository,
      final EventLog eventLog) {
    this.petOwnerRepository = petOwnerRepository;
    this.petRepository = petRepository;
    this.vetRepository = vetRepository;
    this.workScheduleRepository = workScheduleRepository;
    this.eventLog = eventLog;
  }
}
