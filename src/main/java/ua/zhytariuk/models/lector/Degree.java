package ua.zhytariuk.models.lector;

/**
 * @author (ozhytary)
 */
public enum Degree {
    ASSISTANT("assistant"), ASSOCIATE_PROFESSOR("associate professors"), PROFESSOR("professors");

    private final String name;

    Degree(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
