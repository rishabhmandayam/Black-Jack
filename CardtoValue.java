public class CardtoValue {
    public int convert(String s){
        int a;
        if(s=="A"){
            int  Choice = Aceplay();
            if (Choice == 1){
                a=1;
            }
            else{
                a=11;
            }
        }
        else if(s=="1"){
            a=1;
        }
        else if(s=="2"){
            a=2;
        }
        else if(s=="3"){
            a=3;
        }
        else if(s=="4"){
            a=4;
        }
        else if(s=="5"){
            a=5;
        }
        else if(s=="6"){
            a=6;
        }
        else if(s=="7"){
            a=7;
        }
        else if(s=="8"){
            a=8;
        }
        else if(s=="9"){
            a=9;
        }
        else{
            a=10;
        }
        return a;
    }
    public int dconvert(String s){
        int a;
        if(s=="A"){
            a=1;
        }
        else if(s=="1"){
            a=1;
        }
        else if(s=="2"){
            a=2;
        }
        else if(s=="3"){
            a=3;
        }
        else if(s=="4"){
            a=4;
        }
        else if(s=="5"){
            a=5;
        }
        else if(s=="6"){
            a=6;
        }
        else if(s=="7"){
            a=7;
        }
        else if(s=="8"){
            a=8;
        }
        else if(s=="9"){
            a=9;
        }
        else{
            a=10;
        }
        return a;
    }
    private int Aceplay(){
        int choice = Input.getInt("You drew an ace. Is it worth one point or 11 points? ");
        return choice;
    }
}
