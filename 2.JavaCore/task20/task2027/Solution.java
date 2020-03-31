package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'h', 'e', 'e', 's', 's', 'k'},
                {'o', 'o', 'a', 'm', 'h', 'o'},
                {'h', 'm', 'm', 'e', 'a', 'v'},
                {'e', 'e', 'a', 'e', 'm', 's'},
                {'s', 'a', 'm', 'e', 'e', 'j'}
        };
        System.out.println(detectAllWords(crossword, "home", "same"));

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> wordArrayList = new ArrayList<>();
        for (String word: words
             ) {
            char[] wordChar = word.toCharArray();
                for (int i = 0; i < crossword.length; i++) {
                    for (int j = 0; j < crossword[0].length; j++) {
                        if (crossword[i][j] == wordChar[0]){
                            int count = 1;
                            int startX = j;
                            int startY = i;
                            for (int k = 1; k < 9; k++) {
                                switch (k){
                                    case (1):
                                        if ((i - (wordChar.length-1)) < 0){
                                            continue;
                                        }
                                        for (int l = 1; l < wordChar.length; l++) {
                                                if (wordChar[l] == crossword[i - l][j]) count++;
                                                if (l == wordChar.length - 1 && count == wordChar.length) {
                                                    Word word1 = new Word(word);
                                                    word1.setStartPoint(startX, startY);
                                                    word1.setEndPoint(startX, startY - l);
                                                    wordArrayList.add(word1);
                                                }
                                                if (l == wordChar.length - 1) count = 1;
                                            }
                                        break;
                                    case (2):
                                        if ((i + (wordChar.length-1)) > crossword.length - 1){
                                            continue;
                                        }
                                        for (int l = 1; l < wordChar.length; l++) {
                                            if (wordChar[l] == crossword[i + l][j]) count++;
                                            if (l == wordChar.length - 1 && count == wordChar.length) {
                                                Word word1 = new Word(word);
                                                word1.setStartPoint(startX, startY);
                                                word1.setEndPoint(startX, startY + l);
                                                wordArrayList.add(word1);
                                            }
                                            if (l == wordChar.length - 1) count = 1;
                                        }
                                        break;
                                    case (3):
                                        if ((j - (wordChar.length-1)) < 0){
                                            continue;
                                        }
                                        for (int l = 1; l < wordChar.length; l++) {
                                            if (wordChar[l] == crossword[i][j-l]) count++;
                                            if (l == wordChar.length - 1 && count == wordChar.length) {
                                                Word word1 = new Word(word);
                                                word1.setStartPoint(startX, startY);
                                                word1.setEndPoint(startX-l, startY );
                                                wordArrayList.add(word1);
                                            }
                                            if (l == wordChar.length - 1) count = 1;
                                        }
                                        break;
                                    case (4):
                                        if ((j + (wordChar.length-1)) > crossword[i].length-1){
                                            continue;
                                        }
                                        for (int l = 1; l < wordChar.length; l++) {
                                            if (wordChar[l] == crossword[i][j+l]) count++;
                                            if (l == wordChar.length - 1 && count == wordChar.length) {
                                                Word word1 = new Word(word);
                                                word1.setStartPoint(startX, startY);
                                                word1.setEndPoint(startX+l, startY );
                                                wordArrayList.add(word1);
                                            }
                                            if (l == wordChar.length - 1) count = 1;
                                        }
                                        break;
                                    case (5):
                                        if ((i -(wordChar.length-1)) < 0 || (j - (wordChar.length-1) < 0)){
                                            continue;
                                        }
                                        for (int l = 1; l < wordChar.length; l++) {
                                            if (wordChar[l] == crossword[i-l][j-l]) count++;
                                            if (l == wordChar.length - 1 && count == wordChar.length) {
                                                Word word1 = new Word(word);
                                                word1.setStartPoint(startX, startY);
                                                word1.setEndPoint(startX-l, startY-l);
                                                wordArrayList.add(word1);
                                            }
                                            if (l == wordChar.length - 1) count = 1;
                                        }
                                        break;
                                    case (6):
                                        if ((i + (wordChar.length-1)) > crossword.length -1 || (j + (wordChar.length-1) > crossword[i].length- 1)){
                                            continue;
                                        }
                                        for (int l = 1; l < wordChar.length; l++) {
                                            if (wordChar[l] == crossword[i+l][j+l]) count++;
                                            if (l == wordChar.length - 1 && count == wordChar.length) {
                                                Word word1 = new Word(word);
                                                word1.setStartPoint(startX, startY);
                                                word1.setEndPoint(startX+l, startY+l);
                                                wordArrayList.add(word1);
                                            }
                                            if (l == wordChar.length - 1) count = 1;
                                        }
                                        break;
                                    case (7):
                                        if ((i - (wordChar.length-1)) < 0 || (j + (wordChar.length-1) > crossword[i].length- 1)){
                                            continue;
                                        }
                                        for (int l = 1; l < wordChar.length; l++) {
                                            if (wordChar[l] == crossword[i-l][j+l]) count++;
                                            if (l == wordChar.length - 1 && count == wordChar.length) {
                                                Word word1 = new Word(word);
                                                word1.setStartPoint(startX, startY);
                                                word1.setEndPoint(startX+l, startY-l);
                                                wordArrayList.add(word1);
                                            }
                                            if (l == wordChar.length - 1) count = 1;
                                        }
                                        break;
                                    case (8):
                                        if ((i + (wordChar.length-1)) > crossword.length -1 || (j - (wordChar.length-1) < 0)){
                                            continue;
                                        }
                                        for (int l = 1; l < wordChar.length; l++) {
                                            if (wordChar[l] == crossword[i+l][j-l]) count++;
                                            if (l == wordChar.length - 1 && count == wordChar.length) {
                                                Word word1 = new Word(word);
                                                word1.setStartPoint(startX, startY);
                                                word1.setEndPoint(startX-l, startY+l);
                                                wordArrayList.add(word1);
                                            }
                                            if (l == wordChar.length - 1) count = 1;
                                        }
                                        break;
                                }
                            }
                        }
                    }
                }

        }
        return wordArrayList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endY;
        private int endX;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
