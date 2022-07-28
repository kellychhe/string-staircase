package com.tlglearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Defines the {@link #buildLinearStaircase(int)} and {@link #buildFibonacciStaircase(int)} methods,
 * which construct and return {@code String} arrays forming staircases of asterisks and space
 * characters.
 */
public final class Staircase {

  private Staircase() {
    // NOTE: There is NO need to do anything with this constructor! The methods you will implement
    // in this class are static; thus, there is no need to create instances of this class. Making
    // the constructor private prevents this class from being instantiated, and prevents a compiler-
    // generated default from being generated (and from being documented by Javadoc).
  }

  /* LINEAR STAIRCASE */

  /**
   * Constructs and returns an array of strings, where the first element is the top step of the
   * staircase, containing a single asterisk (*), right-aligned (that is, padded on the left with
   * spaces, as necessary), and each successive element is a string containing one more asterisk
   * than the previous. The final string in the array should have {@code height} asterisk
   * characters, without any leading spaces.
   *
   * @param height Staircase height (number of steps).
   * @return       Array of length {@code height}.
   */
  public static String[] buildLinearStaircase(int height) {
    int index = height;
    String[] staircase = new String[height];
    char[] stair = new char[height];
    Arrays.fill(stair, ' ');
    while (index > 0) {
      stair[index - 1] = '*';
      String completedStair = String.valueOf(stair);
      staircase[height - index] = completedStair;
      index--;
    }
    return staircase;
  }

  /* FIBONACCI STAIRCASE */

  /**
   * Constructs and returns an array of strings, where the first element is the top step of the
   * staircase, containing a single asterisk (*), right-aligned (that is, padded on the left with
   * spaces, as necessary); the second element also has a single asterisk, right-aligned
   * (left-padded); each successive element is a string containing a number of asterisks equal to
   * the sum of the number of asterisks in the previous 2 elements. For example, the 3<sup>rd</sup>
   * element will have (1 + 1) = 2 asterisks; the 4<sup>th</sup> will have (2 + 1) = 3 asterisks;
   * etc. The last element of the array should contain nothing but asterisks.
   *
   * @param height Staircase height (number of steps).
   * @return       Array of length {@code height}.
   */
  public static String[] buildFibonacciStaircase(int height) {
    int count = 0;
    String[] staircase = new String[height];
    int[] fibonacci = new int[height];
    while (count < height){
      if (count == 0 || count == 1){
        fibonacci[count] = 1;
      } else {
        fibonacci[count] = fibonacci[count - 2] + fibonacci[count - 1];
      }
      count++;
    }
    while (count > 0) {
      int index = count - 1;
      String completedStair = " ".repeat(fibonacci[height-1] - fibonacci[index]) + "*".repeat(fibonacci[index]);
      staircase[index] = completedStair;
      count--;
    }
    return staircase;
  }

}
