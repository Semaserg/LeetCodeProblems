package LeetCode.design.UniqueWordAbbreviation_288;

import java.util.HashMap;
import java.util.HashSet;

/**
 https://leetcode.com/problems/unique-word-abbreviation/
 288. Unique Word Abbreviation

 An abbreviation of a word follows the form <first letter><number><last letter>.
 Below are some examples of word abbreviations:

 a) it                      --> it    (no abbreviation)

 1
 b) d|o|g                   --> d1g

 1    1  1
 1---5----0----5--8
 c) i|nternationalizatio|n  --> i18n

 1
 1---5----0
 d) l|ocalizatio|n          --> l10n
 Assume you have a dictionary and given a word, find whether its abbreviation is
 unique in the dictionary. A word's abbreviation is unique if no other word from
 the dictionary has the same abbreviation.

 Example:
 Given dictionary = [ "deer", "door", "cake", "card" ]

 isUnique("dear") ->
 false

 isUnique("cart") ->
 true

 isUnique("cane") ->
 false

 isUnique("make") ->
 true
 */
public class ValidWordAbbr {
    HashMap<String,String> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String w : dictionary) {
            String abbr = calcAbbr(w);
            if (map.containsKey(abbr) && !map.get(abbr).equals(w)) {
                map.put(abbr, ""); // error in dictionary
            } else {
                map.put(calcAbbr(w), w);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = calcAbbr(word);
        return  (map.containsKey(abbr) && map.get(abbr).equals(word) || !map.containsKey(abbr));
    }

    private String calcAbbr(String word) {
        if (word.length() <= 2) return word;
        return Character.toString(word.charAt(0)) + (word.length()-2) + Character.toString(word.charAt(word.length()-1));
    }
}
