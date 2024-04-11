import java.util.HashMap;
import java.util.Map;

class Data {
      private String type;
      private Object content;

      public Data(String type, Object content) {
            this.type = type;
            this.content = content;
      }

      public String getType() {
            return type;
      }

      public void setType(String type) {
            this.type = type;
      }

      public Object getContent() {
            return content;
      }

      public void setContent(Object content) {
            this.content = content;
      }
}

abstract class DataProcessor {
      public abstract void createDataProcessor(Data data);
}

class TextDataProcessor extends DataProcessor {
      @Override
      public void createDataProcessor(Data data) {
            System.out.println("Processing text data: " + data.getContent());
      }
}

class AudioDataProcessor extends DataProcessor {
      @Override
      public void createDataProcessor(Data data) {
            System.out.println("Processing audio data: " + data.getContent());
      }
}

class VideoDataProcessor extends DataProcessor {
      @Override
      public void createDataProcessor(Data data) {
            System.out.println("Processing video data: " + data.getContent());
      }
}

class TextContent {
      private String text;

      public TextContent(String text) {
            this.text = text;
      }

      public String getText() {
            return text;
      }

      public void setText(String text) {
            this.text = text;
      }

}

class AudioContent {
      private byte[] audioData;

      public AudioContent(byte[] audioData) {
            this.audioData = audioData;
      }

      public byte[] getAudioData() {
            return audioData;
      }

      public void setAudioData(byte[] audioData) {
            this.audioData = audioData;
      }

}

class VideoContent {
      private byte[] videoData;

      public VideoContent(byte[] videoData) {
            this.videoData = videoData;
      }

      public byte[] getVideoData() {
            return videoData;
      }

      public void setVideoData(byte[] videoData) {
            this.videoData = videoData;
      }

}


class DataProcessorCreator {
      private DataProcessor processor;

      public void setProcessor(DataProcessor processor) {
            this.processor = processor;
      }

      public void processData(Data data) {
            processor.createDataProcessor(data);
      }
}

public class Ex2 {
      public static void main(String[] args) {
            DataProcessorCreator creator = new DataProcessorCreator();
            TextDataProcessor textProcessor = new TextDataProcessor();
            AudioDataProcessor audioProcessor = new AudioDataProcessor();

            Data textData = new Data("text", "Sample text data");
            Data textData1 = new Data("audio", "Sample example");
            creator.setProcessor(textProcessor);
            creator.processData(textData);

            creator.setProcessor(audioProcessor);
            creator.processData(textData1);

      }
}
