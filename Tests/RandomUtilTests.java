import EscapeGameOnline.Combination;
import util.RandomUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

public class RandomUtilTests {

    Combination mock = new Combination();


    /**
     * This function test if number from randomFigure is in [0;9] (one milion times)
     */
    @Test
    public void testOfRandom(){
        for(int i=0; i<1000000; i++){
            int randNumber = RandomUtil.randomFigure();
            Assertions.assertTrue(((randNumber>=0)&&(randNumber<=9)));
        }

    }

}
