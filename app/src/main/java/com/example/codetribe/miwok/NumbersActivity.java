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

public class NumbersActivity extends AppCompatActivity {

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

        //create array for words
        final ArrayList<Word> words = new ArrayList<Word>();

        switch(categoryLanguage_){
            case "defaultmiwok":

                words.add(new Word("one", "lutti ", R.drawable.number_one, R.raw.number_one));
                words.add(new Word("two", "otiko", R.drawable.number_two, R.raw.number_two));
                words.add(new Word("three", "tolookosu ", R.drawable.number_three, R.raw.number_three));
                words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
                words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
                words.add(new Word("six", "temmokka ", R.drawable.number_six, R.raw.number_six));
                words.add(new Word("seven", "kenekaku ", R.drawable.number_seven, R.raw.number_seven));
                words.add(new Word("eight", "kawinta ", R.drawable.number_eight, R.raw.number_eight));
                words.add(new Word("nine", "wo’e ", R.drawable.number_nine, R.raw.number_nine));
                words.add(new Word("ten", "na’aacha ", R.drawable.number_ten, R.raw.number_ten));

                break;

            case "isizulu":

                 words.add(new Word("one", "kunye", R.drawable.number_one, R.raw.kunye));
                 words.add(new Word("two", "kubili", R.drawable.number_two, R.raw.kubili));
                 words.add(new Word("three", "kuthathu", R.drawable.number_three, R.raw.kuthathu));
                 words.add(new Word("four", "kune", R.drawable.number_four, R.raw.kune));
                 words.add(new Word("five", "kuhlanu", R.drawable.number_five, R.raw.kuhlanu));
                 words.add(new Word("six", "yisithupha", R.drawable.number_six, R.raw.yisithupha));
                 words.add(new Word("seven", "yisikhombisa", R.drawable.number_seven, R.raw.yisikhombisa));
                 words.add(new Word("eight", "yisishiyagalombili", R.drawable.number_eight, R.raw.yishiyagalombili));
                 words.add(new Word("nine", "yisishiyagalolunye", R.drawable.number_nine, R.raw.yishiyagalolunye));
                 words.add(new Word("ten", "yishumi", R.drawable.number_ten, R.raw.yishumi));

                break;

            case "sepedi":


                 words.add(new Word("one", "tee", R.drawable.number_one, R.raw.tee));
                 words.add(new Word("two", "pedi", R.drawable.number_two, R.raw.pedi));
                 words.add(new Word("three", "tharo", R.drawable.number_three, R.raw.tharo));
                 words.add(new Word("four", "nne", R.drawable.number_four, R.raw.nne));
                 words.add(new Word("five", "tlhano", R.drawable.number_five, R.raw.thlano));
                 words.add(new Word("six", "tshela", R.drawable.number_six, R.raw.tshela));
                 words.add(new Word("seven", "šupa", R.drawable.number_seven, R.raw.supa));
                 words.add(new Word("eight", "seswai", R.drawable.number_eight, R.raw.seswai));
                 words.add(new Word("nine", "senyane", R.drawable.number_nine, R.raw.senyane));
                 words.add(new Word("ten", "lesome", R.drawable.number_ten, R.raw.lesome));
                  break;

            case "venda":


                 words.add(new Word("one", "Thihi", R.drawable.number_one, R.raw.kunye));
                 words.add(new Word("two", "Mbili", R.drawable.number_two, R.raw.kubili));
                 words.add(new Word("three", "Raru", R.drawable.number_three, R.raw.kuthathu));
                 words.add(new Word("four", "Ina", R.drawable.number_four, R.raw.kune));
                 words.add(new Word("five", "Thanu", R.drawable.number_five, R.raw.kuhlanu));
                 words.add(new Word("six", "Rathi", R.drawable.number_six, R.raw.yisithupha));
                 words.add(new Word("seven", "Sumbe", R.drawable.number_seven, R.raw.yisikhombisa));
                 words.add(new Word("eight", "Malo", R.drawable.number_eight, R.raw.yishiyagalombili));
                 words.add(new Word("nine", "Thahe", R.drawable.number_nine, R.raw.yishiyagalolunye));
                 words.add(new Word("ten", "Fumi", R.drawable.number_ten, R.raw.yishumi));

                break;

            case "tsonga":

                words.add(new Word("one", "Nwe", R.drawable.number_one, R.raw.number_one));
                words.add(new Word("two", "Mbiri", R.drawable.number_two, R.raw.number_two));
                words.add(new Word("three", "Narhu", R.drawable.number_three, R.raw.number_three));
                words.add(new Word("four", "Mune", R.drawable.number_four, R.raw.number_four));
                words.add(new Word("five", "Ntlhanu", R.drawable.number_five, R.raw.number_five));
                words.add(new Word("six", "Tsevu", R.drawable.number_six, R.raw.number_six));
                words.add(new Word("seven", "Kombo", R.drawable.number_seven, R.raw.number_seven));
                words.add(new Word("eight", "Nhungu", R.drawable.number_eight, R.raw.number_eight));
                words.add(new Word("nine", "Nkaye", R.drawable.number_nine, R.raw.number_nine));
                words.add(new Word("ten", "Khume", R.drawable.number_ten, R.raw.number_ten));

                break;

            case "afrikaans":

                words.add(new Word("one", "Een", R.drawable.number_one, R.raw.number_one));
                words.add(new Word("two", "Twee", R.drawable.number_two, R.raw.number_two));
                words.add(new Word("three", "drie", R.drawable.number_three, R.raw.number_three));
                words.add(new Word("four", "vier", R.drawable.number_four, R.raw.number_four));
                words.add(new Word("five", "vyf", R.drawable.number_five, R.raw.number_five));
                words.add(new Word("six", "ses", R.drawable.number_six, R.raw.number_six));
                words.add(new Word("seven", "sewe", R.drawable.number_seven, R.raw.number_seven));
                words.add(new Word("eight", "agt", R.drawable.number_eight, R.raw.number_eight));
                words.add(new Word("nine", "nege", R.drawable.number_nine, R.raw.number_nine));
                words.add(new Word("ten", "Khume", R.drawable.number_ten, R.raw.number_ten));

                break;

            default:

                words.add(new Word("one", "lutti ", R.drawable.number_one, R.raw.number_one));
                words.add(new Word("two", "otiko", R.drawable.number_two, R.raw.number_two));
                words.add(new Word("three", "tolookosu ", R.drawable.number_three, R.raw.number_three));
                words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
                words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
                words.add(new Word("six", "temmokka ", R.drawable.number_six, R.raw.number_six));
                words.add(new Word("seven", "kenekaku ", R.drawable.number_seven, R.raw.number_seven));
                words.add(new Word("eight", "kawinta ", R.drawable.number_eight, R.raw.number_eight));
                words.add(new Word("nine", "wo’e ", R.drawable.number_nine, R.raw.number_nine));
                words.add(new Word("ten", "na’aacha ", R.drawable.number_ten, R.raw.number_ten));

                break;

        }

        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list_item);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceId());
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



