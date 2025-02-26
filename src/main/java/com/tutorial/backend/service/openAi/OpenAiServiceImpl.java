package com.tutorial.backend.service.openAi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.backend.api.OpenAiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OpenAiServiceImpl implements OpenAiService {

    private final OpenAiClient openAiClient;
    private final String apiKey;
    private final ObjectMapper objectMapper;

    public OpenAiServiceImpl(OpenAiClient openAiClient, @Value("${openai.api.key}") String apiKey) {
        this.openAiClient = openAiClient;
        this.apiKey = apiKey;
        this.objectMapper = new ObjectMapper();
    }

    /**
     * 주어진 텍스트가 도박 관련 내용인지 AI를 활용해 판단
     */
    @Override
    public boolean isGamblingContent(String textContent) {
        Map<String, Object> request = new HashMap<>();
        request.put("model", "gpt-3.5-turbo");

        // 🔹 AI가 YES 또는 NO로 응답하도록 강제
        String fullPrompt = "아래의 텍스트가 포함된 웹사이트가 도박 사이트인지 판단해.\n" +
                "도박 관련 키워드(베팅, 카지노, 배당률, 슬롯머신, 포커 등)가 많으면 'YES',\n" +
                "그렇지 않으면 'NO'라고만 응답해.\n\n" +
                "분석할 텍스트:\n---\n" + textContent + "\n---\n\n" +
                "반드시 'YES' 또는 'NO'로만 답변해.";

        request.put("messages", List.of(
                Map.of("role", "user", "content", fullPrompt)
        ));

        request.put("max_tokens", 10);

        try {
            // OpenAI API 호출
            String jsonResponse = openAiClient.getCompletion("Bearer " + apiKey, request);

            // JSON 응답 파싱
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode contentNode = rootNode
                    .path("choices")
                    .get(0)
                    .path("message")
                    .path("content");

            String responseText = contentNode.asText("").trim().toUpperCase();

            // 🔹 'YES' → true, 'NO' → false 변환
            return "YES".equals(responseText);

        } catch (Exception e) {
            e.printStackTrace();
            return false; // 오류 발생 시 기본값 false 반환
        }
    }
}
