package tw.core;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.model.Record;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private Answer actualAnswer;

    private void validateGuessNumber(String inputAnswerStr, String exceptedValue) {
        Answer inputAnswer = Answer.createAnswer(inputAnswerStr);
        Record result = actualAnswer.check(inputAnswer);
        assertThat(result.getValue(), is(exceptedValue));
    }
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        actualAnswer = Answer.createAnswer("1 2 3 4");
    }

    @Test
    public void test_create_answer() {
        Answer answer = Answer.createAnswer("1 2 3 4");
        assertEquals(answer.getIndexOfNum("4"), 3);
    }
    @Test
    public void return_1A0B(){
        String input = "1 5 6 7";
        String expected = "1A0B";
        validateGuessNumber(input,expected);
    }
    @Test
    public void return_0A2B(){
        String input = "2 4 7 8";
        String expected = "0A2B";
        validateGuessNumber(input,expected);
    }
    @Test
    public void return_1A2B(){
        String input = "0 3 2 4";
        String expected = "1A2B";
        validateGuessNumber(input,expected);
    }
    @Test
    public void return_0A0B(){
        String input = "5 6 7 8";
        String expected = "0A0B";
        validateGuessNumber(input,expected);
    }
    @Test
    public void return_0A4B(){
        String input = "4 3 2 1";
        String expected = "0A4B";
        validateGuessNumber(input,expected);
    }
}