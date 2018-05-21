import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

class Game extends StateBasedGame{

    static final String gamename = "Larry Coppermann";
    private static final int menu = 0;
    private static final int play = 1;
    static final int height = 568;
    static final int width = 800;

    //define o nome do jogo e adiciona os estados ao Game
    private Game(String gamename){
        super(gamename);
        this.addState(new Menu(menu));
        this.addState(new Play(play));
    }

    //Inicia os estados do jogo (menu e ingame) e define menu como inicial
    public void initStatesList(GameContainer gc) throws SlickException{
        this.getState(menu).init(gc, this);
        this.getState(play).init(gc, this);
        this.enterState(menu);
    }

    public static void main(String[] args){
        //inicialização da janela
        AppGameContainer appgc;
        try{
            appgc = new AppGameContainer(new Game(gamename));
            appgc.setDisplayMode(width, height, false);
            appgc.start();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
