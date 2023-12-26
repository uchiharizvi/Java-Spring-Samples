package com.kavish.tutorials;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.client.AiClient;
import org.springframework.ai.client.AiResponse;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prompt")
public class AIPromptController {
    private static final Logger log = LoggerFactory.getLogger(AIPromptController.class);
    private final AiClient aiClient;

    public AIPromptController(AiClient aiClient) {
        this.aiClient = aiClient;
    }
    @GetMapping("/hello")
    public String testAiPrompt(){
        String prompt = "Hello! What is Spring Boot?";
        return aiClient.generate(prompt);
    }
    @GetMapping("/learn/{topic}")
    public String getJoke(@PathVariable("topic") String topic){
        PromptTemplate promptTemplate = new PromptTemplate("""
                I just started learning Spring. Can you provide me\s
                        fundamentals of {topic} to get started?
                        Please provide me short and concise details in simple language.
                """);
        promptTemplate.add("topic",topic);
        return this.aiClient.generate(promptTemplate.create())
                .getGeneration()
                .getText();
    }
    @GetMapping("/getLanguage/{year}")
    public TopLanguage getTopLanguage(@PathVariable("year") int year){
        BeanOutputParser<TopLanguage> parser = new BeanOutputParser<>(TopLanguage.class);
        String prompt = """
                                   Which is the top programming Language in the year {year}?
                                   {format}
                         """;
        PromptTemplate template = new PromptTemplate(prompt);
        template.add("year",year);
        template.add("format", parser.getFormat());
        template.setOutputParser(parser);

        log.info("Format String: {}", parser.getFormat());

        Prompt prompt1 = template.create();
        AiResponse aiResponse = aiClient.generate(prompt1);
        String text = aiResponse.getGeneration().getText();
        return parser.parse(text);
    }
}
