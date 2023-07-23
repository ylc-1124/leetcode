package 二工大PTA;

public class _6_8使用函数输出水仙花数 {
   static int narcissistic( int number ){
        int sum = 0; //存储number各个位数的N次幂之和
        int N = 0; //number的位数
        int tmp = number;
        //计算位数
        while(number != 0){
            number /= 10;
            N++;
        }
        number = tmp;
        // 求sum
        while(number != 0){
            int n = number % 10;
            number /= 10;
            sum += Math.pow(n, N);
        }
        return sum == tmp ? 1 : 0;
    }
    static void PrintN( int m, int n ){
        for(int i = m; i <= n; i++){
            if(narcissistic(i) == 1){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(narcissistic(153));
    }
}
