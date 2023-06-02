package uz.qbg.apptelegramBot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.qbg.apptelegramBot.constants.RestConstants;
import uz.qbg.apptelegramBot.payload.ResultTelegram;


@Service
@RequiredArgsConstructor
public class WebhookService {


    private final RestTemplate restTemplate;

    public void whenStart(Update update) {

        SendMessage sendMessage = new SendMessage(update.getMessage().getChatId().toString(), "Uzunko'cha Potranaj botiga xush kelibsiz");
        ResultTelegram object = restTemplate.postForObject(RestConstants.TELEGRAM_BASE_URL + RestConstants.BOT_TOKEN + "/sendMessage", sendMessage, ResultTelegram.class);
        System.out.println(object);
    }
}
