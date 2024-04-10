package Text;

import java.util.Arrays;

public class ExtractNumbers {
    public static void main(String[] args) {
        String str = "ABC137GMNQQ2049PN5FFF";
        String[] split = str.split("");
        StringBuilder arr = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (split[i].matches("[0-9]")) {
                arr.append(split[i]);
            }
        }
        //排序从小到大然后输出
        String[] arr1 = arr.toString().split("");
        //冒泡排序
        for (int i = 0; i < arr1.length - 1; i++) {
            for (int j = 0; j < arr1.length - 1 - i; j++) {
                if (Integer.parseInt(arr1[j]) > Integer.parseInt(arr1[j + 1])) {
                    String temp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp;
                }
            }
        };
        System.out.println(Arrays.toString(arr1));
    }
}
