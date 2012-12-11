
import java.util.Random;

public class Sokkelo {

    Random r;

    public Sokkelo() {
        r = new Random();
    }

    public int[][] teeSokkelo(int korkeus, int leveys) {
        int[][] sokkelo = new int[korkeus][leveys];

        for (int i = 0; i < korkeus; i++) {
            for (int n = 0; n < leveys; n++) {
                double luku = r.nextDouble();
                if (i == 0 && n == 0 || i == korkeus-1 && n == leveys-1) {
                    sokkelo[i][n] = 0;
                } else {
                    if (luku <= 0.3) {
                        sokkelo[i][n] = 1;
                    } else {
                        sokkelo[i][n] = 0;
                    }
                }

            }
        }

        return sokkelo;
    }
}
