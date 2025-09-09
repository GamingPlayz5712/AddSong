import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@SpringBootApplication
public class App {
    private AtomicInteger songId = new AtomicInteger(1000);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @PostMapping("/addSong")
    public String addSong(@RequestParam String name,
                          @RequestParam String author,
                          @RequestParam String link) {
        int id = songId.incrementAndGet();
        return "✅ Música adicionada!\n" +
               "Nome: " + name + "\n" +
               "Autor: " + author + "\n" +
               "Link: " + link + "\n" +
               "🎵 Song ID: " + id;
    }

    @GetMapping("/")
    public String home() {
        return "Bem-vindo ao BitDash GDPS Tools em Java! Use /addSong para adicionar.";
    }
}
