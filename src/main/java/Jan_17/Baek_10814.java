package Jan_17;

import java.io.*;
import java.util.StringTokenizer;

public class Baek_10814 {

    static class Peoples {
        int age;
        String name;

        Peoples(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    static Peoples[] member, subMember;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        member = new Peoples[N];
        subMember = new Peoples[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            member[i] = new Peoples(age, name);
        }
        sort(0, N - 1);
        for (Peoples i : member) {
            System.out.println(i.age + " " + i.name);
        }
    }

    private static void sort(int start, int end) {
        if (end - start < 1) {
            return;
        }
        int middle = start + (end - start) / 2;
        sort(start, middle);
        sort(middle + 1, end);
        for (int i = start; i <= end; i++) {
            subMember[i] = member[i];
        }
        int k = start;
        int index1 = start;
        int index2 = middle + 1;
        while (index1 <= middle && index2 <= end) {
            if (subMember[index1].age <= subMember[index2].age) {
                member[k] = subMember[index1];
                k++;
                index1++;
            } else {
                member[k] = subMember[index2];
                k++;
                index2++;
            }
        }
        while (index1 <= middle) {
            member[k] = subMember[index1];
            k++;
            index1++;
        }
        while (index2 <= end) {
            member[k] = subMember[index2];
            k++;
            index2++;
        }
    }
}
