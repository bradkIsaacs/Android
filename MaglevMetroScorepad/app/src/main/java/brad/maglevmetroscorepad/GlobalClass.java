package brad.maglevmetroscorepad;

import android.app.Application;

public class GlobalClass extends Application {
    String p1Name, p2Name, p3Name, p4Name;
    int p1Score = 0;
    int p2Score = 0;
    int p3Score = 0;
    int p4Score = 0;

    public String getP1Name() {
        return p1Name;
    }

    public void setP1Name(String p1Name) {
        this.p1Name = p1Name;
    }

    public String getP2Name() {
        return p2Name;
    }

    public void setP2Name(String p2Name) {
        this.p2Name = p2Name;
    }

    public String getP3Name() {
        return p3Name;
    }

    public void setP3Name(String p3Name) {
        this.p3Name = p3Name;
    }

    public String getP4Name() {
        return p4Name;
    }

    public void setP4Name(String p4Name) {
        this.p4Name = p4Name;
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
