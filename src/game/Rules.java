package game;

import materials.CoinState;

import java.util.List;

public class Rules {
  private static Rules RULES = new Rules();

  public static Rules getRules() {
    return RULES;
  }

  /**
   * Cette méthode permet de déterminer si une suite d'états de pièce permet de gagner à une partie
   * @param states liste d'états pour un joueur
   * @return true si un joueur a gagné, false sinon
   */
  public boolean checkWin(List<CoinState> states) {
    int count = 0;
    for (CoinState state : states) {
      if (state.name().equals("HEADS")) {
          count = 0;
      } else {
        count++;
      }

      if (count == 3) {
        return true;
      }
    }
    return false;
  }
}
