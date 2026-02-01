// https://www.acmicpc.net/problem/14501

package sw_study.task;

/*
문제 이해:
    1~N일 동안 하루에 상담 하나씩
        상담 (기간 T, 금액 P)
    기간은 1일 이상이 가능하므로 각자 날짜에서의 시작과 끝인 날짜를 정리하고 이때 얻는 이득을 정리해보는 것이 도움이 될 것 같음.
        입력은 during으로 주어지지만 시작과 끝으로 저장을 하는게 좀 더 직관적일 것 같다는 생각. 예) if(상담[1].end_date < 상담[2].start_date) -> 가능
        상담 (start_date, end_date, price)
    가능한 조합을 전부 구해보고 그 중 최대의 이득을 얻는 스케줄을 선택하는 방식으로 진행

가능한 조합을 찾는 방법:
    for(i = 1~N)
        가능한지 유무 판정(해당 날짜의 상담을 실시할 수 있는지 확인하는 조건문)
            불가능: continue
            가능: 스케줄에 추가 + 패스 둘 다 실행
 */

/*
문제 이해:
    1~N일 동안 하루에 상담 하나씩
        상담 (기간 T, 금액 P)
    기간은 1일 이상이 가능하므로 각자 날짜에서의 시작과 끝인 날짜를 정리하고 이때 얻는 이득을 정리해보는 것이 도움이 될 것 같음.
        입력은 during으로 주어지지만 시작과 끝으로 저장을 하는게 좀 더 직관적일 것 같다는 생각.
풀이:
    -> 총 N일을 배열로 만들고 각 상담이 끝나는 날에 얻는 금액을 더하는 방법으로 얻는 금액을 저장해도 가능할 것 같다.
       예를 들어 1일에 이틀이 걸리고 10을 받고 3일에 하루가 걸리고 15를 받는다하면
       1일부터 보면 배열[3]에 10을 넣고
       3일을 보면 배열[4]에 배열[3]의 값 + 15인 25를 넣는 방식

       이러한 방식으로 전부 구한 후 배열의 최대값을 구하는 방법
 */
import java.io.*;
import java.util.StringTokenizer;

public class Week1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] schedule = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }


        //N=3
        // 1  2  3  4
        // 0  0 60 10
        // 2, 60
        // 2, 10
        // 3, 50
        for (int i = 1; i <= N; i++) {
            schedule[i] = Math.max(schedule[i], schedule[i - 1]);

            int end_date = i + T[i];
            if (end_date <= N + 1) {
                schedule[end_date] = Math.max(schedule[end_date], schedule[i] + P[i]);
            }
        }

        int max = 0;
        for (int i = 1; i <= N + 1; i++) {
            if (max < schedule[i]) max = schedule[i];
        }

        System.out.println(max);
    }
}

