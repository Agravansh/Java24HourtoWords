import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class SpeakingClockTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenEnteredLettersInsteadOfIntegers_thenShouldReturnException() {
        exceptionRule.expect(NumberFormatException.class);
        exceptionRule.expectMessage("You need to pass a valid 24-hour format hour");
        SpeakingClock speakingClock = new SpeakingClock("12:aa");
        speakingClock.solve();
    }

    @Test
    public void whenEnteredSemicolonInsteadOfColon_thenShouldReturnException() {
        exceptionRule.expect(NumberFormatException.class);
        exceptionRule.expectMessage("You need to pass a valid 24-hour format hour");
        SpeakingClock speakingClock = new SpeakingClock("12;13");
        speakingClock.solve();
    }

    @Test
    public void whenEnteredMidday_thenShouldReturnItsMidday() {
        SpeakingClock speakingClock = new SpeakingClock("12:00");
        speakingClock.solve();
        assertEquals("It's Midday", speakingClock.getResult());
    }

    @Test
    public void whenEnteredMidnight_thenShouldReturnItsMidnight() {
        SpeakingClock speakingClock = new SpeakingClock("24:00");
        speakingClock.solve();
        assertEquals("It's Midnight", speakingClock.getResult());
    }

    @Test
    public void whenEnteredTwelveFifty_thenShouldReturnItsTwelveFifty() {
        SpeakingClock speakingClock = new SpeakingClock("12:50");
        speakingClock.solve();
        assertEquals("It's twelve fifty ", speakingClock.getResult());
    }

    @Test
    public void whenEnteredOne_thenShouldReturnItsOne() {
        SpeakingClock speakingClock = new SpeakingClock("13:00");
        speakingClock.solve();
        assertEquals("It's one ", speakingClock.getResult());
    }

    @Test
    public void whenEnteredTwoOhSix_thenShouldReturnItsTwoOhSix() {
        SpeakingClock speakingClock = new SpeakingClock("14:06");
        speakingClock.solve();
        assertEquals("It's two oh six ", speakingClock.getResult());
    }

    @Test
    public void whenEnteredFiveFifteen_thenShouldReturnItsFiveFifteen() {
        SpeakingClock speakingClock = new SpeakingClock("17:15");
        speakingClock.solve();
        assertEquals("It's five fifteen ", speakingClock.getResult());
    }
}
