package fun.hoyouly.nowcoder;


import java.awt.*;
import java.util.*;

public class Huawei_1 {
    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);

        modfiPont(p1, p2);
        System.out.println(p1.x + "  " + p1.y + "  " + p2.x + "  " + p2.y);
//        tryThis();

//        sortBean();
    }

    private static void modfiPont(Point p1, Point p2) {
        Point tem = p1;
        p1 = p2;
        p2 = tem;

        p1.setLocation(5, 5);
        p2 = new Point(5, 5);
    }

    public static void tryThis() {
        try {
            System.out.println(1);
            problem();
        } catch (RuntimeException e) {
            System.out.println(2);
            return;
        } catch (Exception e) {
            System.out.println(3);
            return;
        } finally {
            System.out.println(4);
        }

        System.out.println(5);
    }

    public static void problem() throws Exception {
        throw new Exception();
    }


    private static void sortBean() {
        Scanner sc = new Scanner(System.in);
        String text = "cAbadD";
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        ArrayList<CharBean> list = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            Integer value = treeMap.getOrDefault(ch, 0);
            treeMap.put(ch, value + 1);
        }
        Set<Map.Entry<Character, Integer>> entries = treeMap.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            list.add(new CharBean(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list, new Comparator<CharBean>() {
            @Override
            public int compare(CharBean o1, CharBean o2) {
                int seconde = o2.num - o1.num;
                if (seconde == 0) {
                    return o1.ch - o2.ch;
                }
                return seconde;
            }
        });
        for (CharBean bean : list) {
            for (int i = 0; i < bean.num; i++) {
                System.out.print(bean.ch);
            }
        }
    }

    public static class CharBean {
        private char ch;
        private int num;

        public CharBean(char ch, int num) {
            this.ch = ch;
            this.num = num;
        }

        public char getCh() {
            return ch;
        }

        public void setCh(char ch) {
            this.ch = ch;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    public static int fun(String s) {
        int n = 0;
        int count = 0;
        int temp = 0;
        char ch;
        while (count < s.length()) {
            ch = s.charAt(s.length() - count - 1);
            if (ch >= '0' && ch <= '9') {
                temp = ch - '0';
            } else if (ch > 'A' && ch <= 'Z') {
                temp = ch - 'A' + 10;
            } else if (ch >= 'a' && ch <= 'z') {
                temp = ch - 'a' + 10;
            } else {
                break;
            }
            n += temp * Math.pow(16, count);
            count++;
        }
        return n;
    }
}
