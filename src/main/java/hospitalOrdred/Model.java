package hospitalOrdred;

import java.util.Objects;

public class Model {
    private String name;//наименование
    private double orderedQuantity;//заказанное количество * количество таблеток в упаковке
    private double releasedQuantity;// отпущенное количество * количество таблеток в упаковке
    private int numericQuantity;// количество таблеток в упаковке
    private String division;// подразделение

    public String getName() {
        return name;
    }

    public int getNumericQuantity() {
        return numericQuantity;
    }

    public void setNumericQuantity(int numericQuantity) {
        this.numericQuantity = numericQuantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(double orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public double getReleasedQuantity() {
        return releasedQuantity;
    }

    public void setReleasedQuantity(double releasedQuantity) {
        this.releasedQuantity = releasedQuantity;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (!Objects.equals(name, model.name)) return false;
        return Objects.equals(division, model.division);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (division != null ? division.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Model{" +
                "Наименование='" + name + '\'' +
                ", Заказано=" + orderedQuantity +
                ", Полученно=" + releasedQuantity +
                ", подразделение='" + division + '\'' +
                '}';
    }
}
