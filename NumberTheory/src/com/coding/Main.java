package com.coding;

public class Main {

    public static void main(String[] args) {
        int [][] pixels = {{1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0}, {1, 2, 2, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0}, {1, 1, 1, 2, 2, 0, 1, 0}, {1, 1, 1, 2, 2, 2, 2, 0}, {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };

        int color = 3;
        int xCoordinate = 4, yCoordinate = 4;
        int xSize = 7, ySize = 7;
        int baseColor = pixels[xCoordinate][yCoordinate];

        FloodFillAlgo floodFillAlgo = new FloodFillAlgo();
        printScreen(pixels, xSize, ySize);
        System.out.print("\n********************\n\n");
        pixels = floodFillAlgo.floodFillAlgo(pixels, xCoordinate, yCoordinate, xSize, ySize, baseColor, color);
        printScreen(pixels, xSize, ySize);
    }

    public static  void printScreen(int [][] pixels, int xCoordinate, int yCoordinate) {
        for(int x=0;x<=xCoordinate;x++) {
            for(int y=0;y<=yCoordinate;y++) {
                System.out.print(pixels[x][y] + " ");
            }
            System.out.print("\n");
        }
    }
}
