package org.example.TaskT1.service;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrequencyServiceTest {

    private final FrequencyService frequencyService = new FrequencyService();

    @Test
    public void testComputeFrequency() {
        String input = "aaaaabcccc";
        Map<Character, Integer> result = frequencyService.computeFrequency(input);
        assertEquals(5, result.get('a'));
        assertEquals(1, result.get('b'));
        assertEquals(4, result.get('c'));
    }

    @Test
    public void testEmptyString() {
        String input = "";
        Map<Character, Integer> result = frequencyService.computeFrequency(input);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSingleCharacter() {
        String input = "a";
        Map<Character, Integer> result = frequencyService.computeFrequency(input);
        assertEquals(1, result.get('a'));
    }

    @Test
    public void testMixedCaseString() {
        String input = "aAaAaBcccc";
        Map<Character, Integer> result = frequencyService.computeFrequency(input);
        assertEquals(3, result.get('a'));
        assertEquals(2, result.get('A'));
        assertEquals(1, result.get('B'));
        assertEquals(4, result.get('c'));
    }
}
