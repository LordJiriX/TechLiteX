package io.github.lordjirix.techlitex.api.block;

public interface IRecipeRunnable {
  int getTimeToRunRecipe();

  int getCurrentRunTime();

  int getRFPerTick();
}
