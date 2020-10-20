package posts;

import users.User;

public interface Post {
	
	/**
	 * @return The posts' title.
	 */
	String getTitle();
	
	/**
	 * @return The posts' message.
	 */
	String getText();
	
	/**
	 * @return The posts' URL.
	 */
	String getUrl();
	
	/**
	 * @return The user that made the post.
	 */
	User getUser();
	
}
