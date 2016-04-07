
package twittercod;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;




public class MetodosTwitter {
 
    ConfigurationBuilder cb = new ConfigurationBuilder();
    Twitter twitter;   
    
    
    public MetodosTwitter() {

        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("nMhoaCVcMj3wvhte8QnkxqxLM")
                .setOAuthConsumerSecret("JdTAcQt5IsH3QC5ukTXSFhewcUTYNOZtn7m0c89nPAgw6IofHJ")
                .setOAuthAccessToken("867802357-I3SKAeEOeyDT1E6DG4BjanhI07c2GXCIKtuYBwW1")
                .setOAuthAccessTokenSecret("8gKsSZF1QZ1T7de0EEqrr7yNO2hvM6NrMS1ld0BbrWu5p");
        twitter = new TwitterFactory(cb.build()).getInstance();  
     
    }
}
