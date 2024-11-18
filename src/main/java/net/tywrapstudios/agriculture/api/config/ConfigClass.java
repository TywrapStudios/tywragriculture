package net.tywrapstudios.agriculture.api.config;

/**
 * A base interface that should be implemented by every Config class.
 * @author Tiazzz
 */
public interface ConfigClass {
    /**
     * Validates the config, can be overridden by the implementing class for custom validation logic.
     */
    void validate();
}
