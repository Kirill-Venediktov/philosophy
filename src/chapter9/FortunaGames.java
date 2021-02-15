package chapter9;

import java.util.Random;

interface Game{
    Random random = new Random();
    void play();
}

interface GameFactory{
    Game getGame();
}

//class CoinGame implements Game{
//    @Override
//    public void play() {
//        int a = random.nextInt(2);
//        if (a == 1) {
//            System.out.println(a);
//            System.out.println("Орел");
//        }else{
//            System.out.println(a);
//            System.out.println("Решка");
//        }
//    }
//}

//class CubeGame implements Game {
//    @Override
//    public void play() {
//        int a = random.nextInt(6);
//        switch (a){
//            case 0:
//                System.out.println("1");
//                break;
//            case 1:
//                System.out.println("2");
//                break;
//            case 2:
//                System.out.println("3");
//                break;
//            case 3:
//                System.out.println("4");
//                break;
//            case 4:
//                System.out.println("5");
//                break;
//            case 5:
//                System.out.println("6");
//                break;
//        }
//    }
//}

class CoinGameFactory implements GameFactory{
    @Override
    public Game getGame() {
        return new Game(){
            @Override
            public void play() {
                int a = random.nextInt(2);
                if (a == 1) {
                    System.out.println(a);
                    System.out.println("Орел");
                }else{
                    System.out.println(a);
                    System.out.println("Решка");
                }
            }
        };
    }
}

class CubeGameFactory implements GameFactory{

    @Override
    public Game getGame() {
        return new Game(){
            @Override
            public void play() {
                int a = random.nextInt(6);
                switch (a){
                    case 0:
                        System.out.println("1");
                        break;
                    case 1:
                        System.out.println("2");
                        break;
                    case 2:
                        System.out.println("3");
                        break;
                    case 3:
                        System.out.println("4");
                        break;
                    case 4:
                        System.out.println("5");
                        break;
                    case 5:
                        System.out.println("6");
                        break;
                }
            }
        };
    }
}

public class FortunaGames {
    public static void playGame(GameFactory gameFactory){
        gameFactory.getGame().play();
    }

    public static void main(String[] args) {
        playGame(new CoinGameFactory());
        playGame(new CubeGameFactory());
    }
}
