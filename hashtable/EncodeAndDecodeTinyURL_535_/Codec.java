package LeetCode.hashtable.EncodeAndDecodeTinyURL_535_;

/*
535. Encode and Decode TinyURL
https://leetcode.com/problems/encode-and-decode-tinyurl/#/description

TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
 and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service.
There is no restriction on how your encode/decode algorithm should
work. You just need to ensure that a URL can be encoded to a
tiny URL and the tiny URL can be decoded to the original URL.
* */

import java.util.HashMap;

// Great solution and explanation
//https://discuss.leetcode.com/topic/81637/two-solutions-and-thoughts
// https://discuss.leetcode.com/topic/81637/two-solutions-and-thoughts/3
public class Codec {
    int counter = 0;
    private HashMap<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        counter++;
        map.put(String.valueOf(counter), longUrl);
        return String.valueOf(counter);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (!map.containsKey(shortUrl)) return "";
        return map.get(shortUrl);
    }
}