package 每日一题;

public class _2525_根据规则将箱子分类 {
    public String categorizeBox(int length, int width, int height,
                                int mass) {
        boolean isBulky = isBulky(length, width, height);
        boolean isHeavy = isHeavy(mass);

        if (isBulky && isHeavy) {
            return "Both";
        } else if (!isBulky && !isHeavy) {
            return "Neither";
        } else if (isBulky) {
            return "Bulky";
        } else {
            return "Heavy";
        }
    }

    public boolean isBulky(int length, int width, int height) {
        return length >= 10000 || width >= 10000 || height >= 10000
                || length  >= 1000000000 / (width * height);
    }
    public boolean isHeavy(int mass) {
        return mass >= 100;
    }

}
