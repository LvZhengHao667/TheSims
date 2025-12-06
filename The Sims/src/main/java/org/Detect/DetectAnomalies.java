package org.Detect;

import java.util.Scanner;

public class DetectAnomalies {
    public String Detect(){
        while (true) {
            Scanner text = new Scanner(System.in);
            String texts = String.valueOf(text.nextLine());
            if (texts != null && !texts.isEmpty()) {
                return texts;
            } else {
                System.out.println("You have entered no content. Please re-enter.");
            }
        }


    }}

