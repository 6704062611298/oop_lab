package Lab3;
import java.util.Scanner;
class RoachPopulation {
    private int roaches;

    public RoachPopulation(int roaches) {
        this.roaches = roaches;
    }

    public void waitTime() {
        roaches *= 2;
    }

    public void spray() {
        roaches = (int)(roaches * 0.9);
    }

    public int getRoaches() {
        return roaches;
    }
}

public class No5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int round = sc.nextInt();

        RoachPopulation r = new RoachPopulation(start);

        for(int i=0;i<round;i++){
            r.waitTime();
            r.spray();
            System.out.println(r.getRoaches());
        }
    }
}