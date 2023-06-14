import java.util.Collection;
import java.util.List;
import java.util.Optional;

interface CompositeBlock extends Block {
    List<Block> getBlocks();
}
