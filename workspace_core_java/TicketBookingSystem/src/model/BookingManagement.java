package model;

public interface BookingManagement {
	public String bookTicket(int eventId, int userId, int days);
	public String cancelBooking(int bookingId);
	public boolean checkAvailability(int eventId);
	public String updateBooking(int bookingId, int days);
}
