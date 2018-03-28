import java.util.concurrent.ThreadLocalRandom;
public class Deck {
    //The deck!(organized by Suite)
    private String[] hearts = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private String[] diamonds = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private String[] spades = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private String[] clubs = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private int valueplayer = 0;
    private int valuedealer = 0;
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
    private String card;
    //There will be a tester to use drawplayer or drawdealer in the main method(Primarily one after the other)
    public void drawplayer(){
        int randomNum = ThreadLocalRandom.current().nextInt(1,  4+ 1);
        if(randomNum==1){
            randomNum = ThreadLocalRandom.current().nextInt(0,cardsleft+1);
            if(hearts[randomNum]!="Blank"){
                valueplayer += value.convert(hearts[randomNum]);
                card = hearts[randomNum]+"-H";
                hearts[randomNum] = "Blank";
                cardsleft = cardsleft - 1;
            }
            else{
                drawplayer();
            }
        }
        else if(randomNum==2){
            if(diamonds[randomNum]!="Blank"){
                randomNum = ThreadLocalRandom.current().nextInt(0,cardsleft+1);
                valueplayer += value.convert(diamonds[randomNum]);
                card = hearts[randomNum]+"-D";
                diamonds[randomNum] = "Blank";
                cardsleft = cardsleft - 1;
            }
            else{
                drawplayer();
            }

        }
        else if(randomNum==3){
            if(spades[randomNum]!="Blank"){
                randomNum = ThreadLocalRandom.current().nextInt(0,cardsleft+1);
                valueplayer += value.convert(spades[randomNum]);
                card = hearts[randomNum]+"-S";
                spades[randomNum] = "Blank";
                cardsleft = cardsleft - 1;
            }
            else{
                drawplayer();
            }

        }
        else{
            if(spades[randomNum]!="Blank"){
                randomNum = ThreadLocalRandom.current().nextInt(0,cardsleft+1);
                card = hearts[randomNum]+"-C";
                valueplayer += value.convert(clubs[randomNum]);
                clubs[randomNum] = "Blank";
                cardsleft = cardsleft - 1;
            }
            else {
                drawplayer();
            }

        }
    }
    public void drawdealer(){
        int randomNum = ThreadLocalRandom.current().nextInt(1,  4+ 1);
        if(randomNum==1){
            randomNum = ThreadLocalRandom.current().nextInt(0,cardsleft+1);
            if(hearts[randomNum]!="Blank"){
                valuedealer += value.dconvert(hearts[randomNum]);
                card = hearts[randomNum]+"-H";
                hearts[randomNum] = "Blank";
                cardsleft = cardsleft - 1;
            }
            else{
                drawdealer();
            }
        }
        else if(randomNum==2){
            if(diamonds[randomNum]!="Blank"){
                randomNum = ThreadLocalRandom.current().nextInt(0,cardsleft+1);
                valuedealer += value.dconvert(diamonds[randomNum]);
                card = hearts[randomNum]+"-D";
                diamonds[randomNum] = "Blank";
                cardsleft = cardsleft - 1;
            }
            else{
                drawdealer();
            }

        }
        else if(randomNum==3){
            if(spades[randomNum]!="Blank"){
                randomNum = ThreadLocalRandom.current().nextInt(0,cardsleft+1);
                valuedealer += value.dconvert(spades[randomNum]);
                card = hearts[randomNum]+"-S";
                spades[randomNum] = "Blank";
                cardsleft = cardsleft - 1;
            }
            else{
                drawplayer();
            }

        }
        else{
            if(spades[randomNum]!="Blank"){
                randomNum = ThreadLocalRandom.current().nextInt(0,cardsleft+1);
                card = hearts[randomNum]+"-C";
                valuedealer += value.dconvert(clubs[randomNum]);
                clubs[randomNum] = "Blank";
                cardsleft = cardsleft - 1;
            }
            else {
                drawplayer();
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
