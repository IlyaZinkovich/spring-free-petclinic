package io.github.ilyazinkovich.petclinic.application.registration;

import static io.github.ilyazinkovich.petclinic.application.registration.RegisterPet.REGISTER_PET;
import static io.github.ilyazinkovich.petclinic.application.registration.RegisterPetOwner.REGISTER_PET_OWNER;
import static java.time.Instant.now;

import com.google.common.collect.ImmutableMap;
import io.github.ilyazinkovich.petclinic.application.Command;
import io.github.ilyazinkovich.petclinic.domain.EventLog;
import io.github.ilyazinkovich.petclinic.domain.Pet;
import io.github.ilyazinkovich.petclinic.domain.Pet.PetId;
import io.github.ilyazinkovich.petclinic.domain.PetOwner;
import io.github.ilyazinkovich.petclinic.domain.PetOwner.PetOwnerId;
import io.github.ilyazinkovich.petclinic.domain.PetOwnerRepository;
import io.github.ilyazinkovich.petclinic.domain.PetRepository;
import java.util.Map;
import java.util.function.Consumer;

public class Registration {

  private final PetOwnerRepository petOwnerRepository;
  private final PetRepository petRepository;
  private final EventLog eventLog;
  private final Map<String, Consumer<Command>> commandHandlers;

  public Registration(final PetOwnerRepository petOwnerRepository,
      final PetRepository petRepository, final EventLog eventLog) {
    this.petOwnerRepository = petOwnerRepository;
    this.petRepository = petRepository;
    this.eventLog = eventLog;
    this.commandHandlers = ImmutableMap.<String, Consumer<Command>>builder()
        .put(REGISTER_PET, command -> handle((RegisterPet) command))
        .put(REGISTER_PET_OWNER, command -> handle((RegisterPetOwner) command))
        .build();
  }

  public void handle(final Command command) {
    commandHandlers.get(command.commandName()).accept(command);
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
      final Pet pet = petOwner.bringNewPet(petId, registerPet.kind, registerPet.dateOfBirth);
      petRepository.persist(pet);
      eventLog.publish(new PetRegistered(petId, now()));
    });
  }
}
