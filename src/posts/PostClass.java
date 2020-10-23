package posts;

import users.User;

public class PostClass implements Post {
	
	/* Variables */
	private User user;
	private String title, text, url;
	
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
