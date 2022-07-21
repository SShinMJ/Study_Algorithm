import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] mx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] my = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] score  = {0, 0, 0, 1, 1, 2, 3, 5, 11};

    static int W, N;
    static char[][] map;
    static boolean[][] visited;
    static String answer;
    static int sum;
    static int count;
    //StringBuilder는 멀티스레드에서 안전하지 않으므로 이 경우 StringBuffer를 사용!
    //알고리즘 문제는 멀티스레드(여러 작업을 동시에)를 쓰지 않으므로 상관 무.
    //buffer의 경우 스레드 체크를 하므로, 시간이 좀 더 걸리기 때문에 builder를 사용.
    static StringBuilder sb = new StringBuilder();
    static trieNode root = new trieNode();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        W = Integer.parseInt(br.readLine());

        for(int i = 0; i < W; i++){
            insertTrieNode(br.readLine());
        }

        br.readLine();
        N = Integer.parseInt(br.readLine());
        StringBuilder resultSb = new StringBuilder();
        for(int n = 0; n < N; n++){
            map = new char[4][4];
            visited = new boolean[4][4];
            answer = "";
            sum = 0;
            count = 0;
            sb = new StringBuilder();

            for(int i = 0; i < 4; i++){
                String in = br.readLine();
                for(int k = 0; k < 4; k++){
                    map[i][k] = in.charAt(k);
                }
            }
            br.readLine();
            for(int y = 0; y < 4; y++){
                for(int x = 0; x < 4; x++){
                    //출력 가능 조건 -> root가 해당 child를 가지면
                    if(root.hasChild(map[y][x])) {
                        search(y, x, root.getChild(map[y][x]));
                    }
                }
            }
            //결과 담기 : 최대 점수, 가장 긴 단어, 찾은 단어
            //resultSb.append()
            root.clearHit();
        }
        System.out.println(resultSb.toString());

    }
    //x, y는 이동할 곳. node는 트라이 노드 위치. 두 위치가 같이 이동해야함!
    static void search(int y, int x, trieNode node){
        //1. 체크인 -> visited 확인
        visited[y][x] = true;
        sb.append(map[y][x]); // 하나 추가.
        //2. 목적지에 도달하였는가? -> isWord == ture(단어인가), isHit == false(찾은 적이 없는가)
        if(node.isWord == true && node.isHit == false){
            node.isHit = true;
            //목적지 도착이므로 답 작업 : 단어의 길이, 단어, 단어의 개수
            String foundWord = sb.toString();
            int Length = foundWord.length();
        }
        //3. 연결된 곳을 순회 -> 8방
        for(int i = 0; i < 8; i++){
            int ty = y + my[1]; // 자식 위치
            int tx = x + mx[1];
            //4. 가능한가? -> map 안인지, 방문한 적이 없는지, node가 해당 자식을 가지고 잇는지 확인(가져야 갈 수 있음)
            if(0 <= ty && ty < 4 && 0 <= tx && tx < 4) { // 맵 경계 안인가?
                if (visited[ty][tx] == false && node.hasChild(map[ty][tx])) { //가본적이 없고, 현재 노드가 자식을 가지고 잇는가?
                    search(ty, tx, node.getChild(map[ty][tx]));
                }
            }
        }

        //5. 체크아웃
        visited[y][x] = false;
        sb.deleteCharAt(sb.length()-1); // 가장 뒤의 것 삭제
    }

    static void insertTrieNode(String word){
        // 트라이의 시작 : root, 처음은 자식이 없는 상태로 시작함.
        trieNode current = root;
        //트라이 포인터 하나, 넣을 단어 배열 포인터 하나.
        for (int i = 0; i < word.length(); i++){
            char spell = word.charAt(i); //단어의 스팰링을 하나씩 가져옴
            //이 스팰링이 트라이에 있는지 확인
            int index = spell - 'A';
            if(current.child[index] == null){ //null이면 자식이 없는 것.
                //자식이 없으므로 자식을 하나 붙여줘야함
                current.child[index] = new trieNode();
            }
            //자식이 있을때나 없을때나 이제 자식이 생겼으므로, current값을 아래로(자식으로) 내려줘야함
            current = current.child[index];
        }
        //for문이 끝나고 나면 current는 leaf(단어의 끝)에 도착해있음
        //따라서 단어의 끝임을 알려야 함. > isWord
        current.isWord = true;
    }
}

class trieNode {
    boolean isWord = false;
    boolean isHit = false;
    trieNode[] child = new trieNode[26];

    void clearHit(){
        isHit = false;
        for(int i = 0; i < child.length; i++){
            if(child[i] != null){
                child[i].clearHit();
            }
        }
    }

    boolean hasChild(char c){
        return child[c - 'A'] != null;
    }

    trieNode getChild(char c){
        return child[c - 'A'];
    }
}
