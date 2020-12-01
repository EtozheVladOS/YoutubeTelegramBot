import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Keyboards {
    public static void setStartKeyboard(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        List<KeyboardRow> keyboardRows = new ArrayList<KeyboardRow>();
        KeyboardRow firstRow = new KeyboardRow();
        firstRow.add(new KeyboardButton("Start"));
        firstRow.add(new KeyboardButton("Help"));

        KeyboardRow secondRow = new KeyboardRow();
        secondRow.add(new KeyboardButton("Download audio"));

        keyboardRows.add(firstRow);
        keyboardRows.add(secondRow);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
    }


    public static void setVariableKeyboard(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        List<KeyboardRow> keyboardRows = new ArrayList<KeyboardRow>();
        KeyboardRow firstRow = new KeyboardRow();
        firstRow.add(new KeyboardButton("All commands"));
        firstRow.add(new KeyboardButton("Back"));

        keyboardRows.add(firstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
    }
}
