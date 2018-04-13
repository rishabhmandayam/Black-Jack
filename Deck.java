import java.util.concurrent.ThreadLocalRandom;
public class Deck {
    //The deck!(organized by Suite)
    private String[] hearts = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private String[] diamonds = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private String[] spades = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private String[] clubs = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private int valueplayer = 0;
    private int valuedealer = 0;
    Hand hand = new Hand();
    CardtoValue value= new CardtoValue();
    //Constructor
    public Deck(){
        String[] hearts = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] diamonds = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] spades = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] clubs = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        valueplayer = 0;
        valuedealer = 0;
    }
    //Of course there are more than 12 cards in a deck, but this 12+1 = 13 refers to a suite
    private int cardsleft = 12;
    private int totalcardsleft = 52;
    private String card;
    //There will be a tester to use drawplayer or drawdealer in the main method(Primarily one after the other)
    public void drawplayer(){
        int randomNum = ThreadLocalRandom.current().nextInt(1,  4+ 1);
        if(randomNum==1){
            randomNum = ThreadLocalRandom.current().nextInt(0,cardsleft+1);
            if(hearts[randomNum].equals("Blank")){ //Apperntly it is sups important to use .EQUALS() for strings
                drawplayer();
            }
            else{
                valueplayer += value.convert(hearts[randomNum]);
                card = hearts[randomNum]+"-H";
                hearts[randomNum] = "Blank";
                cardsleft = cardsleft - 1;
                totalcardsleft--;
            }
        }
        else if(randomNum==2){
            if(diamonds[randomNum].equals("Blank")){
                drawplayer();
            }
            else{
                randomNum = ThreadLocalRandom.current().nextInt(0,cardsleft+1);
                valueplayer += value.convert(diamonds[randomNum]);
                card = hearts[randomNum]+"-D";
                diamonds[randomNum] = "Blank";
                cardsleft = cardsleft - 1;
                totalcardsleft--;
            }

        }
        else if(randomNum==3){
            if(spades[randomNum].equals("Blank")){
                drawplayer();
            }
            else{
                randomNum = ThreadLocalRandom.current().nextInt(0,cardsleft+1);
                valueplayer += value.convert(spades[randomNum]);
                card = hearts[randomNum]+"-S";
                spades[randomNum] = "Blank";
                cardsleft = cardsleft - 1;
                totalcardsleft--;
            }

        }
        else{
            if(spades[randomNum].equals("Blank")){
                drawplayer();
            }
            else {
                randomNum = ThreadLocalRandom.current().nextInt(0,cardsleft+1);
                card = hearts[randomNum]+"-C";
                valueplayer += value.convert(clubs[randomNum]);
                clubs[randomNum] = "Blank";
                cardsleft = cardsleft - 1;
                totalcardsleft--;
            }

        }
    }
    public void drawdealer(){
        int randomNum = ThreadLocalRandom.current().nextInt(1,  4+ 1);
        if(randomNum==1){
            randomNum = ThreadLocalRandom.current().nextInt(0,cardsleft+1);
            if(hearts[randomNum].equals("Blank")){
                drawdealer();
            }
            else{
                if(valuedealer == 10 && hearts[randomNum].equals("A")){
                    valuedealer += value.acedealer();
                    card = hearts[randomNum]+"-H";
                    hearts[randomNum] = "Blank";
                    cardsleft = cardsleft - 1;
                    totalcardsleft--;
                }
                else {
                valuedealer += value.dconvert(hearts[randomNum]);
                card = hearts[randomNum]+"-H";
                hearts[randomNum] = "Blank";
                cardsleft = cardsleft - 1;
                }
            }
        }
        else if(randomNum==2){
            if(diamonds[randomNum].equals("Blank")){
                drawdealer();
            }
            else{
                if(valuedealer == 10 && diamonds[randomNum].equals("A")){
                    valuedealer += value.acedealer();
                    card = diamonds[randomNum]+"-D";
                    diamonds[randomNum] = "Blank";
                    cardsleft = cardsleft - 1;
                    totalcardsleft--;
                }
                else {
                    randomNum = ThreadLocalRandom.current().nextInt(0, cardsleft + 1);
                    valuedealer += value.dconvert(diamonds[randomNum]);
                    card = hearts[randomNum] + "-D";
                    diamonds[randomNum] = "Blank";
                    cardsleft = cardsleft - 1;
                    totalcardsleft--;
                }
            }

        }
        else if(randomNum==3){
            if(spades[randomNum].equals("Blank")){
                drawdealer();
            }
            else{
                if(valuedealer == 10 && spades[randomNum].equals("A")){
                    valuedealer += value.acedealer();
                    card = spades[randomNum]+"-S";
                    spades[randomNum] = "Blank";
                    cardsleft = cardsleft - 1;
                    totalcardsleft--;
                }
                randomNum = ThreadLocalRandom.current().nextInt(0,cardsleft+1);
                valuedealer += value.dconvert(spades[randomNum]);
                card = hearts[randomNum]+"-S";
                spades[randomNum] = "Blank";
                cardsleft = cardsleft - 1;
                totalcardsleft--;
            }

        }
        else{
            if(clubs[randomNum].equals("Blank")){
                drawdealer();
            }
            else {
                if(valuedealer == 10 && clubs[randomNum].equals("A")){
                    valuedealer += value.acedealer();
                    card = clubs[randomNum]+"-C";
                    clubs[randomNum] = "Blank";
                    cardsleft = cardsleft - 1;
                    totalcardsleft--;
                }
                else {
                    randomNum = ThreadLocalRandom.current().nextInt(0,cardsleft+1);
                    card = hearts[randomNum]+"-C";
                    valuedealer += value.dconvert(clubs[randomNum]);
                    clubs[randomNum] = "Blank";
                    cardsleft = cardsleft - 1;
                    totalcardsleft--;
                }

            }

        }
    }
    public int getplayertotal(){
        return valueplayer;
    }
    public String getcard(){
        return card;
    }
    public int getValueDealer(){
        return valuedealer;
    }
}
