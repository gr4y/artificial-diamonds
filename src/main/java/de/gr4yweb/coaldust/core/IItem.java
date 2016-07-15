package de.gr4yweb.coaldust.core;

/**
 * The reason why this interface exists is just me wanting to maintain a certain level of sanity and project structure.
 * In fact it just makes sense to me to add the recipies for the given Item or Block from within the Class.
 */
public interface IItem {

    /**
     * To register your Item or Block in {@link net.minecraftforge.fml.common.registry.GameRegistry}
     * or {@link net.minecraftforge.oredict.OreDictionary}
     */
    void registerItem();

    /**
     * Register all your Item Recipies
     */
    void registerRecipes();

    /**
     * Register all your Item Models
     */
    void registerModels();

}
