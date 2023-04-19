package nme.cs209a.lab10;

import com.google.gson.annotations.SerializedName;

public class PokemonAbility {
  @SerializedName("is_hidden")
  public boolean isHidden;
  public int slot;
  public NamedAPIResource ability;
}
