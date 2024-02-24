package fr.epita.assistants.drawing;

public abstract class Entity implements IDrawable {
    static private long SEQUENCE = 0;
    private long id;
    public Entity() {
        id = SEQUENCE;
        SEQUENCE++;
    }

    @Override
    public void draw() {

    }
    public long getId()
    {
        return id;
    }
}
