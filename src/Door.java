public class Door {
    private boolean hasPrize;
    private boolean revealable;
    private boolean choosable;

    public Door(boolean hasPrize) {
        this.hasPrize = hasPrize;
        revealable = true;
    }

    public boolean getStat() {
        return this.hasPrize;
    }

    public void unrevealable() {
        this.revealable = false;
    }

    public void unchoosable() {
        this.choosable = false;
    }
}
