package manypatterns;

public class Ducksimulator {

    public static void main(String[] args) {
        Ducksimulator simulator = new Ducksimulator();
        simulator.simulateEcho();
        simulator.simulate();
        simulator.simulate2(new DuckFactory());
        simulator.simulate2(new CountingDuckFactory());
        simulator.simulate3(new CountingDuckFactory());
    }

    void simulateEcho(){
        Quackable mallardDuck = new QuackEcho(new QuackCounter(new MallardDuck()));
        Quackable mallardDuck2 = new MallardDuck();

        System.out.println("=with echo=");
        simulate(mallardDuck);
        System.out.println("=normal=");
        simulate(mallardDuck2);

    }

    void simulate() {
        Quackable mallardDuck = new MallardDuck();
        Quackable redheadDuck = new RedHeadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();
        Goose goose = new Goose();
        Pigeon pigeon = new Pigeon();

        System.out.println("\nDuck Simulator");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(new GooseAdapter(goose));
        simulate(new PigeonAdapter(pigeon));


//        System.out.println("The ducks quacked" + QuackCounter.getQuacks() + "times");
    }

    void simulate2(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Goose goose = new Goose();


        System.out.println("\nDuck Simulator");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(new GooseAdapter(goose));

        System.out.println("Num quacks = " + QuackCounter.getNumberOfQuacks() );
    }

    void simulate3(AbstractDuckFactory duckFactory) {
        System.out.println("\n====Flock====\n");
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable goose = new GooseAdapter(new Goose());

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(goose);

        Flock flockOfRubberDucks = new Flock();
        flockOfRubberDucks.add(rubberDuck);
        flockOfRubberDucks.add(duckFactory.createRubberDuck());
        flockOfRubberDucks.add(duckFactory.createRubberDuck());

        flockOfDucks.add(flockOfRubberDucks);


        simulate(flockOfRubberDucks);
        System.out.println("Num quacks = " + QuackCounter.getNumberOfQuacks() );


    }

        void simulate(Quackable duck) {
        duck.quack();
    }

}


