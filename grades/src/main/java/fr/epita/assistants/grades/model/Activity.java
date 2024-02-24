package fr.epita.assistants.grades.model;

import lombok.Builder;

@Builder
public record Activity(String name, Subject subject, float weight) {}
