package com.comp301.a09nonograms;

import static org.junit.Assert.assertTrue;

import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.controller.ControllerImpl;
import com.comp301.a09nonograms.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/** Unit test for simple App. */
public class AppTest {
  /** Rigorous Test :-) */
  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  @Test
  public void testBoard() {
    int[][] rowClues =
            new int[][] {
                    new int[] {0, 3},
                    new int[] {0, 4},
                    new int[] {0, 3},
                    new int[] {1, 1},
                    new int[] {0, 1}
            };

    int[][] colClues =
            new int[][] {
                    new int[] {2, 1},
                    new int[] {0, 2},
                    new int[] {0, 4},
                    new int[] {0, 2},
                    new int[] {0, 2},
            };
    Clues example = new CluesImpl(rowClues, colClues);

    List<Clues> clues = new ArrayList<>();
    clues.add(example);

    Model model = new ModelImpl(clues);
    model.toggleCellShaded(0,0);
    model.toggleCellShaded(0, 1);
    model.toggleCellShaded(0,2);

    model.toggleCellShaded(1,0);
    model.toggleCellShaded(1,1);
    model.toggleCellShaded(1,2);
    model.toggleCellShaded(1,4);

    model.toggleCellShaded(2,0);
    model.toggleCellShaded(2,2);
    model.toggleCellShaded(2,3);

    model.toggleCellShaded(3,3);
    model.toggleCellShaded(3,4);

    model.toggleCellShaded(4,2);

    System.out.println(model.isSolved());
  }

  @Test
  public void test1() {
    int[][] rowClues =
            new int[][] {
                    new int[] {0, 2},
                    new int[] {1, 2},
                    new int[] {0, 3},
                    new int[] {0, 3},
                    new int[] {1, 1},
            };

    int[][] colClues =
            new int[][] {
                    new int[] {1, 1},
                    new int[] {0, 1},
                    new int[] {0, 3},
                    new int[] {0, 3},
                    new int[] {3, 1},
            };

    Clues example = new CluesImpl(rowClues, colClues);
    List<Clues> clues = new ArrayList<>();
    clues.add(example);

    Model model = new ModelImpl(clues);
    model.toggleCellShaded(0, 3);
    model.toggleCellShaded(0, 4);

    model.toggleCellShaded(1, 0);
    model.toggleCellShaded(1, 3);
    model.toggleCellShaded(1, 4);

    model.toggleCellShaded(2, 2);
    model.toggleCellShaded(2, 3);
    model.toggleCellShaded(2, 4);

    model.toggleCellShaded(3, 0);
    model.toggleCellShaded(3, 1);
    model.toggleCellShaded(3, 2);

    model.toggleCellShaded(4, 2);
    model.toggleCellShaded(4, 4);

    System.out.println(model.isSolved());
  }

  @Test
  public void testController() {
    Model model = new ModelImpl(PuzzleLibrary.create());
    Controller controller = new ControllerImpl(model);
    controller.nextPuzzle();
    System.out.println(controller.getPuzzleIndex());
    controller.nextPuzzle();
    System.out.println(controller.getPuzzleIndex());
    controller.nextPuzzle();
    System.out.println(controller.getPuzzleIndex());
    controller.nextPuzzle();
    System.out.println(controller.getPuzzleIndex());
    controller.nextPuzzle();
    System.out.println(controller.getPuzzleIndex());
    //System.out.println(controller.getClues().getColClues(0)[3]);
  }

}
