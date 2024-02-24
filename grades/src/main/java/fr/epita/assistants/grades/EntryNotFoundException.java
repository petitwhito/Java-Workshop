package fr.epita.assistants.grades;

public class EntryNotFoundException extends RuntimeException {
    /**
     * @param entryClass The class of the collection's entries
     * @param query      The string representation of the search query
     */
    public EntryNotFoundException(Class<?> entryClass, String query) {
        super(String.format("%s not found for: `%s`",
                            entryClass.getSimpleName(),
                            query));
    }
}
