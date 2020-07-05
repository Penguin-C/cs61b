public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> res = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        Palindrome p = new Palindrome();
        Deque d = p.wordToDeque(word);
        return is_helper(d);
    }

    private boolean is_helper(Deque d) {
        if (d.size() <= 1) {
            return true;
        }
        if (!d.removeFirst().equals(d.removeLast())) {
            return false;
        }
        return is_helper(d);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Palindrome p = new Palindrome();
        Deque d = p.wordToDeque(word);
        return is_helper(d, cc);
    }

    private boolean is_helper(Deque d, CharacterComparator cc) {
        if (d.size() <= 1) {
            return true;
        }
        if (!cc.equalChars((char) d.removeFirst(), (char) d.removeLast())) {
            return false;
        }
        return is_helper(d, cc);
    }
}
