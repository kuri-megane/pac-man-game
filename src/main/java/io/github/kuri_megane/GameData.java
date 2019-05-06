package io.github.kuri_megane;

/**
 * プレイヤーのゲームデータのクラス
 */
public class GameData {

    private String name;
    private int playerScore;
    private int monsterScore;
    private boolean dead;

    public GameData() {
    }

    /**
     * プレイヤー名を取得します．
     *
     * @return プレイヤー名
     */
    public String getName() {
        return name;
    }

    /**
     * プレイヤー名を設定します．
     *
     * @param name プレイヤー名のString
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * プレイヤーのスコアを取得します．
     *
     * @return プレイヤーのスコア
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * プレイヤーのスコアを設定します．
     *
     * @param playerScore プレイヤーが獲得した Cookie の数
     */
    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    /**
     * モンスターのスコアを取得します．
     *
     * @return モンスターのスコア
     */
    public int getMonsterScore() {
        return monsterScore;
    }

    /**
     * モンスターのスコアを設定します．
     *
     * @param monsterScore モンスターが獲得した cookie の数
     */
    public void setMonsterScore(int monsterScore) {
        this.monsterScore = monsterScore;
    }

    /**
     * パックマンがモンスターに捕まったか設定します．
     *
     * @return 捕まったら true
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * パックマンがモンスターに捕まったかどうかを保存します．
     */
    public void setDead(boolean isDead) {
        dead = isDead;
    }

}
