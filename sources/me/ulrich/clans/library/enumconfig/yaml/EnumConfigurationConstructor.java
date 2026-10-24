package me.ulrich.clans.library.enumconfig.yaml;

import me.ulrich.clans.library.enumconfig.library.LoaderOptions;
import me.ulrich.clans.library.enumconfig.library.constructor.SafeConstructor;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.nodes.Node;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/yaml/EnumConfigurationConstructor.class */
public class EnumConfigurationConstructor extends SafeConstructor {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/yaml/EnumConfigurationConstructor$ConstructCustomObject.class */
    private class ConstructCustomObject extends SafeConstructor.ConstructYamlMap {
        private ConstructCustomObject() {
            super();
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.SafeConstructor.ConstructYamlMap, me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public Object construct(Node node) {
            if (node.isTwoStepsConstruction()) {
                throw new YAMLException("Unexpected referential mapping structure. Node: " + node);
            }
            return super.construct(node);
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.SafeConstructor.ConstructYamlMap, me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            throw new YAMLException("Unexpected referential mapping structure. Node: " + node);
        }
    }

    public EnumConfigurationConstructor() {
        super(setupOptions());
        this.yamlConstructors.put(Tag.MAP, new ConstructCustomObject());
    }

    private static LoaderOptions setupOptions() {
        LoaderOptions loaderOptions = new LoaderOptions();
        loaderOptions.setTagInspector(tag -> {
            return tag.equals(Tag.MAP) || tag.equals(Tag.STR) || tag.equals(Tag.INT) || tag.equals(Tag.FLOAT) || tag.equals(Tag.BOOL) || tag.equals(Tag.SEQ);
        });
        return loaderOptions;
    }
}
