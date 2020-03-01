package game;

import materials.Coin;
import materials.CoinState;
import org.w3c.dom.ls.LSOutput;
import player.Player;
import utils.Statistics;

import java.util.*;

public class Game {

    private Rules rules;
    private Coin coin;
    private Statistics statistics;
    private Map<Player, List<CoinState>> history;

    public Game() {
        history = new HashMap<>();
        coin = Coin.getCoin();
        rules = Rules.getRules();
    }

    /**
     * Ajouter un nouveau joueur au jeu
     * @param player le nouveau joueur
     */
    public void addPlayer(Player player) {
        history.put(player, new ArrayList<>());
    }

    /**
     * Faire joueur tous les joueurs et stocker chaque partie dans history
     */
    public void play() {
        for (Player player : history.keySet()) {
            boolean checkWin = false;
            while (!checkWin) {
                List<CoinState> lstCoinState = history.get(player);
                player.play(coin);
                lstCoinState.add(coin.getState());

                if(lstCoinState.size() >= 3) {
                    checkWin = rules.checkWin(lstCoinState);
                }
            }
        }
    }

    /**
     * Calculer des statistiques de la partie précédente
     *
     * @return Statistics
     */
    public Statistics getStatistics() {
        int total = 0;
        int fewerMoves = 100;
        int mostMoves = 0;
        for(List<CoinState> lst : history.values())
        {
            if (lst.size() < fewerMoves) {
                fewerMoves = lst.size();
            }
            if (lst.size() > mostMoves) {
                mostMoves = lst.size();
            }
            total += lst.size();
        }
        int average = total / history.keySet().size();
        return new Statistics(average, fewerMoves, mostMoves, total);
    }

    /**
     * Obtenir l'historique de tous les joueurs de la partie précédente
     *
     * @return Map contenant chaque joueur et la liste des ses lancers
     */
    public Map<Player, List<CoinState>> getHistory() {
        return history;
    }


    /**
     * Obtenir l'historique d'un joueur spécifique
     *
     * @param player instance du joueur pour lequel on veut avoir l'historique
     * @return la liste des lancers d'un joueur
     */
    public List<CoinState> getSpecificHistory(Player player) {
        return history.get(player);
    }

}
