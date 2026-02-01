// https://school.programmers.co.kr/learn/courses/30/lessons/62048

package sw_study.study;

public class Week1 {
    public long solution(int w, int h) {
        long total = (long) w * h;
        long intersects = 0;

        // x를 0부터 w-1까지 이동하며 각 세로 구간에서 겹치는 사각형 개수를 구함
        for (int x = 0; x < w; x++) {
            // x일 때의 y값과 x+1일 때의 y값 사이의 범위를 계산

            // y = (h * x) / w  방정식을 정수 연산으로 처리 (내림)
            long startY = (long) h * x / w;
            // y = (h * x) / w  방정식을 정수 연산으로 처리 (올림)
            long endY = ((long) h * (x + 1) + (w - 1)) / w;

            // 해당 x 구간에서 대각선이 거쳐가는 변의 수
            intersects += (endY - startY);
        }

        return total - intersects;
    }
}
