package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        int i = 0;
        for (int ele = 1000; ele <= 128000; ele *=2,i++) {
            Stopwatch sw = new Stopwatch();
            SLList<Integer> temp = new SLList<>();
            for (int j = 0; j < ele; j++) {
                temp.addLast(10);
            }
            double timeInSeconds = sw.elapsedTime();
            Ns.addLast(ele);
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns,times,Ns);
    }

}
