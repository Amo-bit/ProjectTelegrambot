package https.github.com.Amobit.ProjectTelegrambot.service;

import https.github.com.Amobit.ProjectTelegrambot.bot.SearchNewBookTelegrambot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Implementation of {@link SendBotMessageService} interface.
 */
@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final SearchNewBookTelegrambot searchNewBookTelegrambotBot;

    @Autowired
    public SendBotMessageServiceImpl(SearchNewBookTelegrambot searchNewBookTelegrambotBot) {
        this.searchNewBookTelegrambotBot = searchNewBookTelegrambotBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            searchNewBookTelegrambotBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            //todo add logging to the project.
            e.printStackTrace();
        }
    }
}
