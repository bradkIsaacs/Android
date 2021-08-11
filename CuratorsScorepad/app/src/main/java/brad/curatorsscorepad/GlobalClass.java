package brad.curatorsscorepad;

import android.app.Application;

public class GlobalClass extends Application {

    boolean advanced;
    String p1, p2, p3, p4;
    int p1Score = 0;
    int p2Score = 0;
    int p3Score = 0;
    int p4Score = 0;

    public boolean isAdvanced() {
        return advanced;
    }

    public void setAdvanced(boolean advanced) {
        this.advanced = advanced;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4;
    }

    public int getP1Score() {
        return p1Score;
    }

    public void setP1Score(int add) {
        this.p1Score += add;
    }

    public int getP2Score() {
        return p2Score;
    }

    public void setP2Score(int add) {
        this.p2Score += add;
    }

    public int getP3Score() {
        return p3Score;
    }

    public void setP3Score(int add) {
        this.p3Score += add;
    }

    public int getP4Score() {
        return p4Score;
    }

    public void setP4Score(int add) {
        this.p4Score += add;
    }
}
