package kolichestvoProdag;

import java.util.Objects;

public class Model {
    private String name;
    private String lgota;
    private int kol;

    public String getLgota() {
        return lgota;
    }

    public void setLgota(String lgota) {
        this.lgota = lgota;
    }

    public int getKol() {
        return kol;
    }

    public void setKol(int kol) {
        this.kol = kol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (!Objects.equals(name, model.name)) return false;
        return Objects.equals(lgota, model.lgota);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lgota != null ? lgota.hashCode() : 0);
        return result;
    }

}
