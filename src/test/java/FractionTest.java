import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        Fraction fraction_0_1 = new Fraction(0,1);
        Fraction fraction_0 = new Fraction(0);

        assertThat(fraction_0_1.equals(fraction_0)).isTrue();
    }

    @Test
    public void fraction_one_over_one_is_integer() throws Exception {
        Fraction fraction_1_1 = new Fraction(1,1);
        Fraction fraction_1 = new Fraction(1);

        assertThat(fraction_1_1.equals(fraction_1)).isTrue();
    }

    @Test
    public void fraction_should_simplify() throws Exception {
        Fraction fraction_2_2 = new Fraction(2,2);
        Fraction fraction_1_1 = new Fraction(1,1);

        assertThat(fraction_2_2.equals(fraction_1_1)).isTrue();
    }

    @Test
    public void fraction_should_simplify_2() throws Exception {
        Fraction fraction_45_120 = new Fraction(45,120);
        Fraction fraction_3_8 = new Fraction(3,8);

        assertThat(fraction_45_120.equals(fraction_3_8)).isTrue();
    }


}