import org.junit.Ignore;
import org.junit.Test;
import org.quicktheories.QuickTheory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.quicktheories.generators.SourceDSL.integers;

public class FractionTest {

    @Test
    public void fraction_of_0_is_one() throws Exception {
        Fraction fraction_0 = new Fraction(0);

        assertThat(fraction_0.toString()).isEqualTo("0");
    }

    @Test
    public void fraction_of_1_is_one() throws Exception {
        Fraction fraction_1 = new Fraction(1);

        assertThat(fraction_1.toString()).isEqualTo("1");
    }

    @Test
    public void fraction_of_10_is_ten() throws Exception {
        Fraction fraction_10 = new Fraction(10);

        assertThat(fraction_10.toString()).isEqualTo("10");
    }

    @Test
    public void fraction_zero_over_one_is_integer() throws Exception {
        Fraction fraction_0_1 = new Fraction(0, 1);
        Fraction fraction_0 = new Fraction(0);

        assertThat(fraction_0_1.equals(fraction_0)).isTrue();
    }

    @Test
    public void fraction_one_over_one_is_integer() throws Exception {
        Fraction fraction_1_1 = new Fraction(1, 1);
        Fraction fraction_1 = new Fraction(1);

        assertThat(fraction_1_1.equals(fraction_1)).isTrue();
    }

    @Test
    public void fraction_should_simplify() throws Exception {
        Fraction fraction_2_2 = new Fraction(2, 2);
        Fraction fraction_1_1 = new Fraction(1, 1);

        assertThat(fraction_2_2.equals(fraction_1_1)).isTrue();
    }

    @Test
    public void fraction_should_simplify_2() throws Exception {
        Fraction fraction_45_120 = new Fraction(45, 120);
        Fraction fraction_3_8 = new Fraction(3, 8);

        assertThat(fraction_45_120.equals(fraction_3_8)).isTrue();
    }

    @Test
    public void should_multiply_fraction_by_zero() throws Exception {
        Fraction fraction_1_5 = new Fraction(1, 5);
        Fraction fraction_0 = new Fraction(0);

        assertThat(fraction_1_5.multiplyBy(0).equals(fraction_0)).isTrue();
    }

    @Test
    public void should_multiply_fraction_by_one() throws Exception {
        Fraction fraction_2_7 = new Fraction(2, 7);

        assertThat(fraction_2_7.multiplyBy(1).equals(fraction_2_7)).isTrue();
    }

    @Test
    public void should_multiply_fraction_by_ten() throws Exception {
        Fraction fraction_3_20 = new Fraction(3, 20);
        Fraction fraction_3_2 = new Fraction(3, 2);

        assertThat(fraction_3_20.multiplyBy(10).equals(fraction_3_2)).isTrue();
    }

    @Test
    public void should_multiply_fraction_by_fraction_zero() throws Exception {
        Fraction fraction_1_2 = new Fraction(1, 2);
        Fraction fraction_0 = new Fraction(0);

        assertThat(fraction_1_2.multiplyBy(fraction_0).equals(fraction_0)).isTrue();
    }

    @Test
    public void should_multiply_fraction_by_fraction_one() throws Exception {
        Fraction fraction_2_1 = new Fraction(2, 1);
        Fraction fraction_1 = new Fraction(1);

        assertThat(fraction_2_1.multiplyBy(fraction_1).equals(fraction_2_1)).isTrue();
    }

    @Test
    public void should_multiply_two_fractions() throws Exception {
        Fraction fraction_2_1 = new Fraction(2, 1);
        Fraction fraction_5_6 = new Fraction(5, 6);
        Fraction fraction_5_3 = new Fraction(5, 3);

        assertThat(fraction_2_1.multiplyBy(fraction_5_6).equals(fraction_5_3)).isTrue();
    }

    @Ignore
    @Test
    public void can_multiply_any_two_fraction() throws Exception {
        QuickTheory.qt()
                .forAll(integers().all(), integers().all(), integers().all(), integers().all())
                .assuming((n1, d1, n2, d2) -> (d1 != 0) && (d2 != 0))
                .checkAssert((n1, d1, n2, d2) ->
                        (new Fraction(n1,d1))
                                .multiplyBy(new Fraction(n2,d2))
                                .equals(new Fraction(n1*n2,d1*d2)));
    }
}