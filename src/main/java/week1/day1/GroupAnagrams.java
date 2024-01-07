package week1.day1;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        HashMap<String, List<String>> map = new HashMap<>();
        for (String a : strs) {
            char[] chars = a.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(a);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(a);
                map.put(sorted, newList);
            }
        }
        System.out.println(new ArrayList<>(map.values()));
    }
}
