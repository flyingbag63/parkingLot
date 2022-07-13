package com.example.parkingLot.factory;

import com.example.parkingLot.enums.InputAction;
import com.example.parkingLot.service.IActionTaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ActionTakerFactory {

    private final List<IActionTaker> actionTakers;
    private Map<InputAction, IActionTaker> actionTakerMap;

    @Autowired
    public ActionTakerFactory(List<IActionTaker> actionTakers) {
        this.actionTakers = actionTakers;
        createActionTakerMap();
    }

    private void createActionTakerMap() {
        actionTakerMap = new HashMap<>();
        for (IActionTaker actionTaker : actionTakers) {
            actionTakerMap.put(actionTaker.getInputAction(), actionTaker);
        }
    }

    public IActionTaker getActionTaker(InputAction inputAction) {
        return Optional.ofNullable(actionTakerMap.get(inputAction))
                .orElseThrow(() -> new RuntimeException("ACTION NOT FOUND"));
    }
}
