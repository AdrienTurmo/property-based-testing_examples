public class FizzBuzz {

    public static String answer(int numberToConvert) {
        String answer = "";
        answer += addWordToAnswerIfNumberToConvertIsModulo(numberToConvert, 3, "Fizz");
        answer += addWordToAnswerIfNumberToConvertIsModulo(numberToConvert, 5, "Buzz");
        boolean isNumberNotAModuloThreeOrFive = answer.equals("");
        return isNumberNotAModuloThreeOrFive ? String.valueOf(numberToConvert) : answer;
    }

    private static String addWordToAnswerIfNumberToConvertIsModulo(int numberToConvert, int modulo, String word) {
        if ((numberToConvert % modulo) == 0) {
            return word;
        }
        return "";
    }
}
