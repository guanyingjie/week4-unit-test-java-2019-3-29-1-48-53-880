package tw.core;

import org.junit.Test;
import tw.validator.InputValidator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    InputValidator validator = new InputValidator();
    @Test
    public void should_return_true_when_number_list_is_correct(){
        String s = "1 5 6 7";
        assertEquals(true,validator.validate(s));
    }
    @Test
    public void should_return_false_when_number_repeat_and_list_length_less_or_more_than_4(){
        String s = "1 2 3";
        String s1 = "1 2 2 4";
        String s2 = "1 2 3 4 5";
        assertEquals(false,validator.validate(s));
        assertEquals(false,validator.validate(s1));
        assertEquals(false,validator.validate(s2));

    }

}
