package io.github.ilyazinkovich.petclinic.domain;

import java.util.Objects;

public class AnimalKind {

  private final String name;

  public AnimalKind(final String name) {
    this.name = name;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final AnimalKind that = (AnimalKind) o;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
