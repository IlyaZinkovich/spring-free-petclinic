package io.github.ilyazinkovich.petclinic.domain;

import io.github.ilyazinkovich.petclinic.domain.PetOwner.PetOwnerId;
import java.time.LocalDate;
import java.util.Objects;

public class Pet {

  public final PetId id;
  private final AnimalKind kind;
  private final LocalDate dateOfBirth;
  private final PetOwnerId petOwnerId;

  public Pet(final PetId id, final AnimalKind kind, final LocalDate dateOfBirth,
      final PetOwnerId petOwnerId) {
    this.id = id;
    this.kind = kind;
    this.dateOfBirth = dateOfBirth;
    this.petOwnerId = petOwnerId;
  }

  public AnimalKind kind() {
    return kind;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Pet pet = (Pet) o;
    return Objects.equals(id, pet.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public static class PetId {

    final String uid;

    public PetId(final String uid) {
      this.uid = uid;
    }

    @Override
    public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      final PetId petId = (PetId) o;
      return Objects.equals(uid, petId.uid);
    }

    @Override
    public int hashCode() {
      return Objects.hash(uid);
    }
  }
}
