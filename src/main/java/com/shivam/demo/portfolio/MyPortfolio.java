package com.shivam.demo.portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPortfolio {

    @GetMapping("/")
    public String home(){
        return """
                <p>Welcome to home page.</p> <a href="/about">Home</a>
                """;
    }

    @GetMapping("/about")
    public String about() {
        return """
            <h1>About Me</h1>
            <p>I am a Computer Science student interested in Java Backend Development.</p>
            <a href="/education">education</a>
            <a href="/skills">skills</a>
            <a href="/project">project</a>
            <a href="/">Home</a>
            """;
    }

    @GetMapping("/education")
    public String education() {
        return """
            <h1>Education</h1>
            <ul>
                <li>B.Tech CSE</li>
                <li>Lovely Professional University</li>
            </ul>
            <a href="/">Home</a>
            """;
    }

    @GetMapping("/skills")
    public String skills() {
        return """
            <h1>Skills</h1>
            <ul>
                <li>Java</li>
                <li>Spring Boot</li>
                <li>MySQL</li>
                <li>Git & GitHub</li>
            </ul>
            <a href="/">Home</a>
            """;
    }

    @GetMapping("/project")
    public String myproject(){
        return """
                <li> heart disease prediction system</li>
                <li>Portfolio Website</li>
                """;
    }
}
