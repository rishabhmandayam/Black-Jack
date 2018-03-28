import java.util.concurrent.ThreadLocalRandom;
public class Main {
    static void p(String s){System.out.println(s);}
    public static void main(String[] args) {
        //A large portion of this code relies on recursive statements. A while loop is tedious and cannot break out of the rest of the code to restart the loop.
        p("Welcome to Black Jack");

        game();

        }
        public static void game(){
            //Recreate deck
            Deck deck = new Deck();
            String hit = "stay";
            p("----------------------");
            //Game begins
            p("Your two face up cards.");
            deck.drawplayer();
            p(deck.getcard());
            deck.drawplayer();
            p(deck.getcard());
            System.out.println(deck.getplayertotal());
            p("-----------------");
            p("Dealer's face up card and facedown card");
            deck.drawdealer();
            p(deck.getcard());
            p("*-*");
            System.out.println(deck.getValueDealer());
            p("----------------------");
            if(deck.getplayertotal() == 21){
                p("You win! You got 21");
                String game = Input.getString("Play again?(yes/no)").toLowerCase();
                if (game.equals("yes")){
                    game();
                }
                else{System.exit(0);}

            }
            else if (deck.getplayertotal()>21){
                p("You lose. Over 21.");
                String game = Input.getString("Play again?(yes/no)").toLowerCase();
                if (game.equals("yes")){
                    game();
                }
                else{System.exit(0);}
            }
            else {
                hit=Input.getString("Hit or Stay?").toLowerCase();
                while (hit.equals("hit")) {
                    deck.drawplayer();
                    p(deck.getcard());
                    System.out.println(deck.getplayertotal());
                    if (deck.getplayertotal() > 21) {
                        //System.out.println("You lose");
                        break;

                    } else {
                        hit = Input.getString("Hit or Stay?").toLowerCase();
                    }

                }
                if (deck.getplayertotal() > 21) {
                    //p(deck.getcard());
                    //System.out.println(deck.getplayertotal());
                    System.out.println("You lose");
                    String game = Input.getString("Play again?(yes/no)").toLowerCase();
                    if (game.equals("yes")){
                        game();
                    }
                    else{System.exit(0);}
                } else {
                    p("Time to reveal the face down card");
                    deck.drawdealer();
                    p(deck.getcard());
                    System.out.println(deck.getValueDealer());
                    if (deck.getValueDealer() == 21) {
                        p("You Lose. The dealer got 21");
                        String game = Input.getString("Play again?(yes/no)").toLowerCase();
                        if (game.equals("yes")){
                            game();
                        }
                        else{System.exit(0);}
                    }
                    p("The dealer prepares to defeat you.");
                    while (deck.getValueDealer() < 17) {
                        deck.drawdealer();
                        p(deck.getcard());
                        System.out.println(deck.getValueDealer());
                    }
                    if (deck.getValueDealer() > 21) {
                        p("The dealer went over 21. You win");
                        String game = Input.getString("Play again?(yes/no)").toLowerCase();
                        if (game.equals("yes")){
                            game();
                        }
                        else{System.exit(0);}
                    } else if (deck.getValueDealer() > deck.getplayertotal()) {
                        p("The dealer has more points than you. It wins");
                        String game = Input.getString("Play again?(yes/no)").toLowerCase();
                        if (game.equals("yes")){
                            game();
                        }
                        else{System.exit(0);}
                    } else if (deck.getValueDealer() == 21) {
                        p("The dealer got 21, you lose.");
                        String game = Input.getString("Play again?(yes/no)").toLowerCase();
                        if (game.equals("yes")){
                            game();
                        }
                        else{System.exit(0);}
                    } else if (deck.getValueDealer() == deck.getplayertotal()) {
                        p("The dealer got the same number of points as you, you lose.");
                        String game = Input.getString("Play again?(yes/no)").toLowerCase();
                        if (game.equals("yes")){
                            game();
                        }
                        else{System.exit(0);}
                    } else {
                        p("You win! You got more points.");
                        String game = Input.getString("Play again?(yes/no)").toLowerCase();
                        if (game.equals("yes")){
                            game();
                        }
                        else{System.exit(0);}
                    }
                }
            }

        }
}
