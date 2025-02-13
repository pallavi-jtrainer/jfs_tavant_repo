package factory;

import java.util.List;

import model.Users;
import persistence.DbQueries;

public class UsersFactory {
	public static String addUser(Users user) {
		int res = DbQueries.addUser(user);
		
		String str = "Unable to add new user";
		
		if (res > 0)
			str = "Added new user successfully";
		
		return str;
	}
	
	public static Users[] listAllUsers() {
		List<Users> users = DbQueries.listAllUsers();
		
		return users.toArray(new Users[users.size()]);
	}

	public static Users findUser(long id) {
		Users user = DbQueries.getUserById(id);
		return user;
	}
	
	public static String updateUser(long id, String lname) {
		String msg = "Unable to update user";
		
		int res = DbQueries.updateUser(id, lname);
		if(res > 0) {
			msg = "User updated successfully";
		}
		
		return msg;
	}
	
	public static String deleteUser(long id) {
		String msg = "Unable to delete user";
		
		int res = DbQueries.deleteUser(id);
		if(res > 0)
			msg = "User deleted";
		
		return msg;
	}
}



