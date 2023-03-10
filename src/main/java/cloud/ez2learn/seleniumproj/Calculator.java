package cloud.ez2learn.seleniumproj;

public class Calculator {

    private int a;
    private int b;
   // private int sum;
    private int result;

    public Calculator() {
    }

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }


    public int getSum() {
        this.result = a + b;
        return this.result;
    }

    // public int getDifference() {
    //     this.result = a - b;
    //     return this.result;
    // }

}

