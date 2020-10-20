package posts;

import users.*;

public interface Post {

  /**
   * Returns the message associated with the Post.
   * @return The message associated with the Post.
   */
  String getMessage();

  /**
   * Returns the user that made the post.
   * @return The user that made the post.
   */
  User getUser();

}
