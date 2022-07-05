import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new FileReader("input.txt"));
        writer = new BufferedWriter(new FileWriter("output.txt"));
        run();
    }

    private static void run() throws IOException {
        int n = Integer.parseInt(reader.readLine());
        if (n < 1) return;
        String line = reader.readLine();
        String[] lineArr = line.split(" ");
        int[] arr = new int[lineArr.length];

        for (int i = 0; i < lineArr.length; i++) {
            arr[i] = Integer.parseInt(lineArr[i]);
        }

        String[] lineAlph = {"a","b","c","d","e","f",
                            "g","h","i","j","k","l",
                            "m","n","o","p","q","r",
                            "s","t","u","v","w","x",
                            "y","z"," "};
        StringBuilder result = new StringBuilder();
        result.append(lineAlph[inversions(arr[0])]);

        for (int i = 1; i < arr.length; i++) {
            result.append(lineAlph[inversions(Math.abs(arr[i] - arr[i - 1]))]);
        }

        writer.write(String.valueOf(result));
        reader.close();
        writer.close();
    }

    public static int inversions( int bits ) {
        int W = 0;
        if((bits & 0xffff0000) != 0) {
            bits >>>= 16;
            W = 16;
        }
        if(bits >= 256) {
            bits >>>= 8;
            W += 8;
        }
        if(bits >= 16) {
            bits >>>= 4;
            W += 4;
        }
        if(bits >= 4) {
            bits >>>= 2;
            W += 2;
        }
        return W + ( bits >>> 1 );
    }
}
