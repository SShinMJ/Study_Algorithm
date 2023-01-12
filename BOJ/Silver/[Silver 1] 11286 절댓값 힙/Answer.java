import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        MinHeap mh = new MinHeap();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                sb.append(mh.delete() + "\n");
            } else {
                mh.insert(input);
            }
        }
        System.out.println(sb);
    }
}

// 최소힙을 구현하는 클래스
class MinHeap {
    List<Integer> list;

    // 새 트리 생성
    public MinHeap() {
        list = new ArrayList<>();
        list.add(0);
    }

    // 요소 삽입
    public void insert(int val) {
        list.add(val);
        int current = list.size() - 1;
        int parent = current / 2;

        // 해당 요소가 삽입 될 위치 찾기
        while (true) {
            // 루트이거나, 부모 절대값이 현재 요소보다 작다면
            if (parent == 0 || Math.abs(list.get(parent)) < Math.abs(list.get(current))) {
                // 현재 위치가 삽입될 위치.
                break;
            }
            // 부모 절대값이 현재 요소와 같다면
            else if(Math.abs(list.get(parent)) == Math.abs(list.get(current))) {
                // 절대값이 같은 경우 부모 값이 더 작다면
                if(list.get(parent) < list.get(current)) {
                    // 현재 위치가 삽입될 위치.
                    break;
                }
            }

            // 현재값이 부모값보다 작다면 둘의 위치를 바꾼다.
            int temp = list.get(parent);
            list.set(parent, list.get(current));
            list.set(current, temp);

            // 바뀐 위치 저장.
            current = parent;
            parent = current / 2;
        }
    }

    // 가장 작은 요소 반환 및 삭제
    public int delete() {
        // 요소가 존재하는 지 확인
        if (list.size() == 1) {
            return 0;
        }
        // 첫번째 값이 최소
        int top = list.get(1);
        // 첫번째 값과 가장 마지막 값을 교체.
        list.set(1, list.get(list.size() - 1));
        // 마지막 값이 된 첫번째 값을 삭제.
        list.remove(list.size() - 1);

        // 첫번째 값이 된 마지막 값이 위치할 곳을 찾아 내려가야함.
        int currentPos = 1;
        while (true) {
            int leftPos = currentPos * 2;  // 왼쪽 자식
            int rightPos = currentPos * 2 + 1; // 오른쪽 자식

            // 현재 노드가 노드의 끝일 경우 (자식 노드가 없을 경우)
            if (leftPos >= list.size()) {
                break;
            }

            // 왼쪽 노드가 있으므로 우선 저장
            int minValue = list.get(leftPos);
            int minPos = leftPos;

            // 오른쪽 노드가 존재하며
            if(rightPos < list.size()) {
                // 오른쪽 노드가 왼쪽 노드보다 작다면
                // 또는 자식들의 절대값이 서로 같으며 오른쪽 값이 더 작다면
                if (Math.abs(minValue) > Math.abs(list.get(rightPos)) ||
                        ((Math.abs(minValue) == Math.abs(list.get(rightPos)) &&
                                minValue > list.get(rightPos)))) {
                    // 오른쪽 노드를 최소값으로 저장
                    minValue = list.get(rightPos);
                    minPos = rightPos;
                }
            }

            // 자식 노드의 최소값과 현재값을 비교.
            if(Math.abs(list.get(currentPos)) > Math.abs(minValue) ||
                    (Math.abs(list.get(currentPos)) == Math.abs(minValue) &&
                            list.get(currentPos) > minValue)) {
                // 현재값이 자식보다 더 크거나, 절대값이 같으며 현재값이 더 큰 경우
                int temp = list.get(currentPos);
                // 부모-자식 위치 교체
                list.set(currentPos, minValue);
                list.set(minPos, temp);
                // 교체된 위치로 변경하여 아래 자식들과도 비교한다.
                currentPos = minPos;
            }
            // 자식보다 작다면 종료.
            else {
                break;
            }
        }

        return top;
    }
}