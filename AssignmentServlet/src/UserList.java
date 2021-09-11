
import java.util.ArrayList;
import java.util.List;

public class UserList {
	
	public boolean validateUser(String userId , String password)
	{
		List <UserObject> userList = new ArrayList<UserObject>();
		userList.add(new UserObject("userId", "Password"));
		userList.add(new UserObject("userId1", "Password1"));
		userList.add(new UserObject("userId2", "Password2"));
		userList.add(new UserObject("userId3", "Password3"));
		
		for (UserObject uo: userList)
		{
			if ((userId.contentEquals(uo.userName))&&(password.contentEquals(uo.password)))
			{
				return true;
			}
		}
		return false;
	}

}
