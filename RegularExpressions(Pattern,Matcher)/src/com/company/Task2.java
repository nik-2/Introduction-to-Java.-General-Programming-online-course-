package com.company;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        String str = "<notes>\n" +
                " <note id = \"1\">\n" +
                "  <to>Вася</to>\n" +
                "  <from>Света</from>\n" +
                "  <heading>Напоминание</heading>\n" +
                "  <body>Позвони мне завтра!</body>\n" +
                " </note>\n" +
                " <note id = \"2\">\n" +
                "  <to>Петя</to>\n" +
                "  <from>Маша</from>\n" +
                "  <heading>Важное напоминание</heading>\n" +
                "  <body/>\n" +
                " </note>\n" +
                "</notes>";
        String str_temp = str;
        String tag_name = new String();
        String attribute = new String();
        String open_tag = new String();
        String close_tag;
        Matcher matcher_start;
        int start = 0;
        int end = 0;
        System.out.println("\tSource text:\n" + str);
        do {
            Pattern pattern_start = Pattern.compile("( *(<(([a-z0-9]*)([a-z0-9\"\\s=]*)/?)>)\n*)");
            matcher_start = pattern_start.matcher(str_temp);
            System.out.println("\n\tNode description:");
            if (matcher_start.find()) {
                open_tag = matcher_start.group(2);
                tag_name = matcher_start.group(4);
                attribute = matcher_start.group(5);
                System.out.println("Opening tag: " + open_tag);
                start = matcher_start.end(1);
            }
            Pattern pattern_end = Pattern.compile("(\n* *(</(" + tag_name + ")>)\n*)");
            Matcher matcher_end = pattern_end.matcher(str_temp);
            if (matcher_end.find()) {
                close_tag = matcher_end.group(2);
                System.out.println("Closing tag: " + close_tag);
                end = matcher_end.start(1);
            }
            System.out.println("His name: " + tag_name);
            if(!attribute.equals(""))
            {
                attribute = attribute.replaceFirst(" ","");
                System.out.println( "Attribute: " + attribute);
            }
            if(!open_tag.equals("<" + tag_name + attribute + "/>")) {
                String str_text = str_temp.substring(start, end);
                System.out.println("\n\tNode content: \n" + str_text);
            }
            else
            {
                System.out.println("\"BLANK TAG!\"");
            }
            str_temp = str_temp.replaceFirst("( *(<(([a-z0-9]*)([a-z0-9\"\\s=]*)/?)>)\n*)", "");
            str_temp = str_temp.replaceFirst("(\n* *(</(" + tag_name + ")>)\n*)","");
        }while (matcher_start.find());
    }
}