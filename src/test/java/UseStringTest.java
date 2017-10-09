import org.junit.Test;
import org.quicktheories.QuickTheory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.quicktheories.generators.SourceDSL.*;


public class UseStringTest {

    @Test
    public void middle_should_be_in_the_result() throws Exception {
        QuickTheory.qt()
                .forAll(strings().allPossible().ofLengthBetween(0, 100), strings().allPossible().ofLengthBetween(0, 100), strings().allPossible().ofLengthBetween(0, 100))
                .checkAssert((a, b, c) -> assertThat(UseString.concat(a, b, c).contains(b)).isTrue());
    }


}