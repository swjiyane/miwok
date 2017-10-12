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

public class PhrasesActivity extends AppCompatActivity {

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

        words.add(new Word("Where are you going?","minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә ", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...","oyaaset...", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good","kuchi achit ", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?","әәnәs'aa? ",R.raw.phrase_are_you_coming));
        words.add(new Word("Yes , I'm coming","hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm coming","әәnәm ", R.raw.phrase_im_coming));
        words.add(new Word("Let's go","yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("Come here","әnni'nem", R.raw.phrase_come_here));
                break;

            case "isizulu":

         words.add(new Word("Where are you going?","Uyakuphi?", R.raw.uyakuphi));
         words.add(new Word("What is your name?","Ngubani igama lakho?", R.raw.ngubani_igama_lakho));
         words.add(new Word("My name is...","Igama lami ngu...", R.raw.igama_lami_ngu));
         words.add(new Word("How are you feeling?","Uzizwa  kanjani?", R.raw.uzizwa_kanjani));
         words.add(new Word("I'm feeling good","Ngi zizwa kahle", R.raw.ngi_zizwa_kahle));
         words.add(new Word("Are you coming?","Uyeza na?",R.raw.uyeza_na));
         words.add(new Word("Yes , I'm coming","Yebo, Ngiyeza", R.raw.yebo_ngiyeza));
         words.add(new Word("I'm coming","Ngiyeza", R.raw.ngiyeza));
         words.add(new Word("Let's go","Masambe", R.raw.masambe));
         words.add(new Word("Come here","Woza la", R.raw.woza_la));
                break;

            case "sepedi":

         words.add(new Word("Where are you going?","O ya kae?", R.raw.o_ya_kae));
         words.add(new Word("What is your name?","Leina la gago ke mang?", R.raw.leina_la_gago_ke_mang));
         words.add(new Word("My name is...","Leina la ka ke...", R.raw.leina_laka_ke));
         words.add(new Word("How are you feeling?","Naa O ikutlwa bjang?", R.raw.o_ikwa_bjang));
         words.add(new Word("I'm feeling good","Ke ikutlwa gabotse.", R.raw.ke_ikwa_ga_botse));
         words.add(new Word("Are you coming?","Watla na?",R.raw.wa_tla_naa));
         words.add(new Word("Yes , I'm coming","Ee, ke a atla.", R.raw.ee_ke_a_tla));
         words.add(new Word("I'm coming","Ke a tla.", R.raw.ke_atla));
         words.add(new Word("Let's go","Tla re sepele", R.raw.tla_re_sepele));
         words.add(new Word("Come here","E tla mo.", R.raw.e_tla_mo));
                break;

            case "venda":

         words.add(new Word("Where are you going?","Nikho uya gai?", R.raw.kuhlanu));
         words.add(new Word("What is your name?","Dzina lanu ndi nnyi", R.raw.yisithupha));
         words.add(new Word("My name is...","Dzina langa ndi", R.raw.kunye));
         words.add(new Word("How are you feeling?","Nikho dipfa hani", R.raw.yishiyagalolunye));
         words.add(new Word("I'm feeling good","Ndikho dipfa zwavhudi.", R.raw.kuhlanu));
         words.add(new Word("Are you coming?","Nikho uda?",R.raw.kuhlanu));
         words.add(new Word("Yes , I'm coming","Yaa, ndikho uda", R.raw.kuhlanu));
         words.add(new Word("I'm coming","Ndikho uda", R.raw.kuhlanu));
         words.add(new Word("Let's go","Ari tuwe", R.raw.kuhlanu));
         words.add(new Word("Come here","Idani hafha", R.raw.kuhlanu));
                break;

            case "tsonga":

                words.add(new Word("Where are you going?","Uya kwini?", R.raw.kuhlanu));
                words.add(new Word("What is your name?","Hi wena mani vito?", R.raw.yisithupha));
                words.add(new Word("My name is...","Hi mina...", R.raw.kunye));
                words.add(new Word("How are you feeling?","Uti twa njhani?", R.raw.yishiyagalolunye));
                words.add(new Word("How are you feeling?","Uti twa njhani?", R.raw.yishiyagalolunye));
                words.add(new Word("I'm feeling good","Ni pfukile", R.raw.kuhlanu));
                words.add(new Word("Are you coming?","Uleku teni?",R.raw.kuhlanu));
                words.add(new Word("Yes , I'm coming","Ina ni leku teni", R.raw.kuhlanu));
                words.add(new Word("I'm coming","Ni lekuteni", R.raw.kuhlanu));
                words.add(new Word("Let's go","Ahi fambi", R.raw.kuhlanu));
                words.add(new Word("Come here","Tana haleni", R.raw.kuhlanu));

                break;

            case "afrikaans":

            words.add(new Word("Where are you going?","Waar gaan jy weg?", R.raw.kuhlanu));
            words.add(new Word("What is your name?","wat is jou naam?", R.raw.yisithupha));
            words.add(new Word("My name is...","my naam is...", R.raw.kunye));
            words.add(new Word("How are you feeling?","hoe voel jy?", R.raw.yishiyagalolunye));
            words.add(new Word("I'm feeling good","ek voel goed", R.raw.kuhlanu));
            words.add(new Word("Are you coming?","kom jy?",R.raw.kuhlanu));
            words.add(new Word("Yes , I'm coming","Ja, ek kom", R.raw.kuhlanu));
            words.add(new Word("I'm coming","ek kom", R.raw.kuhlanu));
            words.add(new Word("Let's go","kom ons gaan", R.raw.kuhlanu));
            words.add(new Word("Come here","kom ons gaan", R.raw.kuhlanu));

            break;

            default:

                words.add(new Word("Where are you going?","minto wuksus", R.raw.phrase_where_are_you_going));
                words.add(new Word("What is your name?", "tinnә oyaase'nә ", R.raw.phrase_what_is_your_name));
                words.add(new Word("My name is...","oyaaset...", R.raw.phrase_my_name_is));
                words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
                words.add(new Word("I'm feeling good","kuchi achit ", R.raw.phrase_im_feeling_good));
                words.add(new Word("Are you coming?","әәnәs'aa? ",R.raw.phrase_are_you_coming));
                words.add(new Word("Yes , I'm coming","hәә’ әәnәm", R.raw.phrase_yes_im_coming));
                words.add(new Word("I'm coming","әәnәm ", R.raw.phrase_im_coming));
                words.add(new Word("Let's go","yoowutis", R.raw.phrase_lets_go));
                words.add(new Word("Come here","әnni'nem", R.raw.phrase_come_here));
                break;
        }

        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list_item);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioResourceId());
                //start audio file
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }

        }
        );
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

