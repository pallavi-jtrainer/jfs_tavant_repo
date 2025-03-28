package bahavioral_patterns;

public class Channels {
	private double frequency;
	private FM_Stations stationName;
	
	public Channels() {}
	
	public Channels(double frequency, FM_Stations stationName) {
		this.frequency = frequency;
		this.stationName = stationName;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public FM_Stations getStationName() {
		return stationName;
	}

	public void setStationName(FM_Stations stationName) {
		this.stationName = stationName;
	}

	@Override
	public String toString() {
		return "Channels [frequency=" + frequency + ", stationName=" + stationName + "]";
	}
}
