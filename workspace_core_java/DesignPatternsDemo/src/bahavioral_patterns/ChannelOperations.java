package bahavioral_patterns;

public interface ChannelOperations {
	public void addChannel(Channels c);
	public void removeChannel(Channels c);
	
	public ChannelIterator iterateChannels(FM_Stations station);
}
