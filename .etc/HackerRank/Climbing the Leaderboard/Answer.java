import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // 동점자는 동일 순위로 치기 때문에 HashSet을 이용하여 중복을 제거
        HashSet<Integer> set=new HashSet<>(ranked);
        ranked=new ArrayList<>(set);
        Collections.sort(ranked, Collections.reverseOrder());


        List<Integer> answer=new ArrayList<>();
        for(int score: ranked){
            System.out.println(score);
        }

        // 이진탐색
        for(int p:player){

            int left=0; //1
            int right=ranked.size()-1; //last
            int mid=0;

            int rank=0;
            while(left<=right){
                mid=(left+right)/2;
                if(p>ranked.get(mid)){
                    right=mid-1;
                }else{
                    left=mid+1;
                }

                if(p==ranked.get(mid)) break;
            }

            if(p<ranked.get(mid)){
                rank=mid+1;
            }else{
                rank=mid;
            }
            answer.add(rank+1);
        }


        for(int ans:answer){
            System.out.println(ans);
        }
        return answer;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}