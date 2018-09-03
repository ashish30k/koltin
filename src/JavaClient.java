import java.io.File;

public class JavaClient {
    public static void main(String[] args) {
        System.out.println(CaseInsenstiveFileCompartor.INSTANCE.compare(new File("\\user"), new File("\\admin")));
        Person3.fromJSON("");

    }

    public void postponeComputation(int delay, Runnable runnable) {

    }

}
