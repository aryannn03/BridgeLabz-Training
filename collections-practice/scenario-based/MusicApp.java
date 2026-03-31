import java.util.*;

class SongAlreadyExistsException extends Exception{
    public SongAlreadyExistsException(String msg){
        super(msg);
    }
}

class Song{
    private String title;

    public Song(String title){
        this.title=title;
    }

    public String getTitle(){
        return title;
    }

    public String toString(){
        return title;
    }
}

class PlaylistManager{
    private LinkedList<Song> playlist=new LinkedList<>();
    private Stack<Song> history=new Stack<>();
    private Set<String> songSet=new HashSet<>();

    public void addSong(Song song)throws SongAlreadyExistsException{
        if(songSet.contains(song.getTitle())){
            throw new SongAlreadyExistsException("Song already exists");
        }
        playlist.add(song);
        songSet.add(song.getTitle());
    }

    public void playSong(){
        if(!playlist.isEmpty()){
            Song s=playlist.removeFirst();
            history.push(s);
            System.out.println("Playing:"+s);
        }
    }

    public void showHistory(){
        System.out.println("Recently Played:"+history);
    }
}

public class MusicApp{
    public static void main(String[] args){
        try{
            PlaylistManager manager=new PlaylistManager();

            manager.addSong(new Song("Song1"));
            manager.addSong(new Song("Song2"));

            manager.playSong();
            manager.playSong();

            manager.showHistory();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}