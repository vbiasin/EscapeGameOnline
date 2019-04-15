import EscapeGameOnline.Combination;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CombinationTests {

    Combination mock = new Combination();
    @Test
    public void testerNombre(){
        for(int i=0; i<100000; i++){
            int randNumber = mock.randomFigure();
            assertTrue(((randNumber>=0)&&(randNumber<=9)));
        }

    }

}
