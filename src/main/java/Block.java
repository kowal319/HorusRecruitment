import java.util.List;
import java.util.Optional;

interface Block {
    String getColor();
    String getMaterial();

    Optional<Block> findBlockByColor(String color);

    List<Block> findBlocksByMaterial(String material);
}
