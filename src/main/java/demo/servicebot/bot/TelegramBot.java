package demo.servicebot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    @Override
    public void onUpdateReceived(Update update) {
        //мы проверяем, что сообщение реально существует, потому извлекаем само сообщение (message) и айдишник чата (chatId), в котором идет переписка.

        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String messageBack = "";
            String chatId = update.getMessage().getChatId().toString();


            // Default - change later
            if (message.equals("Romantic")){
                messageBack = "500 Days of Summer";
            }
            else if (message.equals("Comedy")){
                messageBack = "Mask";
            }
            else if (message.equals("Fantasy")){
                messageBack = "Back in the Future";
            }
            else messageBack = "Didn't get the genre:(";


            SendMessage sm = new SendMessage();
            sm.setChatId(chatId);
            sm.setText(messageBack);

            try {
                execute(sm);
            } catch (TelegramApiException e) {
                //todo add logging to the project.
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
