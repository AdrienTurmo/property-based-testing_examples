import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Test;
import org.quicktheories.QuickTheory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.quicktheories.generators.SourceDSL.integers;
import static org.quicktheories.generators.SourceDSL.strings;

public class FizzBuzzTest {

    @Test
    public void middle_should_be_in_the_result() throws Exception {
        QuickTheory.qt()
                .forAll(integers().all())
                .assuming(a -> (a % 3 != 0)&&(a % 5 != 0))
                .check(a -> FizzBuzz.answer(a).equals(String.valueOf(a)));
    }

    @Test
    public void one_should_return_one() throws Exception {
        assertThat(FizzBuzz.answer(1)).isEqualTo("1");
    }
}