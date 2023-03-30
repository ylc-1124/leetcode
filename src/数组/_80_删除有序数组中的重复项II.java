package 数组;

public class _80_删除有序数组中的重复项II {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                //如果下一个等于当前元素则要删除
                if (i + 1 < len && nums[i] == nums[i + 1]) {
                    //前移一项
                    for (int j = i + 2; j < len; j++) {
                        nums[j - 1] = nums[j];
                    }
                    len--; //数组长度-1
                    i--; //使得i下次依然指向次元素，继续判断有没有重复
                }
            }
        }
        return len;
    }
}
