package io.github.ilyazinkovich.petclinic.domain;

import java.util.Objects;

public class PetOwner {

  public final PetOwnerId id;
  private final String name;

  public PetOwner(final PetOwnerId id, final String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PetOwner petOwner = (PetOwner) o;
    return Objects.equals(id, petOwner.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public static class PetOwnerId {

    final String uid;

    public PetOwnerId(final String uid) {
      this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      PetOwnerId that = (PetOwnerId) o;
      return Objects.equals(uid, that.uid);
    }

    @Override
    public int hashCode() {
      return Objects.hash(uid);
    }
  }
}
