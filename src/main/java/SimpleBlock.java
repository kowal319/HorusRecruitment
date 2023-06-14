import java.util.Collections;
import java.util.List;
import java.util.Optional;

class SimpleBlock implements Block {
    private String color;
    private String material;

    public SimpleBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if (this.color.equals(color)) {
            return Optional.of(this);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (this.material.equals(material)) {
            return Collections.singletonList(this);
        } else {
            return Collections.emptyList();
        }
    }
}
