package fr.epita.assistants.grades.model;

import lombok.Builder;

@Builder
public record Grade(Activity activity, int grade) {};
