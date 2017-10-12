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

public class FamilyActivity extends AppCompatActivity {

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

        switch (categoryLanguage_){

            case "defaultmiwok":

                words.add(new Word("father", "әpә ", R.drawable.family_father, R.raw.family_father));
                words.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
                words.add(new Word("son", "angsi ", R.drawable.family_son, R.raw.family_son));
                words.add(new Word("daughter", "tune ", R.drawable.family_daughter, R.raw.family_daughter));
                words.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
                words.add(new Word("younger brother", "chalitti ", R.drawable.family_younger_brother, R.raw.family_younger_brother));
                words.add(new Word("older sister", "teṭe ", R.drawable.family_older_sister, R.raw.family_older_sister));
                words.add(new Word("younger sister", "kolliti ", R.drawable.family_younger_sister, R.raw.family_younger_sister));
                words.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
                words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

                break;
            case "isizulu":

                words.add(new Word("father", "ubaba", R.drawable.family_father, R.raw.ubaba));
                words.add(new Word("mother", "umama", R.drawable.family_mother, R.raw.umama));
                words.add(new Word("son", "indodana", R.drawable.family_son, R.raw.indodana));
                words.add(new Word("daughter", "indodakazi", R.drawable.family_daughter, R.raw.indodakazi));
                words.add(new Word("older brother", "umfowethu omdala", R.drawable.family_older_brother, R.raw.umfowethu_omdala));
                words.add(new Word("younger brother", "umfowethu omncane", R.drawable.family_younger_brother, R.raw.umfowethu_omncane));
                words.add(new Word("older sister", "udadewabo omdala", R.drawable.family_older_sister, R.raw.udadewethu_omdala));
                words.add(new Word("younger sister", "udadewabo omncane", R.drawable.family_younger_sister, R.raw.udadewethu_omncane));
                words.add(new Word("grandmother", "ugogo", R.drawable.family_grandmother, R.raw.ugogo));
                words.add(new Word("grandfather", "umkhulu", R.drawable.family_grandfather, R.raw.umkhulu));

                break;

            case "sepedi":

                words.add(new Word("father", "tate", R.drawable.family_father, R.raw.tate));
                words.add(new Word("mother", "mma", R.drawable.family_mother, R.raw.mma));
                words.add(new Word("son", "morwa", R.drawable.family_son, R.raw.morwa));
                words.add(new Word("daughter", "morwedi", R.drawable.family_daughter, R.raw.morwedi));
                words.add(new Word("older brother", "buti o mogolo", R.drawable.family_older_brother, R.raw.buti_o_mogolo));
                words.add(new Word("younger brother", "buti o monnyane", R.drawable.family_younger_brother, R.raw.buti_o_monnyane));
                words.add(new Word("older sister", "sesi o mogolo", R.drawable.family_older_sister, R.raw.sesi_o_mogolo));
                words.add(new Word("younger sister", "sesi o monnyane ", R.drawable.family_younger_sister, R.raw.sesi_o_monnyane));
                words.add(new Word("grandmother", "makgolo", R.drawable.family_grandmother, R.raw.makgolo));
                words.add(new Word("grandfather", "rakgolo", R.drawable.family_grandfather, R.raw.rakgolo));

                break;
            case "venda":

                words.add(new Word("father", "Khotsi", R.drawable.family_father, R.raw.kunye));
                words.add(new Word("mother", "Mme", R.drawable.family_mother, R.raw.kunye));
                words.add(new Word("son", "Nnwana wa Mutuka", R.drawable.family_son, R.raw.kunye));
                words.add(new Word("daughter", "Nwana wa Musidzana", R.drawable.family_daughter, R.raw.kunye));
                words.add(new Word("older brother", "Khotse Muhulu", R.drawable.family_older_brother, R.raw.kunye));
                words.add(new Word("younger brother", "Khotse Munene", R.drawable.family_younger_brother, R.raw.kunye));
                words.add(new Word("older sister", "Mme Muhulu", R.drawable.family_older_sister, R.raw.kunye));
                words.add(new Word("younger sister", "Mmane ", R.drawable.family_younger_sister, R.raw.kunye));
                words.add(new Word("grandmother", "Makhulu wa Mukegulu", R.drawable.family_grandmother, R.raw.kunye));
                words.add(new Word("grandfather", "Makhulu wa Mukalaha", R.drawable.family_grandfather, R.raw.kunye));

                break;

            case "tsonga":

                words.add(new Word("father", "Tatana", R.drawable.family_father, R.raw.kunye));
                words.add(new Word("mother", "Manana", R.drawable.family_mother, R.raw.kunye));
                words.add(new Word("son", "Jaha", R.drawable.family_son, R.raw.kunye));
                words.add(new Word("daughter", "N'whana", R.drawable.family_daughter, R.raw.kunye));
                words.add(new Word("older brother", "Buti", R.drawable.family_older_brother, R.raw.kunye));
                words.add(new Word("younger brother", "Ndzisana ya Jaha", R.drawable.family_younger_brother, R.raw.kunye));
                words.add(new Word("older sister", "Ndzisana ya N'whana", R.drawable.family_older_sister, R.raw.kunye));
                words.add(new Word("younger sister", "Sesi", R.drawable.family_younger_sister, R.raw.kunye));
                words.add(new Word("grandmother", "Kokwana wa Xisati", R.drawable.family_grandmother, R.raw.kunye));
                words.add(new Word("grandfather", "Kokwana wa Xinuna", R.drawable.family_grandfather, R.raw.kunye));

                break;

            case "afrikaans":

                words.add(new Word("father", "Tatana", R.drawable.family_father, R.raw.kunye));
                words.add(new Word("mother", "Manana", R.drawable.family_mother, R.raw.kunye));
                words.add(new Word("son", "Jaha", R.drawable.family_son, R.raw.kunye));
                words.add(new Word("daughter", "N'whana", R.drawable.family_daughter, R.raw.kunye));
                words.add(new Word("older brother", "Buti", R.drawable.family_older_brother, R.raw.kunye));
                words.add(new Word("younger brother", "Ndzisana ya Jaha", R.drawable.family_younger_brother, R.raw.kunye));
                words.add(new Word("older sister", "Ndzisana ya N'whana", R.drawable.family_older_sister, R.raw.kunye));
                words.add(new Word("younger sister", "Sesi", R.drawable.family_younger_sister, R.raw.kunye));
                words.add(new Word("grandmother", "Kokwana wa Xisati", R.drawable.family_grandmother, R.raw.kunye));
                words.add(new Word("grandfather", "Kokwana wa Xinuna", R.drawable.family_grandfather, R.raw.kunye));

                break;

            default:
                words.add(new Word("father", "pa ", R.drawable.family_father, R.raw.family_father));
                words.add(new Word("mother", "moeder", R.drawable.family_mother, R.raw.family_mother));
                words.add(new Word("son", "seun", R.drawable.family_son, R.raw.family_son));
                words.add(new Word("daughter", "dogter", R.drawable.family_daughter, R.raw.family_daughter));
                words.add(new Word("older brother", "ouer broer", R.drawable.family_older_brother, R.raw.family_older_brother));
                words.add(new Word("younger brother", "jonger broer ", R.drawable.family_younger_brother, R.raw.family_younger_brother));
                words.add(new Word("older sister", "ouer suster", R.drawable.family_older_sister, R.raw.family_older_sister));
                words.add(new Word("younger sister", "jonger suster ", R.drawable.family_younger_sister, R.raw.family_younger_sister));
                words.add(new Word("grandmother", "ouma", R.drawable.family_grandmother, R.raw.family_grandmother));
                words.add(new Word("grandfather", "oupa", R.drawable.family_grandfather, R.raw.family_grandfather));

                break;

        }

                WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list_item);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioResourceId());
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
