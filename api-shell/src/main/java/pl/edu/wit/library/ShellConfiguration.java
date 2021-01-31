package pl.edu.wit.library;

import org.jline.utils.AttributedString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.jline.PromptProvider;

@Configuration
public class ShellConfiguration {

    @Bean
    public PromptProvider libraryPrompt() {
        return () -> new AttributedString("library:>");
    }
}
