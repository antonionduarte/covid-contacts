package posts;

import users.*;

public class PostClass implements Post {

	private String message;
	private User user;

	public PostClass(User user, String message) {
		this.message = message;
		this.user = user;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public User getUser() {
		return user;
	}

}
