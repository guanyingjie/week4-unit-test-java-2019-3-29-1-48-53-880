package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    private final Answer acturlanswer = Answer.createAnswer("1 2 3 4");
    private Game game;
    @Before
    public void setUp()throws Exception{
        AnswerGenerator generator = mock(AnswerGenerator.class);
        when(generator.generate()).thenReturn(acturlanswer);
        game = new Game(generator);
    }
    @Test
    public void should_get_record_of_guess_result(){
        game.guess(Answer.createAnswer("2 1 6 7"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        List<GuessResult>guessResults = game.guessHistory();
        assertThat(guessResults.size(),is(2));
        assertThat(guessResults.get(0).getResult(),is("0A2B"));

        assertThat(guessResults.get(1).getResult(),is("4A0B"));
        assertThat(guessResults.get(1).getInputAnswer().toString(), is("1 2 3 4"));
    }
    @Test
    public void should_get_the_success_status_when_guess_input_is_correct(){
        game.guess(Answer.createAnswer("6 9 5 8"));
        game.guess(Answer.createAnswer("1 2 3 4"));

        String status = game.checkStatus();
        assertThat(status,is("success"));
    }
    @Test
    public void should_get_the_fail_status_when_guess_action_count_over_or_equal(){
        game.guess(Answer.createAnswer("2 9 3 4"));
        game.guess(Answer.createAnswer("1 5 3 4"));
        game.guess(Answer.createAnswer("1 8 2 1"));
        game.guess(Answer.createAnswer("1 2 3 9"));
        game.guess(Answer.createAnswer("4 3 2 1"));
        game.guess(Answer.createAnswer("1 5 6 4"));
        String status = game.checkStatus();
        assertThat(status,is("fail"));
    }
    @Test
    public void should_get_continue_status_when_guess_action_count_less_than_6(){
        game.guess(Answer.createAnswer("2 9 3 4"));
        game.guess(Answer.createAnswer("1 5 3 4"));

        String status = game.checkStatus();
        assertThat(status,is("continue"));
    }
    @Test
    public void should_get_ture_when_incorrect_guess_action_number_less_than_6(){
        game.guess(Answer.createAnswer("2 1 9 3"));
        boolean isContinue = game.checkCoutinue();
        assertThat(isContinue,is(true));
    }
}
