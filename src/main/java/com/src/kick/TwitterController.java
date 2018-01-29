/**
 *
 */
package com.src.kick;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.kick.service.TwitterService;

/**
 * @author Sezin Karli
 */
@RestController
public class TwitterController {
//
//    @Autowired
//    private TwitterService twitterService;
//
//    @RequestMapping("/timeline/{twitterUser}")
//    public List<Tweet> getUserTimeline(@PathVariable String twitterUser, Model model) {
//        return twitterService.getUserTimeline(twitterUser);
//    }
//
//    @RequestMapping("/profile/{twitterUser}")
//    public TwitterProfile getUserProfile(@PathVariable String twitterUser, Model model) {
//         TwitterProfile profile=twitterService.getUserProfile(twitterUser);
//
//        return profile;
//    }
}

