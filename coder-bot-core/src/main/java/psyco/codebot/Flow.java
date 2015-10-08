package psyco.codebot;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by lipeng on 15/10/8.
 */
public class Flow<H> {
    H obj;
    boolean goon = true;

    private Flow(H obj, boolean goon) {
        this.obj = obj;
        this.goon = goon;
    }

    public static <X> Flow<X> of(X x) {
        return new Flow(x, x != null);
    }


    public H get() {
        return goon ? obj : null;
    }

    public Flow<H> when(Predicate<H> predicate) {
        this.goon = predicate.test(obj);
        return this;
    }

    public H getOrElse(H other) {
        return goon ? (obj == null ? other : obj) : null;
    }

    private boolean canGo() {
        return obj != null && goon;
    }

    /**
     * check goon before function
     */
    public <R> Flow<R> map(Function<H, R> function, boolean goon) {
        if (!canGo())
            return new Flow(null, false);
        return new Flow(goon ? function.apply(obj) : null, goon);
    }

    public <R> Flow<R> map(Function<H, R> function) {
        if (!this.goon)
            return new Flow(null, false);
        return new Flow(goon ? function.apply(obj) : null, goon);
    }

    /**
     * check after function's calculation
     */
    public <R> Flow<R> map(Function<H, R> function, Predicate<R> postCheck) {
        R re = function.apply(obj);
        return new Flow(re, re != null && postCheck.test(re));
    }

    public void test() {
        Map<String, List<String>> map = null;
        String s = Flow.of(map)
                .map(e -> e.get(""), a -> a.isEmpty())
                .map((List<String> list) -> list.get(0), ss -> ss.contains("a"))
                .getOrElse("fuck");
    }

}
