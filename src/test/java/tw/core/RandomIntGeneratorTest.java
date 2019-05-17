package tw.core;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.generator.RandomIntGenerator;

import java.lang.annotation.Repeatable;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    private RandomIntGenerator generator;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception{
        this.generator = new RandomIntGenerator();
    }
    @Test
    public void should_return_number_when_digitmax_more_than_need(){
        Integer digitmax = 5;
        Integer need = 4;
        RandomIntGenerator generator = mock(RandomIntGenerator.class);
        when(generator.generateNums(digitmax,need)).thenReturn("1 2 3 4");
        String actual = generator.generateNums(digitmax,need);
        assertThat(actual,is("1 2 3 4"));
    }
}