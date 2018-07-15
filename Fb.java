import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

/**
 *
 * @author LISA OKTA
 */
public class Fb {

    /**
     * @param args the command line arguments
     * @throws facebook4j.FacebookException
     */
    public static void main(String[] args) throws FacebookException {

    // Generate facebook instance.
    Facebook facebook = new FacebookFactory().getInstance();
    // Use default values for oauth app id.
    facebook.setOAuthAppId("", "");
    // Get an access token from: 
    // https://developers.facebook.com/tools/explorer
    // Copy and paste it below.
    String accessTokenString = "EAAGjYueYdWgBAG9D8mS4yqY8EQqGYg3g8yfKCdX1A7lguhYqfimmaz2iDw8pCbKSaMt9yWVStKrLWp5p3TtOAqMOVT0iNAHqiebaa8qaiEe9L95EvzA4ZBqXgNrxTGlWeyvKPvDsqDj4sCTIcFIQzVDqgKZCQJGiyqMftq323P5TZBzOeGCZBjilJlOOhCZARNjdwirxj6QZDZD";
    AccessToken at = new AccessToken(accessTokenString);
    // Set access token.
    facebook.setOAuthAccessToken(at);

    // We're done.
    // Access group feeds.
    // You can get the group ID from:
    // https://developers.facebook.com/tools/explorer

    // Set limit to 25 feeds.
    ResponseList<Post> feeds = facebook.getFeed("187446750783",
            new Reading().limit(25));

        // For all 25 feeds...
        for (int i = 0; i < feeds.size(); i++) {
            // Get post.
            Post post = feeds.get(i);
            // Get (string) message.
            String message = post.getMessage();
                            // Print out the message.
            System.out.println(message);

            // Get more stuff...
            PagableList<Comment> comments = post.getComments();
            String date = post.getCreatedTime().toString();
            String name = post.getFrom().getName();
            String id = post.getId();
        }            
        // TODO code application logic here
    }
}
