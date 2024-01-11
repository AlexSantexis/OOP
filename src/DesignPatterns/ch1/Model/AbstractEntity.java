package DesignPatterns.ch1.Model;

public abstract class AbstractEntity implements IdentifiableEntity {
    private Long id;
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
