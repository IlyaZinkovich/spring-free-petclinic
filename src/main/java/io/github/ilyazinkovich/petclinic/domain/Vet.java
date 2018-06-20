package io.github.ilyazinkovich.petclinic.domain;

import java.util.List;
import java.util.Objects;

public class Vet {

  public final VetId id;
  private final String name;
  private final List<AnimalKind> specialisations;

  public Vet(final VetId id, final String name, final List<AnimalKind> specialisations) {
    this.id = id;
    this.name = name;
    this.specialisations = specialisations;
  }

  public static class VetId {

    final String uid;

    public VetId(final String uid) {
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
      VetId that = (VetId) o;
      return Objects.equals(uid, that.uid);
    }

    @Override
    public int hashCode() {
      return Objects.hash(uid);
    }
  }
}
