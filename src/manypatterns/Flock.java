package manypatterns;

import java.util.ArrayList;
import java.util.List;

public class Flock implements Quackable{

    private List<Quackable> quackers ;

    public Flock(){
        quackers = new ArrayList<>();
    }

    public void add(Quackable duck){
        quackers.add(duck);
    }

    @Override
    public void quack() {
        int i = 0 ;
        for (Quackable duck : quackers){
            if(i == 0){
                System.out.println("Leader");
                duck.quack();
                duck.quack();
                duck.quack();
                System.out.println("===========");
                ++i;
            }
            duck.quack();
        }
    }
}
