package 二工大PTA;

public class _6_4使用函数统计指定数字的个数 {
    public int CountDigit( int number, int digit ){
        int count = 0;
        number = Math.abs(number);
        while(number != 0){
            int n = number % 10; //末位
            number /= 10;
            if(n == digit) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(new _6_4使用函数统计指定数字的个数().CountDigit(-12233, 2));
    }
}
