package com.excercise.practice.auxiliary;

import java.util.Scanner;

public class ConsoleReader {

    private Scanner scanner = new Scanner(System.in);

    public String readRequiredProperty(String info) {
        String property = "";
        while(property.equals("")){
            System.out.println(info);
            property = (scanner.nextLine()).trim();
        }
        return property;
    }

    public String readOptionalProperty(String info){
        System.out.println(info);
        String property = (scanner.nextLine()).trim();
        if(!"".equals(property)) {
            return property;
        } else{
            return "empty";
        }
    }

    public int readDecision(){
        return Integer.parseInt(scanner.nextLine());
    }

    public String fetchInput() {
        return (scanner.nextLine()).trim();
    }
}
