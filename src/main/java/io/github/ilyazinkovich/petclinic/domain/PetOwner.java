package io.github.ilyazinkovich.petclinic.domain;

public class PetOwner {

  public static class PetOwnerId {

    final String uid;

    PetOwnerId(final String uid) {
      this.uid = uid;
    }
  }
}
