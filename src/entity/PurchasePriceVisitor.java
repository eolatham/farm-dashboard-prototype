package entity;

public class PurchasePriceVisitor extends ItemComponentVisitor {
  private int total = 0; // dollars

  public void visit(ItemComponent itemComponent) {
    total += itemComponent.getPurchasePrice();
    for (ItemComponent c : itemComponent.getComponents()) visit(c);
  }

  public int value() {
    return total;
  }
}
