package quene;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: porker
 * Date: 2018/4/24
 */
public class LoopQueneTest {
    @Test
    public void testArrayQueneTest() {
        LoopQuene<Integer> quene = new LoopQuene<>(5);
        for (int i = 0; i < 10; i++) {
            quene.enquene(i);
            System.out.println(quene.toString());
            if (i % 2 == 1) {
                quene.dequene();
                System.out.println(quene.toString());
            }


        }

    }

}