import java.util.ArrayList;

public class Game {

    //Method zum Karte zu zaehlen
    private CardDeck cardDeck = new CardDeck();
    private CardDeck discardPile = new CardDeck();  //ablegestapel
    private Table table = new Table();

    public ArrayList<Player> playersInGame = new ArrayList<>();


    public void addPlayerToPlayerList(Player p) {
        playersInGame.add(p);
    }


    public void shareCards() {
        for (Player p : playersInGame) {
            for (int i = 0; i < 7; i++) {
                p.giveCard(cardDeck.drawCard());
            }
        }
    }

    public Card layStartCard() {
        Card card = new Card(null, null);
        card = cardDeck.drawCard();
        return card;
    }

    public void start() {
        shareCards();
        layStartCard();
    }


    public void cardChoice() {
        do {
            for (Player p : playersInGame) {
                System.out.println("Card on Table: ");
                System.out.println(layStartCard());
                System.out.println("Player " + p.getName() + " your turn");
                System.out.println("Your cards: " + p.showMyCards());
                System.out.println("Welche Karte möchten Sie ausspielen?");

                discardPile.addToDiscardPile(p.playerDropCard());
            }
        } while(table !=  null);
    }


    @Override
    public String toString() {
        return "Game:" + "First card: " + layStartCard() + "\n" + "Players with cards: " + playersInGame;
    }
}
