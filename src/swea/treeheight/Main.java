package swea.treeheight;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // ───────── 입출력 준비 ─────────
        // 로컬 실행 시에만 input.txt를 표준 입력으로 연결.
        // 제출 환경에서는 파일이 없어도 터지지 않도록 try-catch.
        try {
            System.setIn(new FileInputStream("src/swea/treeheight/input.txt"));
        } catch (FileNotFoundException ignored) {
            // 제출 환경 → 표준 입력 그대로 사용
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= t; tc++) {
            // ───────── 1) 입력 파싱 ─────────
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] heights = new int[n];
            int maxH = 0;
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
                if (heights[i] > maxH) maxH = heights[i];
            }

            // ───────── 2) 필요 성장량 통계 계산 ─────────
            //   S        : 전체 필요 성장량의 합
            //   oddCount : diff가 홀수인 나무의 개수 (홀수 날 반드시 필요)
            long S = 0;
            int oddCount = 0;
            for (int h : heights) {
                int d = maxH - h;
                S += d;
                if ((d & 1) == 1) oddCount++;
            }

            // ───────── 3) 최소 D 탐색 ─────────
            // D일 시행 시:
            //   O = (D+1)/2  ← 홀수 날(1,3,5,...)의 개수, +1 토큰 수
            //   E = D/2      ← 짝수 날(2,4,6,...)의 개수, +2 토큰 수
            //
            // 두 조건을 동시에 만족하는 최소 D가 정답:
            //   ① O >= oddCount        (홀수 diff마다 +1 토큰 한 개 필수)
            //   ② O + 2E >= S          (총 예산이 총 필요량 이상)
            int day = 0;
            while (true) {
                int O = (day + 1) / 2;
                int E = day / 2;
                if (O >= oddCount && (long) O + 2L * E >= S) break;
                day++;
            }

            // ───────── 4) 출력 누적 ─────────
            sb.append('#').append(tc).append(' ').append(day).append('\n');
        }

        System.out.print(sb);
    }
}