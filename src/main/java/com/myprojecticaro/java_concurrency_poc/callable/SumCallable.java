
import java.util.concurrent.Callable;

public class SumCallable implements Callable<Integer> {

    private final int a;
    private final int b;

    public SumCallable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() {
        return a + b;
    }
}
