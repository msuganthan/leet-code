package contest.biweekly.bw48;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Design Authentication Manager
 *
 * There is an authentication system that works with authentication tokens. For each session, the user will receive a
 * new authentication token that will expire timeToLive seconds after the currentTime. If the token is renewed, the expiry
 * time will be extended to expire timeToLive seconds after the (potentially different) currentTime.
 *
 * Implement the AuthenticationManager class:
 *
 * AuthenticationManager(int timeToLive) constructs the AuthenticationManager and sets the timeToLive.
 * generate(string tokenId, int currentTime) generates a new token with the given tokenId at the given currentTime in seconds.
 * renew(string tokenId, int currentTime) renews the unexpired token with the given tokenId at the given currentTime in seconds.
 * If there are no unexpired tokens with the given tokenId, the request is ignored, and nothing happens.
 * countUnexpiredTokens(int currentTime) returns the number of unexpired tokens at the given currentTime.
 * Note that if a token expires at time t, and another action happens on time t (renew or countUnexpiredTokens), the expiration takes place before the other actions.
 */
public class AuthenticationManager {
    private int timeToLive;
    private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();

    public AuthenticationManager(int timeToLive) {

        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {

        map.put(tokenId, currentTime + this.timeToLive);
    }

    public void renew(String tokenId, int currentTime) {

        if (!map.containsKey(tokenId))
            return;

        int expireTime = map.get(tokenId);

        if (expireTime <= currentTime) {
            map.remove(tokenId);
            return;
        }

        map.put(tokenId, currentTime + this.timeToLive);
    }

    public int countUnexpiredTokens(int currentTime) {

        int count = 0;

        for (String key : map.keySet()) {

            int expireTime = map.get(key);
            if (expireTime > currentTime)
                count++;
            else
                map.remove(key);
        }
        return count;
    }
}
