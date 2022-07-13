package com.example.parkingLot.factory;

import com.example.parkingLot.enums.InputAction;
import com.example.parkingLot.service.IActionTaker;
import com.example.parkingLot.service.IInputCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class InputCreatorFactory {

    private final List<IInputCreator> inputCreators;
    private Map<InputAction, IInputCreator> inputCreatorMap;

    @Autowired
    public InputCreatorFactory(List<IInputCreator> inputCreators) {
        this.inputCreators = inputCreators;
        createInputCreatorMap();
    }

    private void createInputCreatorMap() {
        inputCreatorMap = new HashMap<>();
        for (IInputCreator inputCreator : inputCreators) {
            inputCreatorMap.put(inputCreator.getInputAction(), inputCreator);
        }
    }

    public IInputCreator getInputCreator(InputAction inputAction) {
        return Optional.ofNullable(inputCreatorMap.get(inputAction))
                .orElseThrow(() -> new RuntimeException("ACTION NOT FOUND"));
    }
}
