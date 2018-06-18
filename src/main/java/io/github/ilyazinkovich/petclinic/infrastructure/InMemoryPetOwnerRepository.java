package io.github.ilyazinkovich.petclinic.infrastructure;

import io.github.ilyazinkovich.petclinic.domain.PetOwner;
import io.github.ilyazinkovich.petclinic.domain.PetOwner.PetOwnerId;
import io.github.ilyazinkovich.petclinic.domain.PetOwnerRepository;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryPetOwnerRepository implements PetOwnerRepository {

  private final Map<PetOwnerId, PetOwner> petOwners;

  public InMemoryPetOwnerRepository(final Map<PetOwnerId, PetOwner> petOwners) {
    this.petOwners = petOwners;
  }

  @Override
  public Optional<PetOwner> query(final PetOwnerId petOwnerId) {
    return Optional.ofNullable(petOwners.get(petOwnerId));
  }

  @Override
  public PetOwnerId nextIdentity() {
    final String uid = UUID.randomUUID().toString();
    return new PetOwnerId(uid);
  }

  @Override
  public void persist(final PetOwner petOwner) {
    petOwners.put(petOwner.id, petOwner);
  }
}
