package strategy.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import model.Operation;
import strategy.OperationHandler;

public class Returns implements OperationHandler {
    @Override
    public Map<String, Integer> getInterimSettlement(List<FruitTransaction> fruitsTransactionData) {
        return fruitsTransactionData.stream()
                .filter(s -> s.getOperation().equals(Operation.RETURN.getOperation()))
                .collect(Collectors.toMap(FruitTransaction::getFruit, FruitTransaction::getQuantity,
                        Integer::sum));
    }
}