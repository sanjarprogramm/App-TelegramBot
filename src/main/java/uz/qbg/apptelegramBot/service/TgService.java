package uz.qbg.apptelegramBot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class TgService {

    private final WebhookService webhookService;

    public void updateKutish(Update update) {


        if (update.hasMessage()) {
            String text = update.getMessage().getText();
            switch (text) {
                case "/start":
                    webhookService.whenStart(update);
                    break;
            }
        }
    }
}
