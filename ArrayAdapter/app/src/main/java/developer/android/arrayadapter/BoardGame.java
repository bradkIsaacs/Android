package developer.android.arrayadapter;

class BoardGame {

    String name;
    int min_player;
    int max_player;

    public BoardGame(String name, int min_player, int max_player) {
        this.name = name;
        this.min_player = min_player;
        this.max_player = max_player;
    }

    public String getName() {
        return name;
    }

    public int getMin_player() {
        return min_player;
    }

    public int getMax_player() {
        return max_player;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMin_player(int min_player) {
        this.min_player = min_player;
    }

    public void setMax_player(int max_player) {
        this.max_player = max_player;
    }
}
