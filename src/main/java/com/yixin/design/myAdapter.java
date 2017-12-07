package com.yixin.design;

/**
 * 作为一个新接口
 */
interface MediaPlayer {
    void play(String audioType, String fileName);
}

/**
 * 作为一个老得接口
 */
interface AdvancedMediaPlayer {
    void playVlc(String fileName);

    void playMp4(String fileName);
}

/**
 * Created by zw
 * Creates on 16/4/13.
 * 适配器模式
 * 分为类的适配,对象的适配,接口的适配
 * 主要解决：主要解决在软件系统中，常常要将一些"现存的对象"放到新的环境中，而新环境要求的接口是现对象不能满足的。
 */
public class myAdapter {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play( "mp3", "beyond the horizon.mp3" );
        audioPlayer.play( "mp4", "alone.mp4" );
        audioPlayer.play( "vlc", "far far away.vlc" );
        audioPlayer.play( "avi", "mind me.avi" );
    }
}

class VlcPlayer implements AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println( "Playing vlc file. Name: " + fileName );
    }

    public void playMp4(String fileName) { //什么也不做
    }
}

class Mp4Player implements AdvancedMediaPlayer {
    public void playVlc(String fileName) { //什么也不做
    }

    public void playMp4(String fileName) {
        System.out.println( "Playing mp4 file. Name: " + fileName );
    }
}

/**
 * 适配器类
 * 其中包含了老得接口,新接口整合了老接口的功能
 */
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase( "vlc" )) {
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase( "mp4" )) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase( "vlc" )) {
            advancedMusicPlayer.playVlc( fileName );
        } else if (audioType.equalsIgnoreCase( "mp4" )) {
            advancedMusicPlayer.playMp4( fileName );
        }
    }
}

/**
 * 该类用了新的接口,通过适配器类,它也过得了老接口的功能
 */
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    public void play(String audioType, String fileName) { //播放 mp3 音乐文件的内置支持
        if (audioType.equalsIgnoreCase( "mp3" )) {
            System.out.println( "Playing mp3 file. Name: " + fileName );
        } //mediaAdapter 提供了播放其他文件格式的支持
        else if (audioType.equalsIgnoreCase( "vlc" ) || audioType.equalsIgnoreCase( "mp4" )) {
            mediaAdapter = new MediaAdapter( audioType );
            mediaAdapter.play( audioType, fileName );
        } else {
            System.out.println( "Invalid media. " + audioType + " format not supported" );
        }
    }
}