package io.github.ilyazinkovich.petclinic.infrastructure;

import io.github.ilyazinkovich.petclinic.domain.Vet;
import io.github.ilyazinkovich.petclinic.domain.Vet.VetId;
import io.github.ilyazinkovich.petclinic.domain.VetRepository;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryVetRepository implements VetRepository {

  private final Map<VetId, Vet> vets;

  public InMemoryVetRepository(final Map<VetId, Vet> vets) {
    this.vets = vets;
  }

  @Override
  public VetId nextIdentity() {
    final String uid = UUID.randomUUID().toString();
    return new VetId(uid);
  }

  @Override
  public void persist(final Vet vet) {
    vets.put(vet.id, vet);
  }

  @Override
  public Optional<Vet> query(final VetId vetId) {
    return Optional.ofNullable(vets.get(vetId));
  }
}
