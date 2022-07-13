package com.example.parkingLot.service;

import com.example.parkingLot.enums.InputAction;
import com.example.parkingLot.factory.ActionTakerFactory;
import com.example.parkingLot.factory.InputCreatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CommandLineInterpreter implements CommandLineRunner {

    private final ActionTakerFactory actionTakerFactory;
    private final InputCreatorFactory inputCreatorFactory;

    private static final String EXIT = "exit";

    @Autowired
    public CommandLineInterpreter(ActionTakerFactory actionTakerFactory, InputCreatorFactory inputCreatorFactory) {
        this.actionTakerFactory = actionTakerFactory;
        this.inputCreatorFactory = inputCreatorFactory;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Start Providing commands: Enter exit to exit");
        Scanner scanner = new Scanner(System.in);
        String line;
        while (!Objects.equals(EXIT, line = scanner.nextLine())) {
            String[] input = line.split(" ");
            InputAction inputAction = InputAction.getInputAction(input[0]);
            List<String> inputList = new ArrayList<>(Arrays.asList(input));
            inputList.remove(0);
            IInputCreator inputCreator = inputCreatorFactory.getInputCreator(inputAction);
            IActionTaker actionTaker = actionTakerFactory.getActionTaker(inputAction);
            System.out.println(actionTaker.takeAction(inputCreator.createInput(inputList.toArray(new String[0]))));
        }
    }
}
