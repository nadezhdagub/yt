import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DZ {
    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static long[][] arr;
    private static int T;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new FileReader("input.txt"));
        writer = new BufferedWriter(new FileWriter("output.txt"));
        reedFile();
        top();
    }

    private static void top() throws IOException {
        for (int i = 0; i < T; i++) {
            long A = arr[i][0];
            long B = arr[i][1];
//            System.out.println(A + " " + B);
            Map<Long, Integer> map_NOD = P(NOD(A, B));
            Map<Long, Integer> map_A = P(A);
            Map<Long, Integer> map_B = P(B);
            for(Map.Entry<Long,Integer> entry_NOD : map_NOD.entrySet()){
                Long key = entry_NOD.getKey();
                if (map_A.containsKey(key)) {
                    map_A.put(key, (map_A.get(key) - entry_NOD.getValue()));
                }
                if (map_B.containsKey(key)) {
                    map_B.put(key, (map_B.get(key) - entry_NOD.getValue()));
                }
            }
            Long max_A = maxKeyinMap(map_A);
            Long max_B = maxKeyinMap(map_B);
            long maxNOD = 0;
            if (max_A > max_B) {
                maxNOD = NOD(A, B * max_A);
            }
            else if (max_B > max_A) {
                maxNOD = NOD(A * max_B, B);
            }
            writer.write(String.valueOf(maxNOD));
            writer.newLine();
        }
        writer.close();
    }

    private static void reedFile() throws IOException {
        T = Integer.parseInt(reader.readLine());
//        if (n < 1 || n > 20) return;
        arr = new long[T][2];
        for (int i = 0; i < T; i++) {
            String str = reader.readLine();
            String[] strArr = str.split(" ");
            for (int j = 0; j < strArr.length; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }
    }

    private static Map<Long, Integer> P(long maxNumber) {
        Map<Long, Integer> map = new LinkedHashMap<>();
        for (long i = 2; i <= maxNumber; i++) {
            for (int j = 1; ; j++) {
                if (maxNumber == 1) {
                    break;
                }
                else if (maxNumber % i == 0) {
                    map.put(i, j);
                    maxNumber = maxNumber / i;
                }
                else {
                    break;
                }
            }
        }
        return map;
    }
    private static Long maxKeyinMap(Map<Long,Integer> map) {
        Long max = 0l;
        for(Map.Entry<Long,Integer> entry : map.entrySet()){
            if (entry.getValue() > 0 && entry.getKey() > max) {
                max = entry.getKey();
            }
        }
        return max;
    }

    private static long NOD(long A, long B) {
        long nod = 1;
        if (A == B) {
            nod = A;
        }
        if (B > A) {
            long C = A;
            A = B;
            B = C;
        }
        if (A > B) {
            long r1 = A % B;
            if (r1 == 0) {
                nod = B;
            }
            else {
                nod = NOD(B, r1);
            }
        }
        return nod;
    }
}
