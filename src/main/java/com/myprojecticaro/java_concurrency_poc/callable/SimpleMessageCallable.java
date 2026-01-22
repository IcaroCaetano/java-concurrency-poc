
import java.util.concurrent.Callable;

public class SimpleMessageCallable implements Callable<String> {

    @Override
    public String call() {
        return "Hello from Callable";
    }
}
