import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WallTest {
    private Wall wall;
    private List<Block> blocks;

    @BeforeEach
    void setUp() {
        blocks = new ArrayList<>();
        blocks.add(new SimpleBlock("red", "wood"));
        blocks.add(new SimpleBlock("blue", "stone"));
        blocks.add(new SimpleBlock("green", "wood"));
        blocks.add(new SimpleBlock("red", "stone"));
        blocks.add(new SimpleBlock("yellow", "wood"));
        wall = new Wall(blocks);
    }

    @Test
    void findBlockByColor_existingColor_returnsBlock() {
        Optional<Block> block = wall.findBlockByColor("blue");
        assertTrue(block.isPresent());
        assertEquals("blue", block.get().getColor());
        assertEquals("stone", block.get().getMaterial());
    }

    @Test
    void findBlockByColor_nonExistingColor_returnsEmpty() {
        Optional<Block> block = wall.findBlockByColor("black");
        assertFalse(block.isPresent());
    }

    @Test
    void findBlocksByMaterial_existingMaterial_returnsBlocks() {
        List<Block> result = wall.findBlocksByMaterial("wood");
        assertEquals(3, result.size());
        for (Block block : result) {
            assertEquals("wood", block.getMaterial());
        }
    }

    @Test
    void findBlocksByMaterial_nonExistingMaterial_returnsEmptyList() {
        List<Block> result = wall.findBlocksByMaterial("steel");
        assertTrue(result.isEmpty());
    }

    @Test
    void count_returnsNumberOfBlocks() {
        int count = wall.count();
        assertEquals(5, count);
    }
}
