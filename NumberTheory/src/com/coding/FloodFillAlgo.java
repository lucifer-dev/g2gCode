package com.coding;

public class FloodFillAlgo {
    int[][] floodFillAlgo(int[][] pixels, int xCoordinate, int yCoordinate, int xSize, int ySize, int baseColor,
                          int color) {

        pixels[xCoordinate][yCoordinate] = color;

        if ((xCoordinate + 1 >= 0 && xCoordinate + 1 <= xSize) && (yCoordinate >= 0 && yCoordinate <= ySize)) {
            if (pixels[xCoordinate + 1][yCoordinate] == baseColor) {
                floodFillAlgo(pixels, xCoordinate + 1, yCoordinate, xSize, ySize, baseColor, color);
            }
        }
        if ((xCoordinate - 1 >= 0 && xCoordinate - 1 <= xSize) && (yCoordinate >= 0 && yCoordinate <= ySize)) {
            if (pixels[xCoordinate - 1][yCoordinate] == baseColor) {
                floodFillAlgo(pixels, xCoordinate - 1, yCoordinate, xSize, ySize, baseColor, color);
            }
        }
        if ((xCoordinate >= 0 && xCoordinate <= xSize) && (yCoordinate + 1 >= 0 && yCoordinate + 1 <= ySize)) {
            if (pixels[xCoordinate][yCoordinate + 1] == baseColor) {
                floodFillAlgo(pixels, xCoordinate, yCoordinate + 1, xSize, ySize, baseColor, color);
            }
        }
        if ((xCoordinate >= 0 && xCoordinate <= xSize) && (yCoordinate - 1 >= 0 && yCoordinate - 1 <= ySize)) {
            if (pixels[xCoordinate][yCoordinate - 1] == baseColor) {
                floodFillAlgo(pixels, xCoordinate, yCoordinate - 1, xSize, ySize, baseColor, color);
            }
        }

        return pixels;
    }

    private static void printScreen(int[][] pixels, int xCoordinate, int yCoordinate) {
        for (int x = 0; x <= xCoordinate; x++) {
            for (int y = 0; y <= yCoordinate; y++) {
                System.out.print(pixels[x][y] + " ");
            }
            System.out.print("\n");
        }
    }
}
