package com.excercise.practice.auxiliary;

import java.util.Scanner;

public class ConsoleReader {

    private final Scanner scanner = new Scanner(System.in);

    public String readRequiredProperty(String info) {
        String property = "";
        while("".equals(property)){
            System.out.println(info);
            property = fetchInput();
        }
        return property;
    }

    public String readOptionalProperty(String info){
        System.out.println(info);
        String property = fetchInput();
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
