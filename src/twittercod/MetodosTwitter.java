
package twittercod;

import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;




public class MetodosTwitter {
 
    ConfigurationBuilder cb = new ConfigurationBuilder();
    Twitter twitter;   
    
    
    public MetodosTwitter() {
       /* cb.setDebugEnabled(true)
                .setOAuthConsumerKey("nMhoaCVcMj3wvhte8QnkxqxLM")
                .setOAuthConsumerSecret("JdTAcQt5IsH3QC5ukTXSFhewcUTYNOZtn7m0c89nPAgw6IofHJ")
                .setOAuthAccessToken("867802357-I3SKAeEOeyDT1E6DG4BjanhI07c2GXCIKtuYBwW1")
                .setOAuthAccessTokenSecret("8gKsSZF1QZ1T7de0EEqrr7yNO2hvM6NrMS1ld0BbrWu5p");
        twitter = new TwitterFactory(cb.build()).getInstance();  */
         twitter = new TwitterFactory("twitter4j.properties").getInstance();
         
    }
    
     public void TimeLine()throws TwitterException{        
        List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing home timeline.");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":"
                        + status.getText());
            }
}
    public void ShowString(String busqueda)throws TwitterException{
          
        Query query = new Query(busqueda);
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
       }  
    
    public void Twittear(String tweet) throws TwitterException {

        Status status = twitter.updateStatus(tweet);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");

    }
     
}
