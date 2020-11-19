package posts;

import users.User;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * Post made by a user, has a title, text, url and the user that posted it.
 */

public class PostClass implements Post {
	
	/* Variables */
	private final User user;
	private final String title;
	private final String text;
	private final String url;
	
	/**
	 * Constructor.
	 * @param user User that made the post.
	 * @param title Posts' title.
	 * @param text Posts' message.
	 * @param url Posts' URL.
	 */
	public PostClass(User user, String title, String text, String url) {
		this.user = user;
		this.title = title;
		this.text = text;
		this.url = url;
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public String getText() {
		return text;
	}
	
	@Override
	public String getUrl() {
		return url;
	}
	
	@Override
	public User getUser() {
		return user;
	}
	
}
