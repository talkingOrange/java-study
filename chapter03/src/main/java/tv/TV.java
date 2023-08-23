package tv;

public class TV {
	private int channel; // 1~255
	private int volume; // 0~100
	private boolean power;

	public TV() {
	}

	public TV(int channel, int volume, boolean power) {
		super();
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void power(boolean on) {
		power = on;
	}

	// 화살표로 채널 바꾸는 것
	public void channel(boolean up) {
		if (up) {
			channel(channel == 255 ? 1 : channel + 1);
		} else {
			channel(channel == 1 ? 255 : channel - 1);
		}
	}

	public void channel(int channel) {
		if (channel < 1) {
			this.channel = 255;
		} else if (channel > 255) {
			this.channel = 1;
		} else {
			this.channel = channel;
		}
	}

	public void volume(boolean up) {
		if (up) {
			volume(volume == 100 ? 0 : volume + 1);
		} else {
			volume(volume == 0 ? 100 : volume - 1);
		}
	}

	public void volume(int volume) {
		if (volume < 0) {
			this.volume = 100;
		} else if (volume > 100) {
			this.volume = 0;
		} else {
			this.volume = volume;
		}
	}

	public void status() {
		System.out.println("TV[power=" + (power ? "on" : "off") + ", channel=" + channel + ", volume=" + volume + "]");
	}

}
