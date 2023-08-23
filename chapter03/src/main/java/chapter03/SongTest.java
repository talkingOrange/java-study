package chapter03;

public class SongTest {
	public static void main(String[] args) {
		Song song1 = new Song();
		song1.setTitle("좋은날");
		song1.setArtist("아이유");
		song1.setAlbum("Real");
		song1.setComposer("이민수");
		song1.setTrack(3);
		song1.setYear(2010);
		
		Song song2 = new Song("좋은날", "아이유", "Real", "이민수", 3, 2010);
		
		Song song3 = new Song("Ditto", "New Jeans");
		
		song1.show();
		song2.show();
		song3.show();
		
	}
}
