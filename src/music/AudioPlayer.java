package music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioPlayer implements MediaPlayerInterface {
	public MediaPlayer mediaPlayer;
	public void play(String fileName){
		final java.net.URL resource = getClass().getResource(fileName);
        final Media media = new Media(resource.toString());
         mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
	}
}
