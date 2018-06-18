package io.github.ilyazinkovich.petclinic.application.registration;

import static java.time.Instant.now;

import io.github.ilyazinkovich.petclinic.application.Command;
import io.github.ilyazinkovich.petclinic.domain.Pet;
import io.github.ilyazinkovich.petclinic.domain.Pet.PetId;
import io.github.ilyazinkovich.petclinic.domain.PetOwner;
import io.github.ilyazinkovich.petclinic.domain.PetOwner.PetOwnerId;
import io.github.ilyazinkovich.petclinic.domain.PetOwnerRepository;
import io.github.ilyazinkovich.petclinic.domain.PetRepository;
import io.github.ilyazinkovich.petclinic.domain.EventLog;

public class RegistrationService {

  private final PetOwnerRepository petOwnerRepository;
  private final PetRepository petRepository;
  private final EventLog eventLog;

  public RegistrationService(final PetOwnerRepository petOwnerRepository,
      final PetRepository petRepository, final EventLog eventLog) {
    this.petOwnerRepository = petOwnerRepository;
    this.petRepository = petRepository;
    this.eventLog = eventLog;
  }

  public void handle(final Command command) {
    if (command instanceof RegisterPetOwner) {
      handle((RegisterPetOwner) command);
    } else if (command instanceof RegisterPet) {
      handle((RegisterPet) command);
    }
  }

  private void handle(final RegisterPetOwner registerPetOwner) {
    final PetOwnerId petOwnerId = petOwnerRepository.nextIdentity();
    final PetOwner petOwner = new PetOwner(petOwnerId, registerPetOwner.name);
    petOwnerRepository.persist(petOwner);
    eventLog.publish(new PetOwnerRegistered(petOwnerId, now()));
  }

  private void handle(final RegisterPet registerPet) {
    petOwnerRepository.query(registerPet.petOwnerId).ifPresent(petOwner -> {
      final PetId petId = petRepository.nextIdentity();
      final Pet pet = new Pet(petId, registerPet.kind,
          registerPet.dateOfBirth, registerPet.petOwnerId);
      petRepository.persist(pet);
      eventLog.publish(new PetRegistered(petId, now()));
    });
  }
}
