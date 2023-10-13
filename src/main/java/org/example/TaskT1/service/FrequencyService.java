package org.example.TaskT1.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FrequencyService {

    public Map<Character, Integer> computeFrequency(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        return frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

}
