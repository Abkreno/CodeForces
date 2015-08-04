package A2_Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GukiZHatesBoxes {
    static int nums[], nextNum[];
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] l = bf.readLine().split(" ");
        n = Integer.parseInt(l[0]);
        m = Integer.parseInt(l[1]);
        nums = new int[n];
        nextNum = new int[n];
        int lastNum = 0;
        l = bf.readLine().split(" ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(l[i]);
            if (nums[i] > 0) {
                nextNum[lastNum] = i;
                lastNum = i;
            }
        }
        nextNum[lastNum] = -1;
        long lo = 0;
        long hi = 110000000000000L;
        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;
            if (func(mid, lastNum)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        System.out.println(hi);
    }

    static boolean func(long time, int lastNum) {
        long currBoxes = nums[0] == 0 ? nums[nextNum[0]] : nums[0], t = 0;
        int j = 0, prevI;
        boolean change = true;
        for (int i = nums[0] == 0 ? nextNum[0] : 0;;) {
            prevI = i;
            i = currBoxes == 0 ? nextNum[i] : i;
            if (i == -1)
                break;
            currBoxes = currBoxes == 0 ? nums[i] : currBoxes;
            if (change) {
                t = time - (i + 1);
                if (t <= 0)
                    return false;
            } else {
                t -= i - prevI;
                if (t <= 0) {
                    j++;
                    if (j == m)
                        return false;
                    change = true;
                    continue;
                }
            }
            if (currBoxes > t) {
                currBoxes -= t;
                j++;
                if (j == m)
                    return false;
                change = true;
            } else {
                t -= currBoxes;
                currBoxes = 0;
                change = false;
            }
        }
        return true;
    }
}