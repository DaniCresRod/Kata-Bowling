package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game myGame=new Game();

    @Test
    public void A_player_play_10_times_with_no_puntuation(){
        for(int i=1; i<=10; i++){
            myGame.Roll(0);
        }

        assertEquals(0, myGame.score());
    }

    @Test
    public void A_player_knock_down_not_all_pins(){
        myGame.Roll(5);
        myGame.Roll(4);

        assertEquals(9, this.myGame.score());
        assertEquals(1, this.myGame.frameNumber);
    }

    @Test
    public void A_player_makes_an_spare(){
        myGame.Roll(5);
        myGame.Roll(5);

        assertEquals(10, this.myGame.score());

        myGame.Roll(4);
        myGame.Roll(4);

        assertEquals(22, this.myGame.score());
        assertEquals(2, this.myGame.frameNumber);
    }

    @Test
    public void A_Player_makes_a_strike(){
        myGame.Roll(10);

        assertEquals(10, this.myGame.score());

        myGame.Roll(5);
        myGame.Roll(4);

        assertEquals(28, this.myGame.score());
        assertEquals(2, this.myGame.frameNumber);
    }

    @Test
    public void A_Player_makes_an_spare_and_then_a_strike(){
        myGame.Roll(5);
        myGame.Roll(5);

        assertEquals(10, this.myGame.score());

        myGame.Roll(10);

        assertEquals(30, this.myGame.score());

        myGame.Roll(5);
        myGame.Roll(4);

        assertEquals(48, this.myGame.score());
        assertEquals(3, this.myGame.frameNumber);
    }

    @Test
    public void A_Player_makes_an_spare_and_then_another_spare(){
        myGame.Roll(5);
        myGame.Roll(5);

        assertEquals(10, this.myGame.score());

        myGame.Roll(5);
        myGame.Roll(5);

        assertEquals(25, this.myGame.score());

        myGame.Roll(5);
        myGame.Roll(4);

        assertEquals(39, this.myGame.score());
        assertEquals(3, this.myGame.frameNumber);
    }

}