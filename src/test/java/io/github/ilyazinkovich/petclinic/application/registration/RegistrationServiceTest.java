package io.github.ilyazinkovich.petclinic.application.registration;

import static java.lang.String.format;
import static java.time.Instant.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.ilyazinkovich.petclinic.domain.Event;
import io.github.ilyazinkovich.petclinic.domain.EventLog;
import io.github.ilyazinkovich.petclinic.domain.Kind;
import io.github.ilyazinkovich.petclinic.domain.Pet;
import io.github.ilyazinkovich.petclinic.domain.Pet.PetId;
import io.github.ilyazinkovich.petclinic.domain.PetOwner;
import io.github.ilyazinkovich.petclinic.domain.PetOwner.PetOwnerId;
import io.github.ilyazinkovich.petclinic.domain.PetOwnerRepository;
import io.github.ilyazinkovich.petclinic.domain.PetRepository;
import io.github.ilyazinkovich.petclinic.infrastructure.InMemoryPetOwnerRepository;
import io.github.ilyazinkovich.petclinic.infrastructure.InMemoryPetRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegistrationServiceTest {

  private Registration registrationService;
  private EventLog eventLog;
  private PetOwnerRepository petOwnerRepository;
  private PetRepository petRepository;

  @BeforeEach
  void setup() {
    final HashMap<PetOwnerId, PetOwner> petOwners = new HashMap<>();
    petOwnerRepository = new InMemoryPetOwnerRepository(petOwners);
    final HashMap<PetId, Pet> pets = new HashMap<>();
    petRepository = new InMemoryPetRepository(pets);
    final List<Consumer<Event>> subscribers = new ArrayList<>();
    eventLog = new EventLog(subscribers);
    registrationService = new Registration(petOwnerRepository, petRepository, eventLog);
  }

  @Test
  void testPetOwnerRegistration() {
    final List<Event> publishedEvents = new ArrayList<>();
    eventLog.subscribe(publishedEvents::add);

    final String name = "Pet Owner";
    registrationService.handle(new RegisterPetOwner(name));

    final PetOwnerRegistered petOwnerRegistered =
        containOneEvent(publishedEvents, PetOwnerRegistered.class);

    assertFalse(petOwnerRegistered.timestamp().isAfter(now()));

    final PetOwner persistedPetOwner = petOwnerRepository.query(petOwnerRegistered.petOwnerId())
        .orElseThrow(() -> new AssertionError("No pet owners persisted"));
    assertEquals(petOwnerRegistered.petOwnerId(), persistedPetOwner.id);
  }

  @Test
  void testPetRegistrationWithoutPetOwner() {
    final List<Event> publishedEvents = new ArrayList<>();
    eventLog.subscribe(publishedEvents::add);

    final Kind cat = new Kind("cat");
    final LocalDate dateOfBirth = LocalDate.now();
    final PetOwnerId nonExistingPetOwnerId = new PetOwnerId("");
    registrationService.handle(new RegisterPet(cat, dateOfBirth, nonExistingPetOwnerId));

    assertTrue(publishedEvents.isEmpty());
  }

  @Test
  void testPetRegistration() {
    final List<Event> publishedEvents = new ArrayList<>();
    eventLog.subscribe(publishedEvents::add);

    final PetOwnerId petOwnerId = petOwnerRepository.nextIdentity();
    final String petOwnerName = "Pet Owner";
    petOwnerRepository.persist(new PetOwner(petOwnerId, petOwnerName));

    final Kind cat = new Kind("cat");
    final LocalDate dateOfBirth = LocalDate.now();
    registrationService.handle(new RegisterPet(cat, dateOfBirth, petOwnerId));

    final PetRegistered petRegistered = containOneEvent(publishedEvents, PetRegistered.class);

    assertFalse(petRegistered.timestamp().isAfter(now()));
    final PetId petId = petRegistered.petId();
    final Pet persistedPet = petRepository.query(petId)
        .orElseThrow(() -> new AssertionError("No pets persisted"));
    assertEquals(petId, persistedPet.id);
  }

  private <T extends Event> T containOneEvent(final List<Event> events, final Class<T> clazz) {
    assertEquals(1, events.size());
    return events.stream()
        .filter(clazz::isInstance)
        .map(clazz::cast)
        .findAny().orElseThrow(() -> new AssertionError(format("No Events of Type %s", clazz)));
  }
}
