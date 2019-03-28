package com.shreekant.karn.mindthewall;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

public class SoundPlayer {
    private AudioAttributes audioAttributes;
    final int SOUND_POOL_MAX = 3;

    private static SoundPool soundPool;
    private static int hitOrangeSound;
    private static int hitPinkSound;
    private static int hitBlackSound;

    public SoundPlayer(Context context) {

        // SoundPool is deprecated in API level 21. (Lollipop)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .setMaxStreams(SOUND_POOL_MAX)
                    .build();

        } else {
            soundPool = new SoundPool(SOUND_POOL_MAX, AudioManager.STREAM_MUSIC, 0);
        }

        hitOrangeSound = soundPool.load(context, R.raw.orange, 1);
        hitPinkSound = soundPool.load(context, R.raw.pink, 1);
        hitBlackSound = soundPool.load(context, R.raw.black, 1);
    }

    public void playHitOrangeSound() {
        soundPool.play(hitOrangeSound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void playHitPinkSound() {
        soundPool.play(hitPinkSound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void playHitBlackSound() {
        soundPool.play(hitBlackSound, 1.0f, 1.0f, 1, 0, 1.0f);
    }
}
