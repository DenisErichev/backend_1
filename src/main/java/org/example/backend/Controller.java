package org.example.backend;

import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@RestController
public class Controller {

    @PostMapping("/submit1")
    public String handleSubmit1(@RequestBody String data) {
        try {
            Files.write(Paths.get("data.txt"), data.getBytes(), StandardOpenOption.APPEND);
            return "Получено и сохранено: " + data;
        } catch (IOException e) {
            return "Ошибка сохранения данных: " + e.getMessage();
        }
    }

    @GetMapping("/submit2")
    public String handleSubmit2() {
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get("data.txt")));
            return fileContent;
        } catch (IOException e) {
            return "Файл не найден";
        }
    }
}
