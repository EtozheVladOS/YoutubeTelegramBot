import com.sapher.youtubedl.YoutubeDLException;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendAudio;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import com.vdurmont.emoji.EmojiParser;

public class SoundBot extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi tbAPI = new TelegramBotsApi();
        try {
            tbAPI.registerBot(new SoundBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();

        if (msg.getText() != null && msg.hasText()) {
            SendMessage sendMessage = new SendMessage();
            Long chatId = msg.getChatId();
            sendMessage.setChatId(chatId);
            Keyboards.setStartKeyboard(sendMessage);

            String goblinEmoji = EmojiParser.parseToUnicode(":japanese_goblin:");
            String oniEmoji = EmojiParser.parseToUnicode(":japanese_ogre:");
            String alienEmoji = EmojiParser.parseToUnicode(":space_invader:");

            switch (msg.getText()) {
                case ("Start"), ("/start"):
                    sendMessage.setText("Hello " + oniEmoji);
                    Keyboards.setVariableKeyboard(sendMessage);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                case ("Help"), ("/help"):
                    sendMessage.setText("You can contact me, if you have questions \n @etozhevlados");
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                case ("Download audio"), ("/downloadAudio"):
                    sendMessage.setText("Just paste Youtube link below and enjoy " + alienEmoji);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                case ("All commands"), ("/allCommands"):
                    sendMessage.setText("/start \n/help \n/downloadAudio \n/allCommands");
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                case ("Back"), ("/back"):
                    Keyboards.setStartKeyboard(sendMessage);
                    sendMessage.setText("Back to start");
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    try {
                        sendMessage.setText(goblinEmoji + " Downloading " + goblinEmoji);
                        execute(sendMessage);
                        YouTubeDownloader.functionToTest(msg.getText());
                    } catch (YoutubeDLException | TelegramApiException e) {
                        e.printStackTrace();
                        sendMessage.setText("Undefined command");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException telegramApiException) {
                            telegramApiException.printStackTrace();
                        }
                    }

                    try {
                        SendAudio sendSong = new SendAudio();
                        sendSong.setChatId(chatId)
                                .setNewAudio(FileWorker.fileFind());
                        sendAudio(sendSong);
                        FileWorker.fileDelete();
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }


    public String getBotUsername() {
        return "FiendSoundBot";
    }

    public String getBotToken() {
        return "";
    }
}
