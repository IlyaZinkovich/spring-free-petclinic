package io.github.ilyazinkovich.petclinic.domain;

import java.util.List;
import java.util.function.Consumer;

public class EventLog {

  private final List<Consumer<Event>> subscribers;

  public EventLog(final List<Consumer<Event>> subscribers) {
    this.subscribers = subscribers;
  }

  public void subscribe(final Consumer<Event> subscriber) {
    subscribers.add(subscriber);
  }

  public void publish(final Event event) {
    subscribers.forEach(subscriber -> subscriber.accept(event));
  }
}
