package com.udacity;

public class Joker {

    public static String getJoke(){

        final int joke = (int)(System.currentTimeMillis() / 1000) % 10;

        switch (joke){
            case 0:
                return "A SQL query goes into a bar, walks up to two tables and asks, \"Can I join you?\"";
            case 1:
                return "What is the difference between Android 2.1 and 2.2?\n\n" +"6 months";
            case 2:
                return "An Android app walks into a bar. Bartender asks, \"Can I get you a drink?\n\n" + "The app looks disappointed and says, \"That wasnt my intent.\"";
            case 3:
                return "Two Android phone are walking in the desert. Which of them is 2.2?\n\n"+ "The one who called \"Froyo\".";
            case 4:
                return "Once a programmer drowned in the sea. Many Marines where at that time on the beach, but the programmer was shouting \"F1 F1\" and nobody understood it.";
            case 5:
                return "Eight bytes walk into a bar.  The bartender asks, \"Can I get you anything?\"\n\n" + "\"Yeah,\" reply the bytes.  \"Make us a double.\"";
            case 6:
                return "How many programmers does it take to change a light bulb?\n\n" + "None. Its a hardware problem";
            case 7:
                return "Why do programmers always mix up Halloween and Christmas?\n\n" + "Because Oct 31 equals Dec 25";
            case 8:
                return "Programming is like sex:\n\n" + "One mistake and you have to support it for the rest of your life";
            case 9:
                return "There are three kinds of lies:\n\n" + "Lies, damned lies, and benchmarks";
            default:
                return "Cant find any good jokes, sorry...";
        }
    }
}
