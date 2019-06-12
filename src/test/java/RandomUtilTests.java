import fr.openclassrooms.vb.escapegameonline.Combination;
import fr.openclassrooms.vb.escapegameonline.Constants;
import fr.openclassrooms.vb.util.RandomUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomUtilTests {

    Combination mock = new Combination();

    /**
     * This function test if number from randomFigure is in [0;9] (one milion times)
     */
    @Test
    public void testOfRandom(){
        for(int i=0; i<1000000; i++){
            int randNumber = RandomUtil.randomFigure();
            Assertions.assertTrue(((randNumber>= Constants.MIN)&&(randNumber<=Constants.MAX)));
        }

    }

    /**
     * This function test if tab is correctly define
     */
    @Test
    public void testOfGenerateCombination(){
        mock.setCombination(RandomUtil.generateCombination(mock.getCombinationLength()));
        for(int i=0; i<mock.getCombinationLength(); i++){
            Assertions.assertTrue(((mock.getCombination()[i]>=0)&&(mock.getCombination()[i]<=9)));
        }

    }
}
