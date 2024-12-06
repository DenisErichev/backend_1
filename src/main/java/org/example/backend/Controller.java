package org.example.backend;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class Controller {

    @PostMapping("/data")
    public String receiveData(@RequestParam String text) {
        try (FileWriter writer = new FileWriter("data.txt", true)) {
            writer.write(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка чтения файла.";
        }
        return "Данные сохранены в файл.";
    }
}
