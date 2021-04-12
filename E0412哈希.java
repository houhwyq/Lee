package easy;

//给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
//        机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
//        如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。

import java.util.HashSet;
import java.util.Set;

public class E0412哈希 {
    class Solution {
        public boolean isPathCrossing(String path) {
            Set<Integer> vis = new HashSet<Integer>();

            int x = 0, y = 0;
            vis.add(getHash(x, y));

            int length = path.length();
            for (int i = 0; i < length; i++) {
                char dir = path.charAt(i);
                switch (dir) {
                    case 'N': --x; break;
                    case 'S': ++x; break;
                    case 'W': --y; break;
                    case 'E': ++y; break;
                }
                int hashValue = getHash(x, y);
                if (!vis.add(hashValue)) {
                    return true;
                }
            }

            return false;
        }

        public int getHash(int x, int y) {
            return x * 20001 + y;
        }
    }
}
