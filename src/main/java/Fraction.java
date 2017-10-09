import org.assertj.core.api.AbstractBigDecimalAssert;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        int gcd = gcd(numerator,denominator);
        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;
    }

    @Override
    public String toString() {
        return String.valueOf(numerator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (numerator != fraction.numerator) return false;
        return denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    private int gcd(int a, int b){
        return b == 0 ? a : gcd (b, a % b);
    }

    public Fraction multiplyBy(int multi) {
        return new Fraction(numerator*multi,denominator);
    }

    public Fraction multiplyBy(Fraction fraction) {
        return new Fraction(this.numerator*fraction.numerator,this.denominator*fraction.denominator);
    }




    public static void main(String[] args) {
        int a = -2;
        int b = -2147483648;

        System.out.println(a*b);
    }
}
