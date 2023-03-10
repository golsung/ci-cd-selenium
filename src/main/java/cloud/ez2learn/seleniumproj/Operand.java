package cloud.ez2learn.seleniumproj;

public class Operand {
    private int a1;
    private int a2;
    public Operand() {
        a1 = 0;
        a2 = 0;
    };
    public Operand(int a1, int a2) {
        this.a1= a1;
        this.a2 = a2;
    };

    public int getA1() {
        return a1;
    }

    public int getA2() {
        return a2;
    }
}
