package org.example.studyTwoDays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());  //n값 집어넣기
        int k = Integer.parseInt(st.nextToken()); //집합 k 길이 집어넣기


        int[] arr = new int[k]; //집합 k 배열로 선언
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < k; i++) { //집합 k 배열로 값 집어넣기
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        while(n > 0) { //집합 k 배열로만 만들수 있는 수중 가장 큰 수만 출력하는거라 0부터 세는게 아니라 뒤에서부터 센다
            result = n;

            int count = 0; //새로운 숫자마다 카운트를 초기화 해줘야 한다
            count = counts(count, result, arr, k);


            if(count > 0) {
                String str = Integer.toString(n); //현재 검사하는 숫자의 길이를 알기 위해 문자열 변화
                int length = str.length(); //현재 숫자를 문자로 변환 후 길이 출력

                if(count == length) { //for문으로 센 숫자와 현재 숫자의 문자열로 변환 후의 길이와 동일하면 출력 후 break
                    System.out.println(n);
                    break;
                }
            }
            n--;
        }}

    public static int counts(int count, int result, int[] arr, int k){
        while(result > 0) {
            for(int j = 0; j < k; j++) {
                if(arr[j] == result % 10) { //10으로 나누면 각자릿수를 구할수 있다
                    count++; //k의 모든 원소가 속해있는지 확인하기 위해 카운트를 세준다
                    continue; //continue를 한 이유는 배열안에 있는 수가 또 존재하면 숫자를 한번 더 카운트 하기 때문에 한번 쪽같으면 for문만 빠져나와야 한다
                }
            }
            result = result / 10; //10으로 나눈 몫을 넣으면 검사한 자릿수의 나머지 부분을 검사할수 있게 해준다
        }
        return count;

    }



}

