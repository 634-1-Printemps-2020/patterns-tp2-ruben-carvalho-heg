package materials;

public class Coin {

  private CoinState coinState;
  private static Coin COIN = new Coin();

  public static Coin getCoin() {
    return COIN;
  }

  /**
   * 50% de probabilité d'obtenir HEADS, 50% de probabilité d'obtenir TAILS
   * @return l'état de la pièce
   */
  private CoinState randomPick() {
    return CoinState.values()[(int) (Math.random()*CoinState.values().length)];
  }

  /**
   * Change l'état de la pièce.
   * 50% de probabilité d'obtenir HEADS, 50% de probabilité d'obtenir TAILS
   */
  public void throwCoin() {
      coinState = randomPick();
  }

  /**
   * Avoir l'état de la pièce.
   * @return état de la pièce.
   */
  public CoinState getState() {
    return coinState;
  }
}
