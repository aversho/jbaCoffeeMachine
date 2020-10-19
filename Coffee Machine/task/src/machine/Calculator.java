package machine;

public class Calculator {
    private int cups;

    public Calculator(int cups){
        this.cups = cups;
    }

    public int water(){
        return 200 * cups;
    }

    public int milk(){
        return 50 * cups;
    }

    public int beans(){
        return 15 * cups;
    }

    public int getCups() {
        return cups;
    }
}
