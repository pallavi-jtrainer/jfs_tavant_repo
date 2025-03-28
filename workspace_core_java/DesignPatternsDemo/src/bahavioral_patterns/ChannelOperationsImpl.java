package bahavioral_patterns;

import java.util.ArrayList;
import java.util.List;

public class ChannelOperationsImpl implements ChannelOperations {

	private List<Channels> channelsList;
	
	public ChannelOperationsImpl() {
		channelsList = new ArrayList<Channels>();
	}
	
	@Override
	public void addChannel(Channels c) {
		this.channelsList.add(c);
		
	}

	@Override
	public void removeChannel(Channels c) {
		this.channelsList.remove(c);
		
	}

	@Override
	public ChannelIterator iterateChannels(FM_Stations station) {
		return new ChannelIteratorImpl(station, this.channelsList);
	}
	
	private class ChannelIteratorImpl implements ChannelIterator{

		private FM_Stations station;
		private List<Channels> channels;
		private int index;
		
		public ChannelIteratorImpl(FM_Stations station, List<Channels> channels) {
			this.station = station;
			this.channels = channels;
		}
		
		@Override
		public boolean hasNext() {
			while (index < channels.size()) {
				Channels c = channels.get(index);
				if(c.getStationName().equals(station) || station.equals(FM_Stations.ALL)) {
					return true;
				} else {
					index++;
				}
			}
			
			return false;
		}

		@Override
		public Channels next() {
			Channels c = channels.get(index);
			index++;
			return c;
		}
	}

}
