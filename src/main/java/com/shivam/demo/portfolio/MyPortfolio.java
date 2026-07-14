package com.shivam.demo.portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPortfolio {

    @GetMapping("/myself")
    public String Myself(){
        return """
        <h1>Shivam Kumar</h1>

        <p>
            Hello! I am a Computer Science student passionate about Java Backend Development
            and problem solving.
        </p>

        <h2>Education</h2>
        <ul>
            <li>B.Tech in Computer Science and Engineering</li>
            <li>Lovely Professional University</li>
        </ul>

        <h2>Skills</h2>
        <ul>
            <li>Java</li>
            <li>Spring Boot</li>
            <li>MySQL</li>
            <li>HTML</li>
            <li>Git & GitHub</li>
        </ul>

        <h2>Projects</h2>
        <ul>
            <li>Heart Disease Prediction System</li>
            <li>Student Management System</li>
            <li>Portfolio Website</li>
        </ul>

        <h2>Profiles</h2>
        <ul>
            <li>
                GitHub:
                <a href="https://github.com/Skstyle007">
                    https://github.com/Skstyle007
                </a>
            </li>

            <li>
                LeetCode:
                <a href="https://leetcode.com/u/Skstyle/">
                    https://leetcode.com/u/Skstyle/
                </a>
            </li>
        </ul>
        """;
    }
}
