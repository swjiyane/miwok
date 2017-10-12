package com.example.codetribe.miwok;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    String categoryLanguage_;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {

                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        //pause playback
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        //resume playback
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                        //stop playback
                    }

                }
            };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        Intent intent = getIntent();
        categoryLanguage_ = intent.getStringExtra("categoryLanguage_");

        final ArrayList<Word> words = new ArrayList<Word>();

        switch(categoryLanguage_) {
            case "defaultmiwok":

                words.add(new Word("red", "weṭeṭṭi ", R.drawable.color_red, R.raw.color_red));
                words.add(new Word("mustard yellow", "chokokki", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
                words.add(new Word("dusty yellow", "ṭakaakki ", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
                words.add(new Word("green", "ṭopoppi", R.drawable.color_green, R.raw.color_green));
                words.add(new Word("brown", "kululli ", R.drawable.color_brown, R.raw.color_brown));
                words.add(new Word("gray", "kelelli ", R.drawable.color_gray, R.raw.color_gray));
                words.add(new Word("black", "ṭopiisә ", R.drawable.color_black, R.raw.color_black));
                words.add(new Word("white", "chiwiiṭә", R.drawable.color_white, R.raw.color_white));

                break;

            case "isizulu":

                words.add(new Word("red", "mbomvu", R.drawable.color_red, R.raw.mbomvu));
                words.add(new Word("mustard yellow", "ophuzi", R.drawable.color_mustard_yellow, R.raw.ophuuzii));
                words.add(new Word("dusty yellow", "enothuli ophuzi", R.drawable.color_dusty_yellow, R.raw.enothuli_ophuzi));
                words.add(new Word("green", "luhlaza", R.drawable.color_green, R.raw.luhlaza));
                words.add(new Word("brown", "nsundu", R.drawable.color_brown, R.raw.nsundu));
                words.add(new Word("gray", "mpunga", R.drawable.color_gray, R.raw.mphunga));
                words.add(new Word("black", "mnyama", R.drawable.color_black, R.raw.mnyama));
                words.add(new Word("white", "mhlophe", R.drawable.color_white, R.raw.mhlophe));

                break;

            case "sepedi":

                words.add(new Word("red", "Lehubedu", R.drawable.color_red, R.raw.leina_laka_ke));
                words.add(new Word("mustard yellow", "serolwane", R.drawable.color_mustard_yellow, R.raw.serolwane));
                words.add(new Word("dusty yellow", "serolwane salerole", R.drawable.color_dusty_yellow, R.raw.lerole_serolwane));
                words.add(new Word("green", "tala", R.drawable.color_green, R.raw.tala));
                words.add(new Word("brown", "khulong", R.drawable.color_brown, R.raw.kunye));
                words.add(new Word("gray", "Sehla", R.drawable.color_gray, R.raw.sehla));
                words.add(new Word("black", "Ntsho", R.drawable.color_black, R.raw.ntsho));
                words.add(new Word("white", "Šweu", R.drawable.color_white, R.raw.sweu));

                break;

            case "venda":

                words.add(new Word("red", "Mutswuku", R.drawable.color_red, R.raw.kunye));
                words.add(new Word("mustard yellow", "Mutada", R.drawable.color_mustard_yellow, R.raw.kubili));
                words.add(new Word("dusty yellow", "Mutada", R.drawable.color_dusty_yellow, R.raw.kuthathu));
                words.add(new Word("green", "Mudala", R.drawable.color_green, R.raw.kune));
                words.add(new Word("brown", "Buraunu", R.drawable.color_brown, R.raw.kuhlanu));
                words.add(new Word("gray", "Girei", R.drawable.color_gray, R.raw.yisithupha));
                words.add(new Word("black", "Mutswu", R.drawable.color_black, R.raw.yishumi));
                words.add(new Word("white", "Kelelli", R.drawable.color_white, R.raw.yisithupha));

                break;

            case "tsonga":

                words.add(new Word("red", "Tshwuka", R.drawable.color_red, R.raw.kunye));
                words.add(new Word("mustard yellow", "Xitshopana", R.drawable.color_mustard_yellow, R.raw.kubili));
                words.add(new Word("dusty yellow", "Mutada", R.drawable.color_dusty_yellow, R.raw.kuthathu));
                words.add(new Word("green", "Rihlaza", R.drawable.color_green, R.raw.kune));
                words.add(new Word("brown", "Buraunu", R.drawable.color_brown, R.raw.kuhlanu));
                words.add(new Word("gray", "Girei", R.drawable.color_gray, R.raw.yisithupha));
                words.add(new Word("black", "Ntima", R.drawable.color_black, R.raw.yishumi));
                words.add(new Word("white", "Basa", R.drawable.color_white, R.raw.yisithupha));

                break;

            case "afrikaans":

                words.add(new Word("red", "Rooi", R.drawable.color_red, R.raw.kunye));
                words.add(new Word("mustard yellow", "Mosterd geel", R.drawable.color_mustard_yellow, R.raw.kubili));
                words.add(new Word("dusty yellow", "Stowwerige geel", R.drawable.color_dusty_yellow, R.raw.kuthathu));
                words.add(new Word("green", "groen", R.drawable.color_green, R.raw.kune));
                words.add(new Word("brown", "bruin", R.drawable.color_brown, R.raw.kuhlanu));
                words.add(new Word("gray", "grys", R.drawable.color_gray, R.raw.yisithupha));
                words.add(new Word("black", "swart", R.drawable.color_black, R.raw.yishumi));
                words.add(new Word("white", "wit", R.drawable.color_white, R.raw.yisithupha));

                break;

            default:
                words.add(new Word("red", "weṭeṭṭi ", R.drawable.color_red, R.raw.color_red));
                words.add(new Word("mustard yellow", "chokokki", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
                words.add(new Word("dusty yellow", "ṭakaakki ", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
                words.add(new Word("green", "ṭopoppi", R.drawable.color_green, R.raw.color_green));
                words.add(new Word("brown", "kululli ", R.drawable.color_brown, R.raw.color_brown));
                words.add(new Word("gray", "kelelli ", R.drawable.color_gray, R.raw.color_gray));
                words.add(new Word("black", "ṭopiisә ", R.drawable.color_black, R.raw.color_black));
                words.add(new Word("white", "chiwiiṭә", R.drawable.color_white, R.raw.color_white));

                break;
        }

        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list_item);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioResourceId());
                //start audio file
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }

        });

    }
    @Override
    protected void onStop () {
        super.onStop();
        releaseMediaPlayer();

    }
//clean up the media player

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}
