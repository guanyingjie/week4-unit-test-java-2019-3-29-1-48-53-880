package tw.core.generator;

import org.junit.Assert;
import org.junit.Test;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    @Test
    public void generate_standard_answer_test() throws OutOfRangeAnswerException{
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        String result = "2 3 4 5";
        when(randomIntGenerator.generateNums(9,4)).thenReturn(result);
        Answer answer = answerGenerator.generate();
        Assert.assertEquals(answer.toString(),result);
    }
}

