package com.pongo.agbaradio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

  String url = "http://www.music.helsinki.fi/tmt/opetus/uusmedia/esim/a2002011001-e02.wav"; // your URL here

  Button play, stop;
  MediaPlayer mediaPlayer;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    play = findViewById(R.id.playButton);
    stop  = findViewById(R.id.stopButton);
    Toast.makeText(this, "Application has started!", Toast.LENGTH_SHORT).show();
    play.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        stream();
        Toast.makeText(MainActivity.this, "Player Has Started...", Toast.LENGTH_LONG).show();
      }
    });
    stop.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mediaPlayer.stop();
        Toast.makeText(MainActivity.this, "Player Hast Stopped!", Toast.LENGTH_SHORT).show();
      }
    });

  }

  public void stream(){
    mediaPlayer = new MediaPlayer();
    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    try {
      mediaPlayer.setDataSource(url);
    } catch (IOException e) {
      e.printStackTrace();
    }
    mediaPlayer.prepareAsync();
    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
      @Override
      public void onPrepared(MediaPlayer mediaPlayer) {
        Toast.makeText(MainActivity.this, "Media About To Play...", Toast.LENGTH_SHORT).show();
        mediaPlayer.start();
      }
    });
  }


}
