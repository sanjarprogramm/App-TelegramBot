package uz.qbg.apptelegramBot.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import uz.qbg.apptelegramBot.RestConstants;
import uz.qbg.apptelegramBot.payload.ResultTelegram;
import uz.qbg.apptelegramBot.payload.SendPhotoOwn;

@FeignClient(url = RestConstants.TELEGRAM_BASE_URL_WITHOUT_BOT,
        name = "KelegramFeign")
public interface TelegramFeign {
    @PostMapping(value = "{path}/sendMessage")
    ResultTelegram sendMessageToUser(@PathVariable String path,
                                     @RequestBody SendMessage sendMessage);



@PostMapping(value = "{path}/sendPhoto")
    ResultTelegram sendPhotoToUser(@PathVariable String path,
                                     @RequestBody SendPhotoOwn sendPhotoOwn);


}
