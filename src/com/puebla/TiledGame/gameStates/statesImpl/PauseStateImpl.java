package com.puebla.TiledGame.gameStates.statesImpl;

import com.puebla.TiledGame.gameStates.PauseState;
import com.puebla.TiledGame.gameStates.PlayState;
import com.puebla.TiledGame.main.Game;

/**
 * @author federico on 23/05/17.
 * @email fede.larregle@gmail.com
 */
public class PauseStateImpl extends PauseState {

    public PauseStateImpl(Game game, PlayState playState) {
        super(game, playState);
    }
}
