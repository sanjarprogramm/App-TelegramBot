package uz.qbg.apptelegramBot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.qbg.apptelegramBot.service.TgService;

@RestController
@RequestMapping(value = "/api/telegram")
@RequiredArgsConstructor
public class WebhookController {
  private final TgService tgService;
    String token = "5848876170:AAH96VKXw4_Nl67qNn1ZjqX2g6D7ZZncUrE";


   @PostMapping
    public void getupdate ( @RequestBody Update update){
        tgService .updateKutish(update);
    }
}
