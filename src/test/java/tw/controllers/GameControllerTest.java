package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;
import tw.views.GameView;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {

    @Mock
    private GameView gameView;

    @Mock
    private InputCommand command;

    @Mock
    private AnswerGenerator generator;

    @Mock
    private Game game;

    private Answer correctAnswer;
    private Answer errorAnswer;
    private GameController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        correctAnswer = Answer.createAnswer("1 2 3 4");
        errorAnswer = Answer.createAnswer("1 2 7 8");
        when(generator.generate()).thenReturn(correctAnswer);
        controller = new GameController(game, gameView);
    }

    @Test
    public void should_display_guess_result_when_call_controller_play() throws IOException {
        when(command.input()).thenReturn(correctAnswer);
        when(game.guessHistory()).thenReturn(new ArrayList<>());
        when(game.checkCoutinue()).thenReturn(true, false);
        when(game.checkStatus()).thenReturn("");
        when(game.guess(errorAnswer)).thenReturn(new GuessResult("", errorAnswer));
        GameController gameController = new GameController(game, gameView);

        gameController.play(command);

        verify(gameView).showGuessResult(any());
        verify(gameView).showGameStatus(anyString());
        verify(gameView).showGuessHistory(anyList());

    }
}