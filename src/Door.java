public class Door {
    public boolean hasPrize;
    public boolean revealable;
    public boolean choosable;

    public Door(boolean hasPrize) {
        this.hasPrize = hasPrize;
        revealable = true;
        choosable = true;
    }
}