import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;


    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block block : blocks) {
            if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
            if (block instanceof CompositeBlock) {
                CompositeBlock compositeBlock = (CompositeBlock) block;
                Optional<Block> result = compositeBlock.findBlockByColor(color);
                if (result.isPresent()) {
                    return result;
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> result = new ArrayList<>();
        for (Block block : blocks) {
            if (block.getMaterial().equals(material)) {
                result.add(block);
            }
            if (block instanceof CompositeBlock) {
                CompositeBlock compositeBlock = (CompositeBlock) block;
                List<Block> subBlocks = compositeBlock.findBlocksByMaterial(material);
                result.addAll(subBlocks);
            }
        }
        return result;
    }

    @Override
    public int count() {
        int totalCount = 0;
        for (Block block : blocks) {
            totalCount++;
            if (block instanceof CompositeBlock) {
                CompositeBlock compositeBlock = (CompositeBlock) block;
                totalCount += compositeBlock.getBlocks().size();
            }
        }
        return totalCount;
    }
    }
