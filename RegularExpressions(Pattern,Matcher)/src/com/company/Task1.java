package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1
{
    public static void main(String[] args)
    {
        int kod = 0;
        Scanner in = new Scanner(System.in);
        String str = "\tMrs Dursley was thin and blonde!!! Had nearly twice the usual amount of neck.\n" +
                " Which came in very useful as she spent so much of her time craning over garden fences, spying on the neighbors.\n" +
                " The Dursleys had a small son called Dudley and in their opinion there was no finer boy anywhere.\u2029\n" +
                "\tMr Dursley was the director of a firm called Grunnings, which made drills.\n" +
                " He was a big, beefy man with hardly any neck... He did have a very large mustache.\u2029\n" +
                "\tMr and Mrs Dursley, of number four, Privet Drive, were proud to say that they were perfectly normal, thank you very much.\n" +
                " They were the last people you’d expect to be involved in anything strange or mysterious, because they just didn’t hold with such nonsense!";
        do {
            System.out.println("Input '1' - to sort paragraphs by number of sentences.\n" +
                    "Input '2' - to sort sentences by length.\n" +
                    "Input '3' - to sort lexemes in a sentence in descending order of the number of occurrences of a given character.\n" +
                    "Input any other number - in order not to sort the text.");
            kod = in.nextInt();
            switch (kod) {
                case 1:
                    System.out.println("\nSOURCE TEXT:\n" + str);
                    ParagraphSort(str);
                    break;
                case 2:
                    System.out.println("\nSOURCE TEXT:\n" + str);
                    LengthSort(str);
                    break;
                case 3:
                    System.out.println("\nSOURCE TEXT:\n" + str);
                    LexemSort(str);
                    break;
                default:
                    System.out.println("\nSOURCE TEXT:\n" + str);
                    break;
            }
            System.out.println( "\nPress '1' for REPEAT..." +
                                "Press any other number - for EXIT...");
            kod = in.nextInt();
        }while(kod == 1);
    }

    public static void ParagraphSort( String str)
    {
        int kol = 0;
        int kol2 = 0;
        Pattern pattern = Pattern.compile("[$\u2029]\n*");
        Pattern pattern1 = Pattern.compile("[!?.]+");
        String[] strings = pattern.split(str);
        for (int i = 0; i < strings.length - 1; i++) {
            Matcher matcher = pattern1.matcher(strings[i]);
            while(matcher.find())
            {
                kol++;
            }
            matcher = pattern1.matcher(strings[i + 1]);
            while(matcher.find())
            {
                kol2++;
            }
            if( kol > kol2 )
            {
                String temp = strings[i];
                strings[i] = strings[i + 1];
                strings[i + 1] = temp;
                kol = 0;
                kol2 = 0;
                if( i != 0)
                {
                    i = i - 2;
                }
            }
        }
        for (int i = 1; i < strings.length; i++) {
            strings[i] = "\u2029\n" + strings[i];
        }
        StringBuilder builder = new StringBuilder();
        for(String s : strings) {
            builder.append(s);
        }
        String new_str = builder.toString();
        System.out.println("\nPARAGRAPH SORTING:\n" + new_str);
    }

    public static void LengthSort(String str)
    {
        int i = 0;
        String lengthsorttext = str;
        Pattern pattern = Pattern.compile("[.?!]+\\s*");
        String temp_str = str.replaceAll("[\t\u2029\n]","");
        String[] sentence = pattern.split(temp_str);
        Pattern pattern1 = Pattern.compile(",*\\s+,*");
        do {
            String[] words = pattern1.split(sentence[i]);
            Pattern pattern2 = Pattern.compile(sentence[i]);
            Matcher matcher = pattern2.matcher(lengthsorttext);
            for (int j = 0; j < words.length - 1; j++) {
                if (words[j].length() > words[j + 1].length()) {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                    if (j != 0) {
                        j = j - 2;
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < words.length; j++) {
                if(j != words.length - 1) {
                    builder.append(words[j] + " ");
                }
                else
                {
                    builder.append(words[j]);
                }
            }
            String s = builder.toString();
            lengthsorttext = matcher.replaceAll(s);
            i++;
        }while(i != sentence.length);
        System.out.println("\nSORTED BY WORD LENGTH IN SENTENCES TEXT:\n" + lengthsorttext);
    }

    public static void LexemSort(String str)
    {
        Scanner in = new Scanner(System.in);
        int i = 0;
        String lexemessorttext = str;
        Pattern pattern = Pattern.compile("[.?!]+\\s*");
        String temp_str = str.replaceAll("[\t\u2029\n]","");
        String[] sentence = pattern.split(temp_str);
        Pattern pattern1 = Pattern.compile(",*\\s+,*");
        System.out.println( "\nInput a character by the number of occurrences of which the offers will be sorted:");
        String symbol = in.nextLine();
        System.out.println( "Symbol: '" + symbol + "'");
        do {
            String[] words = pattern1.split(sentence[i]);
            Pattern pattern2 = Pattern.compile(sentence[i]);
            Matcher matcher = pattern2.matcher(lexemessorttext);
            Pattern patternsymbol = Pattern.compile(symbol);
            for (int j = 0; j < words.length - 1; j++) {
                int kol = 0;
                int kolnext = 0;
                Matcher matchersymbol = patternsymbol.matcher(words[j]);
                while (matchersymbol.find())
                {
                    kol++;
                }
                matchersymbol = patternsymbol.matcher(words[j + 1]);
                while (matchersymbol.find())
                {
                    kolnext++;
                }
                if (kol < kolnext) {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                    if (j != 0) {
                        j = j - 2;
                    }
                }
                if (kol == kolnext)
                {
                    for (int k = 0; k < words[j].length() && k < words[j + 1].length(); k++) {
                        int a;
                        int b;
                        if(((Character.isUpperCase(words[j].charAt(k)) && Character.isLowerCase(words[j + 1].charAt(k)))
                                || (Character.isUpperCase(words[j + 1].charAt(k)) && Character.isLowerCase(words[j].charAt(k))))
                                && Character.toLowerCase(words[j].charAt(k)) != Character.toLowerCase(words[j + 1].charAt(k)))
                        {
                            a = (int)Character.toLowerCase(words[j].charAt(k));
                            b = (int)Character.toLowerCase(words[j + 1].charAt(k));
                        }
                        else
                        {
                            a = (int)words[j].charAt(k);
                            b = (int)words[j + 1].charAt(k);

                        }
                        if (a > b)
                        {
                            String temp = words[j];
                            words[j] = words[j + 1];
                            words[j + 1] = temp;
                            if (j != 0) {
                                j = j - 2;
                            }
                            break;
                        }
                        if (a < b)
                        {
                            break;
                        }
                        if ((a == b) && (k == (words[j + 1].length() - 1)) && (k != (words[j].length() - 1)))
                        {
                            String temp = words[j];
                            words[j] = words[j + 1];
                            words[j + 1] = temp;
                            if (j != 0) {
                                j = j - 2;
                            }
                            break;
                        }
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < words.length; j++) {
                if(j != words.length - 1) {
                    builder.append(words[j] + " ");
                }
                else
                {
                    builder.append(words[j]);
                }
            }
            String s = builder.toString();
            lexemessorttext = matcher.replaceAll(s);
            i++;
        }while(i != sentence.length);
        System.out.println("\nSORTED LEXEMES IN OFFERS IN DESCENDING ORDER OF OCCURRENCES OF THIS SYMBOL, AND IN CASE OF EQUALITY - ALPHABETICALLY :\n" + lexemessorttext);
    }
}

