package practice;

public class SpreadOperator {

    public static void addNumbers(int... numbers){
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    public static void main(String[] args) {
        addNumbers(1, 3, 6, 98, 32, 4);
    }


}
