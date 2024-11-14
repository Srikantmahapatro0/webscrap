package com.webscrap.webscrap.Service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class Searchservice {
    class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord;
    }
@Service
    public class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children.get(c);
                if (node == null) {
                    return false;
                }
            }
            return node.isEndOfWord;
        }

        public List<String> autocomplete(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                node = node.children.get(c);
                if (node == null) {
                    return new ArrayList<>();
                }
            }
            return findWords(node, prefix);
        }

        private List<String> findWords(TrieNode node, String prefix) {
            List<String> words = new ArrayList<>();
            if (node.isEndOfWord) {
                words.add(prefix);
            }
            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                words.addAll(findWords(entry.getValue(), prefix + entry.getKey()));
            }
            return words;
        }
    }

}
