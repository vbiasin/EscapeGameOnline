import fr.openclassrooms.vb.escapegameonline.Combination;
import fr.openclassrooms.vb.util.RandomUtil;
import org.junit.jupiter.api.Test;

public class CombinationTests {

    Combination mock = new Combination();
    Combination test = new Combination();

    /**
     * This function test if two combinations are correctly compared
     */
    @Test
    public void testOfCompareCombination(){
        mock.setCombination(RandomUtil.generateCombination(mock.getCombinationLength()));
        test.setCombination(RandomUtil.generateCombination(test.getCombinationLength()));
    }

}
