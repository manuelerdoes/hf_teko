import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {

        // create all the states
        // the number at the end of the name helps us identifing which layer of states we're talking about
        State start = new State("start");

        State blueWand1 = new State("blue");
        State redWand1 = new State("red");
        State greenWand1 = new State("green");

        State winner2 = new State("winner");
        State looser2 = new State("looser");
        looser2.setExitState(true);
        State kill2 = new State("kill");
        State stun2 = new State("stun");

        State beGood3 = new State("good");
        beGood3.setExitState(true);
        State goBad3 = new State("bad");
        goBad3.setExitState(true);
        State getKilled3 = new State("killed");
        getKilled3.setExitState(true);
        State beRespectet3 = new State("respected");
        beRespectet3.setExitState(true);

        // connect the states with each other
        start.addChild(blueWand1);
        start.addChild(redWand1);
        start.addChild(greenWand1);

        blueWand1.addChild(winner2);
        redWand1.addChild(looser2);
        greenWand1.addChild(kill2);
        greenWand1.addChild(stun2);

        winner2.addChild(beGood3);
        winner2.addChild(goBad3);
        kill2.addChild(getKilled3);
        stun2.addChild(beRespectet3);

        // write the story (fill states with content)
        start.setStateContent("You just found out that you have magical powers!\n" +
            "You don't know anything about it yet, but you are already asked to pick a wand.\n" +
            "Which one do you want: A (blue) one, a (red) one, or a (green) one?");

        blueWand1.setStateContent("You chose the blue wand! A good choice! You feel the power flowing through you.\n" +
            "Suddenly, a five headed creature with big sharp teeth on all of its heads attacks you.\n" +
            "You don't know what to do, but you feel something happening with your wand.");

        redWand1.setStateContent("You chose the red wand! It looks nice, but as you take it in your hands you scream in agony.\n" +
            "The wand is so hot, you can't hold it. You have to throw it away, but maybe you don't need a wand at all..\n" +
            "Suddenly, a five headed creature with big sharp teeth on all of its heads attacks you.");

        greenWand1.setStateContent("You chose the green wand! As you take it in your hands you suddenly seem to know eveything about magic.\n" +
            "It's like the wand transfered all the knowledge you need to you.\n" +
            "Suddenly, a five headed creature with big sharp teeth on all of its heads attacks you.\n" +
            "You know you have options now, because of your wand. But which option should you choose?\n" +
            "You can either (kill) the monster and be done with it, or (stun) it.");

        winner2.setStateContent("A jet of green light shoots out of the tip of your wand. It hits the creature which goes down, unconscious.\n" +
            "Nice! It seems like you have unlimited powers now. If a big scary monster can't touch you, who can?\n" +
            "You're mind starts rotating.. What should you do with your newly gained powers?\n" +
            "With great power comes great responsibility. Let's use it to do (good) things, for everybody.\n" +
            "Oooor.. you could just fuck it and go (bad).. It sure sounds like fun.");

        looser2.setStateContent("You have no chance to defend yourself and die a brutal death. Bad luck!");

        kill2.setStateContent("You choose to kill the monster. A jet of green light shoots out of your wand.\n" +
            "The creature falls to the ground and doesn't move. You go to the creature and check if it's dead.\n" +
            "The spell worked like you wanted. The creature is dead!");

        stun2.setStateContent("You choose to stun the monster. A jet of red light shoots out of your wand.\n" +
            "The creature falls to the ground. You go over there to be sure that you didn't kill it. It seems to be breathing!");

        beGood3.setStateContent("You chose to use your powers to do good. As you travel through the world and help people and animals, \n" +
            "people seem to notice. Everybody loves you and all the hot girl are after you. Well done!");

        goBad3.setStateContent("Finally nobody can stand up against you anymore. You go around and take everything you want.\n" +
            "If somebody sais anything against you, you kill him. What a nice life! After some time a ghostlike person shoots out of your wand.\n" +
            "She sais: I am the goddess of magic. You have misused your powers for long enough. You're not able to better yourself.\n" +
            "She takes away your wand. Without your wand your are a nobody. And you are all alone because nobody wants to be your friend anymore.");

        getKilled3.setStateContent("An old man emerges out of a bush nearby. \"Ah here is my dear pettypet. What.. what's up with him.\n" +
            "Why is he not moving. You killed him! He was my only friend.\" The man runs to you. You are overwhelmed.\n" +
            "The man gets to you and bites you in the neck. The situation is too much for you, you can't move. He bites again and again.\n" +
            "It's to late when you realise what happened. You fall to the floor and bleed out. Next time you should use your powers more carefully..");

        beRespectet3.setStateContent("An old man emerges out of a bush nearby. \"IM SO SORRY! My dear pettypet sometimes attacks people when he's afraid.\n" +
            "I hope he didn't hurt you!\" He grabs a piece of chocolate out of his pocket and hands it over to you. He thanks you for staying calm.\n" +
            "What a nice day! Today you gained new massive powers AND a piece of chocolate!");

        // game logic

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input;
        ArrayList<State> children = new ArrayList<State>();
        State nextState = start;

        System.out.println("To choose your next step, type youre choice (the word in the brackets) and press ENTER\n");

        while (true) {

            System.out.print("\n");
            System.out.println(nextState.getStateContent());
            if (nextState.getExitState()) {
                break;
            }
            if (nextState.getChildren().size() > 1) {
                children = nextState.getChildren();
                nextState = null;
                while (nextState == null) {
                    System.out.print("\n");
                    System.out.print("your choice: ");
                    input = scanner.nextLine();
                    for (int i = 0; i < children.size(); i++) {
                        if (input.equals(children.get(i).getTrigger())) {
                            nextState = children.get(i);
                        }
                    }
                    if (nextState == null) {
                        System.out.println("invalid input");
                    }
                }
            } else {
                nextState = nextState.getChildren().get(0);
            }
        }

        scanner.close();

        

    }
}