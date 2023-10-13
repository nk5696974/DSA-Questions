class Solution {
    public boolean isAnagram(String s, String t) {
        // char []charA = s.toCharArray();
        // char []charB = t.toCharArray();

        // Arrays.sort(charA);
        // Arrays.sort(charB);

        // return Arrays.equals(charB, charA);

        if(s.length() != t.length())
            return false;

        int []count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for(char c : t.toCharArray()) {
            if(count[c-'a'] == 0)
                return false;
            count[c- 'a']--;
        }

        return true;
    }
}