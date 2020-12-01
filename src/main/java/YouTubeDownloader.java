import com.sapher.youtubedl.YoutubeDL;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.YoutubeDLRequest;
import com.sapher.youtubedl.YoutubeDLResponse;

import java.io.File;

public class YouTubeDownloader {

    public static Object functionToTest(String url) throws YoutubeDLException {
        String videoUrl = url;
        String directory = System.getProperty("user.dir");

        YoutubeDLRequest request = new YoutubeDLRequest(videoUrl, directory);
        YoutubeDL.setExecutablePath("C:\\Users\\VladOS\\JavaResurses\\youtube-dl.exe");

        request.setOption("no-mark-watched");
        request.setOption("ignore-errors");
        request.setOption("no-playlist");
        request.setOption("extract-audio");
        request.setOption("audio-format \"mp3\"");

        YoutubeDLResponse response = YoutubeDL.execute(request);

        String stdOut = response.getOut();

        return request;
    }
}
