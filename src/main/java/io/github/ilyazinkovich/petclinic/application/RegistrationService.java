package io.github.ilyazinkovich.petclinic.application;

import io.github.ilyazinkovich.petclinic.domain.Pet;
import io.github.ilyazinkovich.petclinic.domain.Pet.PetId;
import io.github.ilyazinkovich.petclinic.domain.PetOwnerRepository;
import io.github.ilyazinkovich.petclinic.domain.PetRepository;

public class RegistrationService {

  private final PetOwnerRepository petOwnerRepository;
  private final PetRepository petRepository;

  public RegistrationService(final PetOwnerRepository petOwnerRepository,
      final PetRepository petRepository) {
    this.petOwnerRepository = petOwnerRepository;
    this.petRepository = petRepository;
  }

  public void handle(final RegisterPet registerPet) {
    petOwnerRepository.query(registerPet.petOwnerId).ifPresent(petOwner -> {
      final PetId petId = petRepository.nextIdentity();
      final Pet pet = new Pet(petId, registerPet.kind,
          registerPet.dateOfBirth, registerPet.petOwnerId);
      petRepository.persist(pet);
    });
  }
}
