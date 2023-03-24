package uz.qbg.apptelegramBot;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import uz.qbg.apptelegramBot.feign.TelegramFeign;
import uz.qbg.apptelegramBot.payload.ResultTelegram;
import uz.qbg.apptelegramBot.payload.SendPhotoOwn;

import java.util.*;

@Data
@RestController
@RequestMapping(value = "/api/admin")
@RequiredArgsConstructor
public class AdminController {

    // private final RestTemplate restTemplate;
    private final TelegramFeign telegramFeign;

    public Set<String> userChatIdList =
            new HashSet<>(Arrays.asList("936402109",
                    "5410033978",
                    "5812698271",
                    "1261275630"));


    @GetMapping("/xabarYuborish")
    public String sendHabar(@RequestParam String text) {
        for (String userChatId : userChatIdList) {
            SendMessage sendMessage = new SendMessage(userChatId, text);
            ResultTelegram resultTelegram = telegramFeign.sendMessageToUser("bot" + RestConstants.BOT_TOKEN, sendMessage);
            System.out.println(resultTelegram);
        }
        return "Sanjarbekdan salom";

    }

    @GetMapping("/rasmYuborish")
    public void rasmJunatish(@RequestParam String fileName,
                             @RequestParam String text) {
        String fileId = null;
        for (String userChatId : userChatIdList) {

            try {

                        fileName=fileId==null? RestConstants.MY_URL + "/api/attachment?name=" + fileName:fileId;


                SendPhotoOwn sendPhotoOwn = new SendPhotoOwn
                        (userChatId,
                                text,
                                fileName);
                System.out.println(sendPhotoOwn);
                ResultTelegram resultTelegram = telegramFeign.sendPhotoToUser("bot" + RestConstants.BOT_TOKEN, sendPhotoOwn);
                List<PhotoSize> photos = resultTelegram.getResult().getPhoto();
                PhotoSize photoSize = photos.get(photos.size() - 1);
                String fileId1 = photoSize.getFileId();
                System.out.println(resultTelegram);

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

}
