package com.example.yoruba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class FamilyActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    MediaPlayer.OnCompletionListener mCompleteMedia = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener changeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.
            AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mMediaPlayer.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> families = new ArrayList<Word>();

        families.add(new Word("Mother", "Iya", R.drawable.family_mother,
                R.raw.mother));
        families.add(new Word("Father", "Baba", R.drawable.family_father,
                R.raw.father));
        families.add(new Word("Older Brother", "Egbon okunrin",
                R.drawable.family_older_brother, R.raw.olderbrother));
        families.add(new Word("Older Sister", "Egbon obinrin",
                R.drawable.family_older_sister, R.raw.oldersister));
        families.add(new Word("Daughter", "Omọbinrin",
                R.drawable.family_daughter, R.raw.daughter));
        families.add(new Word("Son", "Omọkunrin", R.drawable.family_son,
                R.raw.son));
        families.add(new Word("Grandfather", "Baba agba",
                R.drawable.family_grandfather, R.raw.granddad));
        families.add(new Word("Grandmother", "Iya agba",
                R.drawable.family_grandmother, R.raw.grand));
        families.add(new Word("Younger Brother", "Aburo okunrin",
                R.drawable.family_younger_brother, R.raw.youngerbrother));
        families.add(new Word("Younger Sister", "Aburo obinrin",
                R.drawable.family_younger_sister, R.raw.youngersister));


        WordAdapter familyAdapter = new WordAdapter(this, 0, families, R.color.family_color);
        ListView listView = (ListView) findViewById(R.id.family);
        listView.setAdapter(familyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = families.get(position);
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(changeListener, AudioManager.
                        STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mMediaPlayer = MediaPlayer.create(getApplicationContext(), word.getAudioResourceId());
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompleteMedia);
                }

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(changeListener);
        }
    }
}