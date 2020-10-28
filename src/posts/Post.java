package posts;

import users.User;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * Post made by a user, has a title, text, url and the user that posted it.
 */

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
