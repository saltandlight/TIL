package springtv;

import org.springframework.stereotype.Component;


public class MaranzSpeaker implements Speaker {
	@Override
	public void up() {
		System.out.println("Marganz Speaker Volume Up");
	}

	@Override
	public void down() {
		System.out.println("Marganz Speaker Volume Down");

	}

}
