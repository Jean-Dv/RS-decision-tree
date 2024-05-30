package co.edu.uptc.model;

public class Genr {

    private String name;

    public Genr() {
    }

    public Genr(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genr [" + name + "]";
    }

}
