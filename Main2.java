package org.example.studyTwoDays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    static int n, k, ans;
    static int[] kArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        kArr = new int[k];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            kArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(kArr); //오름차순 정렬
        //Arrays.stream(kArr).forEach(i-> System.out.println(i)); //단순 오름차순 되었는지 확인
        dfs(0);
        System.out.println(ans);

    }

    public static void dfs(int num) {
        if(num >  n) return; //계산된 값이 구하려는 수보다 크면 계산할 필요가 없서 return

        if(ans < num) ans = num; //최대값 구하는 공식

        for (int i = k - 1; i >= 0; i--) { //디버그하여 확인해보니 배열 안에 있는 숫자로 각 자릿수로 만들수 있는 모든수를 만든다
            dfs(num * 10 + kArr[i]);
        }
    }
}
