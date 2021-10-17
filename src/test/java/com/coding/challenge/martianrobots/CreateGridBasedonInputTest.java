package com.coding.challenge.martianrobots;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateGridBasedonInputTest {

  @Test
  @DisplayName("Test if the Upper Right Corner of the Grid is parsed properly from the Input")
  public void testUpperRightCornerOfTheGrid() throws IOException {
    // Given
    CreateGridBasedonInput createGridBasedonInput =
            new CreateGridBasedonInput("src/test/resources/sampleInput.txt");
    Point expectedUpperRightBoundary = new Point(5, 3);
    // When
    Point point = createGridBasedonInput.generateInitialSetUp();

    // Then
    assertEquals(expectedUpperRightBoundary, point);
  }






}
