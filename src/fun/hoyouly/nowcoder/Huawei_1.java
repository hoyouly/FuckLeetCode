package fun.hoyouly.nowcoder;

import java.util.*;

public class Huawei_1 {
    public static int lengthOfLast(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        str = str.trim();
        String[] array = str.split(" ");
        if (array == null) {
            return str.length();
        }
        return array[array.length - 1].length();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (s.hasNext()) {
            String str = s.next();
            if (!list.contains(str)) {
                list.add(str);
            }
        }
        Collections.sort(list);
        for (String i : list) {
            System.out.print(i);
        }
    }
}
